package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

public class DrivetrainSubsystem extends Subsystem {

    // Motors
    private WPI_TalonSRX motorLeft0;
    private WPI_TalonSRX motorLeft1;
    private WPI_TalonSRX motorRight2;
    private WPI_TalonSRX motorRight3;

    // Motor groups AKA left and right side
    private SpeedControllerGroup motorsLeft;
    private SpeedControllerGroup motorsRight;

    // Robot drive base
    private DifferentialDrive robotDrive;

    public DrivetrainSubsystem() {
        motorLeft0 = new WPI_TalonSRX(RobotMap.motorLeft0);
        motorLeft1 = new WPI_TalonSRX(RobotMap.motorLeft1);
        motorRight2 = new WPI_TalonSRX(RobotMap.motorRight2);
        motorRight3 = new WPI_TalonSRX(RobotMap.motorRight3);

        motorsLeft = new SpeedControllerGroup(motorLeft0, motorLeft1);
        motorsLeft.setInverted(false);
        motorsRight = new SpeedControllerGroup(motorRight2, motorRight3);
        motorsRight.setInverted(false);

        robotDrive = new DifferentialDrive(motorsLeft, motorsRight);
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

