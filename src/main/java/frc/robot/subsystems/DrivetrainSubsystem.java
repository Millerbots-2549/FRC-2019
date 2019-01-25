package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

public class DrivetrainSubsystem extends Subsystem {

    private WPI_TalonSRX motorLeft;
    private WPI_TalonSRX motorRight;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private DifferentialDrive robotDrive;

    public DrivetrainSubsystem() {
        motorLeft = new WPI_TalonSRX(RobotMap.motorLeft);
        motorRight = new WPI_TalonSRX(RobotMap.motorRight);
        robotDrive = new DifferentialDrive(motorLeft, motorRight);
    }

    public void initDefaultCommand() {

        // TODO: Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveCommand());


    }

    public void drive(double speed, double rotation) {
        robotDrive.arcadeDrive(speed, rotation);
    }

}

