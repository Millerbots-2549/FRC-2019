package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.PathfinderFRC;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

import java.io.IOException;

public class DrivePath extends Command {

    // https://github.com/JacisNonsense/Pathfinder/wiki/Pathfinder-for-FRC---Java


    // TODO: measure these things
    // Path finding
    private static final int k_tpr_left = 1024; // no idea
    private static final int k_tpr_right = 1024; // no idea
    private static final double k_wheel_diameter = 0.1524; // 6 inches
    private static final double k_max_velocity = 10; // no idea

    private static final String k_path_name = "path";

    private EncoderFollower m_follower_left;
    private EncoderFollower m_follower_right;
    private Notifier m_follower_notifier;

    private Trajectory trajectory_left;
    private Trajectory trajectory_right;

    public DrivePath() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }


    /**
     * The initialize method is called just before the first time
     * this Command is run after being started.
     */
    @Override
    protected void initialize() {
        try {
            trajectory_left = PathfinderFRC.getTrajectory(k_path_name + ".left");
            trajectory_right = PathfinderFRC.getTrajectory(k_path_name + ".right");
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        m_follower_left = new EncoderFollower(trajectory_left);
        m_follower_right = new EncoderFollower(trajectory_right);

        // configure
        m_follower_left.configureEncoder(Robot.drivetrain.getLeftEnc(), k_tpr_left, k_wheel_diameter);
        m_follower_right.configureEncoder(Robot.drivetrain.getRightEnc(), k_tpr_right, k_wheel_diameter);

        // TODO: configure PID valueeeeees
        m_follower_left.configurePIDVA(0.0, 0.0, 0.0, 1 / k_max_velocity, 0);
        m_follower_right.configurePIDVA(0.0, 0.0, 0.0, 1 / k_max_velocity, 0);

        m_follower_notifier = new Notifier(this::followPath);
        m_follower_notifier.startPeriodic(trajectory_left.get(0).dt);
    }

    private void followPath() {
        if(m_follower_left.isFinished() || m_follower_right.isFinished()) {
            m_follower_notifier.stop();
        }
        else {
            double speed_left = m_follower_left.calculate(Robot.drivetrain.getLeftEnc());
            double speed_right = m_follower_right.calculate(Robot.drivetrain.getRightEnc());

            double heading = Robot.drivetrain.getHeading();
            double desired_heading = Pathfinder.r2d(m_follower_left.getHeading());
            double heading_difference = Pathfinder.boundHalfDegrees(desired_heading - heading);
            double turn = 0.8 * (-1.0/80.0) * heading_difference;

            Robot.drivetrain.driveTank(speed_left + turn, speed_right - turn);
        }
    }

    /**
     * The execute method is called repeatedly when this Command is
     * scheduled to run until this Command either finishes or is canceled.
     */
    @Override
    protected void execute() {

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
        m_follower_notifier.stop();
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
