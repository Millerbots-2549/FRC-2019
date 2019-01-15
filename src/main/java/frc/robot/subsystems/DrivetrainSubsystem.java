package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;


public class DrivetrainSubsystem extends Subsystem {

    private PWMTalonSRX motorLeft;
    private PWMTalonSRX motorRight;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private DifferentialDrive robotDrive = new DifferentialDrive(motorLeft, motorRight);

    public DrivetrainSubsystem() {

        motorLeft = new PWMTalonSRX(RobotMap.motorLeft);
        motorRight = new PWMTalonSRX(RobotMap.motorRight);

    }

    public void initDefaultCommand() {

        // TODO: Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }

    public void drive(double left, double right, boolean quickTurn) {
        robotDrive.curvatureDrive(left, right, quickTurn);
    }

}

