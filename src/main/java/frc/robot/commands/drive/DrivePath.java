package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.subsystems.DrivetrainSubsystem;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.PathfinderFRC;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.file.Path;

public class DrivePath extends Command {

    // https://github.com/JacisNonsense/Pathfinder/wiki/Pathfinder-for-FRC---Java


    // TODO: measure these things
    // Path finding
    private static final int k_tpr_left = 330; // no idea
    private static final int k_tpr_right = 60; // no idea
    private static final double k_wheel_diameter = 0.1524; // 6 inches
    private static final double k_wheel_base_width = 0.6096; // which unit?
    private static final double k_max_velocity = 1.0;  // no idea

    private static final String k_path_name = "test_path";

    private String m_path_name;
    private boolean m_reversed;

    private EncoderFollower m_follower_left;
    private EncoderFollower m_follower_right;

    private TankModifier modifier;
    private Trajectory m_trajectory_left;
    private Trajectory m_trajectory_right;
    private Trajectory m_trajectory;

    public DrivePath(Trajectory trajectory, boolean reversed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
//        m_path_name = path_name;
        m_trajectory = trajectory;
        m_reversed = reversed;
    }


    /**
     * The initialize method is called just before the first time
     * this Command is run after being started.
     */
    @Override
    protected void initialize() {
        modifier = new TankModifier(m_trajectory).modify(k_wheel_base_width);

        System.out.println("Path following initialized");

//        m_follower_left = new EncoderFollower(m_trajectory_left);
//        m_follower_right = new EncoderFollower(m_trajectory_right);

        m_follower_left = new EncoderFollower(modifier.getLeftTrajectory());
        m_follower_right = new EncoderFollower(modifier.getRightTrajectory());

        // configure
        m_follower_left.configureEncoder(Robot.drivetrain.getLeftEnc(), k_tpr_left, k_wheel_diameter);
        m_follower_right.configureEncoder(Robot.drivetrain.getRightEnc(), k_tpr_right, k_wheel_diameter);

        // TODO: configure PID valueeeeees
        m_follower_left.configurePIDVA(1.0, 0.0, 0.0, 1 / k_max_velocity, 0);
        m_follower_right.configurePIDVA(1.0, 0.0, 0.0, 1 / k_max_velocity, 0);
    }

    /**
     * The execute method is called repeatedly when this Command is
     * scheduled to run until this Command either finishes or is canceled.
     */
    @Override
    protected void execute() {
        double speed_left = m_follower_left.calculate(Robot.drivetrain.getLeftEnc());
        double speed_right = m_follower_right.calculate(Robot.drivetrain.getRightEnc());

        double heading = Robot.drivetrain.getHeading();
        double desired_heading = Pathfinder.r2d(m_follower_left.getHeading());
        double heading_difference = Pathfinder.boundHalfDegrees(desired_heading - heading);
        double turn = 0.8 * (-1.0/80.0) * heading_difference;

        if(m_reversed)
            Robot.drivetrain.driveTank(speed_left + turn, speed_right - turn, 0.5);
        else
            Robot.drivetrain.driveTank(-(speed_right - turn), -(speed_left + turn), 0.5);
    }


    /**
     * <p>
     * Returns whether this command is finished. If it is, then the command will be removed and
     * {@link #end()} will be called.
     * </p><p>
     * It may be useful for a team to reference the {@link #isTimedOut()}
     * method for time-sensitive commands.
     * </p><p>
     * Returning false will result in the command never ending automatically. It may still be
     * cancelled manually or interrupted by another command. Returning true will result in the
     * command executing once and finishing immediately. It is recommended to use
     * {@link edu.wpi.first.wpilibj.command.InstantCommand} (added in 2017) for this.
     * </p>
     *
     * @return whether this command is finished.
     * @see Command#isTimedOut() isTimedOut()
     */
    @Override
    protected boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return m_follower_left.isFinished() || m_follower_right.isFinished();
    }


    /**
     * Called once when the command ended peacefully; that is it is called once
     * after {@link #isFinished()} returns true. This is where you may want to
     * wrap up loose ends, like shutting off a motor that was being used in the
     * command.
     */
    @Override
    protected void end() {
        Robot.drivetrain.driveTank(0, 0);
    }


    /**
     * <p>
     * Called when the command ends because somebody called {@link #cancel()} or
     * another command shared the same requirements as this one, and booted it out. For example,
     * it is called when another command which requires one or more of the same
     * subsystems is scheduled to run.
     * </p><p>
     * This is where you may want to wrap up loose ends, like shutting off a motor that was being
     * used in the command.
     * </p><p>
     * Generally, it is useful to simply call the {@link #end()} method within this
     * method, as done here.
     * </p>
     */
    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
