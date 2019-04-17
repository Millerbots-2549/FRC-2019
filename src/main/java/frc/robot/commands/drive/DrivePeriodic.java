package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DrivePeriodic extends Command {

    private double deadzone = 0.1;
    private boolean turnInPlace = false;
    private double drive = 0;
    private double turn = 0;

    public DrivePeriodic() {
       super (DrivePeriodic.class.getSimpleName());
       requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        System.out.println("Drivetrain initialized");
}

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

        drive = Robot.oi.getAxisDrive();
        turn = Robot.oi.getAxisTurn();
//
//        if(Robot.oi.getAxisDrive() >= deadzone || Robot.oi.getAxisDrive() <= -deadzone) {
//            turnInPlace = false;
//            turn = Robot.oi.getAxisTurn();
//        }
//        else if(Robot.oi.getAxisDrive() <= deadzone && Robot.oi.getAxisDrive() >= -deadzone){
//            turnInPlace = true;
//            turn = Robot.oi.getAxisTurnInPlace();
//        }

        // curve
        //Robot.drivetrain.driveCurve(drive, turn, turnInPlace);

        // arcade
        Robot.drivetrain.driveArcade(-drive, turn);

        SmartDashboard.putNumber("left enc", Robot.drivetrain.getLeftEnc());
        SmartDashboard.putNumber("right enc", Robot.drivetrain.getRightEnc());
        SmartDashboard.putNumber("Heading", Robot.drivetrain.getHeading());
        SmartDashboard.putNumber("range", Robot.drivetrain.getDistance());

//        SmartDashboard.putBoolean("turn in place", turnInPlace);
//        SmartDashboard.putNumber("drive axis", drive);
   }


    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
