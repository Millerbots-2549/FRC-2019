package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {

    private double deadzone = 0.1;
    private boolean turnInPlace = false;
    private double drive = 0;
    private double turn = 0;

    public DriveCommand() {
       super (DriveCommand.class.getSimpleName());
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

        if(Robot.oi.getAxisDrive() >= deadzone || Robot.oi.getAxisDrive() <= -deadzone) {
            turnInPlace = false;
            turn = Robot.oi.getAxisTurn();
        }
        else if(Robot.oi.getAxisDrive() <= deadzone && Robot.oi.getAxisDrive() >= -deadzone){
            turnInPlace = true;
            //turn = Robot.oi.getAxisTurnInPlace();
        }

        //Robot.drivetrain.driveCurve(drive, turn, turnInPlace);
        Robot.drivetrain.driveArcade(drive, turn);

        SmartDashboard.putBoolean("turn in place", turnInPlace);
        SmartDashboard.putNumber("drive axis", drive);
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
