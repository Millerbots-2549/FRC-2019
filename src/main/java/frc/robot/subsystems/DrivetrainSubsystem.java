package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;
import frc.robot.commands.actions.drive.DrivePeriodic;
import edu.wpi.first.wpilibj.Encoder;

public class DrivetrainSubsystem extends Subsystem {

    //Encoders
    private Encoder encoderLeft;
    private Encoder encoderRight;

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
        // TalonSRX configuration
        motorLeft0 = new WPI_TalonSRX(RobotMap.MOTOR_LEFT_0);
        motorLeft1 = new WPI_TalonSRX(RobotMap.MOTOR_LEFT_1);
        motorRight2 = new WPI_TalonSRX(RobotMap.MOTOR_RIGHT_2);
        motorRight3 = new WPI_TalonSRX(RobotMap.MOTOR_RIGHT_3);

//        motorLeft0.configFactoryDefault();
//        motorLeft1.configFactoryDefault();
//        motorRight2.configFactoryDefault();
//        motorRight3.configFactoryDefault();

        motorLeft0.setSafetyEnabled(true);
        motorLeft1.setSafetyEnabled(true);
        motorRight2.setSafetyEnabled(true);
        motorRight3.setSafetyEnabled(true);

        motorLeft0.setExpiration(.2);
        motorLeft1.setExpiration(.2);
        motorRight2.setExpiration(.2);
        motorRight3.setExpiration(.2);

        // Speed controller group configuration
        motorsLeft = new SpeedControllerGroup(motorLeft0, motorLeft1);
        motorsRight = new SpeedControllerGroup(motorRight2, motorRight3);

        motorsLeft.setInverted(false);
        motorsRight.setInverted(false);

        robotDrive = new DifferentialDrive(motorsLeft, motorsRight);

        // Encoder configuration
        //encoderLeft = new Encoder(RobotMap.ODOMETER_LEFT[0], RobotMap.ODOMETER_LEFT[1]);
        //encoderRight = new Encoder(RobotMap.ODOMETER_RIGHT[2], RobotMap.ODOMETER_RIGHT[3]);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DrivePeriodic());
    }

    // Motors
    public void driveArcade(double speed, double rotation) {
        robotDrive.arcadeDrive(speed, rotation);
    }
    public void driveTank(double left, double right) {
        robotDrive.tankDrive(left, right);
    }
    public void driveCurve(double speed, double rotation, boolean t) {
        robotDrive.curvatureDrive(speed, rotation, t);
    }

    // Sensors
    public int getDistance(){
        return 0;//encoderLeft.get() + encoderRight.get() / 2;
        // returns average distance from encoders, AKA encleft + encright / 2
    }
}
