package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

import static frc.robot.Robot.intake;


public class IntakeBall extends Command {

    private boolean spinning = true;
    private double thresh = 18;

    public IntakeBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(intake);
    }


    /**
     * The initialize method is called just before the first time
     * this Command is run after being started.
     */
    @Override
    protected void initialize() {
        Robot.intake.spinIn();
        Timer.delay(.225);
        spinning = true;
    }


    /**
     * The execute method is called repeatedly when this Command is
     * scheduled to run until this Command either finishes or is canceled.
     */
    @Override
    protected void execute() {
        if(Robot.pdp.getCurrent(13) > thresh && spinning) {
            intake.spinStop();
            spinning = false;
        }
        else if(Robot.pdp.getCurrent(13) <= thresh && spinning)
            intake.spinIn();
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
     * {@link } (added in 2017) for this.
     * </p>
     *
     * @return whether this command is finished.
     */
    @Override
    protected boolean isFinished() {
        if(Robot.oi.ctrlManip.getRawButton(5))
            return false;
        else
            return true;
    }



    /**
     * Called once when the command ended peacefully; that is it is called once
     * after {@link #isFinished()} returns true. This is where you may want to
     * wrap up loose ends, like shutting off a motor that was being used in the
     * command.
     */
    @Override
    protected void end() {
        intake.spinStop();
        System.out.println("intake finidhed");
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
