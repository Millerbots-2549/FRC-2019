package frc.robot.commands.hatch;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;


public class SearchForTarget extends Command {

    double integral, previous_error, setpoint = 0;

    public SearchForTarget() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        //requires(Robot.hatch);
//        requires(Robot.vision);
    }


    /**
     * The initialize method is called just before the first time
     * this Command is run after being started.
     */
    @Override
    protected void initialize() {
        System.out.println("Searching for hatch target");


    }


    /**
     * The execute method is called repeatedly when this Command is
     * scheduled to run until this Command either finishes or is canceled.
     */
    @Override
    protected void execute() {

        double error = -(0 - Robot.vision.getHatchX());
        integral += (error * .02);
        if (Math.abs(error) < .001)
            integral = 0;

        Robot.hatch.driveSlide(0.065 * error);// + 0.01 * ((previous_error - error) / .02));//0.08*integral);

        previous_error = error;

        SmartDashboard.putNumber("Error", error);
        SmartDashboard.putNumber("Hatch x", Robot.vision.getHatchX());
        SmartDashboard.putNumber("Integral", integral);

        SmartDashboard.putNumber("range", Robot.drivetrain.getDistance());

        //System.out.println(Robot.vision.getHatchX());

//        int target = Robot.vision.camResX()/2;
//        int actual = target;
//        boolean isNegative = false;
//        double error = 0;
//
//        if(Robot.vision.getX() < 160){
//            isNegative = false;
//            actual = Robot.vision.camResX() - Robot.vision.getX();
//        }
//        else if(Robot.vision.getX() > 160){
//            isNegative  = true;
//            actual = Robot.vision.getX();
//        }
//        else actual = 0;
//
//        if(isNegative) error = -(Math.abs(target - actual) / actual);
//        else error = Math.abs(target - actual) / actual;
//
//        if(SmartDashboard.getBoolean("hatch_sensing", false)) {
//            Robot.hatch.driveSlide(error);
//        }
//
//        System.out.println("jhhvhfxvjh");
        //System.out.println(Robot.vision.getCargoX());
        //Robot.hatch.goToPosition();
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
        return false;
    }

    /**
     * Called once when the command ended peacefully; that is it is called once
     * after {@link #isFinished()} returns true. This is where you may want to
     * wrap up loose ends, like shutting off a motor that was being used in the
     * command.
     */
    @Override
    protected void end() {
        Robot.hatch.stop();
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
