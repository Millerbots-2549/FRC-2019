package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;
import frc.robot.commands.drive.DrivePeriodic;

public class DrivetrainSubsystem extends Subsystem {

    // Sensors
    private Encoder encoderLeft;
    private Encoder encoderRight;
    private ADXRS450_Gyro gyro;
    private AnalogInput ultrasonic;

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

        motorLeft0.setExpiration(.3);
        motorLeft1.setExpiration(.3);
        motorRight2.setExpiration(.3);
        motorRight3.setExpiration(.3);

        // Speed controller group configuration
        motorsLeft = new SpeedControllerGroup(motorLeft0, motorLeft1);
        motorsRight = new SpeedControllerGroup(motorRight2, motorRight3);

        motorsLeft.setInverted(false);
        motorsRight.setInverted(false);

        robotDrive = new DifferentialDrive(motorsLeft, motorsRight);

        // Sensor configuration
        encoderLeft = new Encoder(RobotMap.ENCODER_LEFT[0], RobotMap.ENCODER_LEFT[1]);
        encoderRight = new Encoder(RobotMap.ENCODER_RIGHT[0], RobotMap.ENCODER_RIGHT[1]);
        encoderLeft.setReverseDirection(false);
        encoderRight.setReverseDirection(true);

        gyro = new ADXRS450_Gyro();

        ultrasonic = new AnalogInput(RobotMap.ULTRASOUND);
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
    public void driveTank(double left, double right, double speedMult) {
        robotDrive.tankDrive(left*speedMult, right*speedMult);
    }
    public void driveCurve(double speed, double rotation, boolean t) {
        robotDrive.curvatureDrive(speed, rotation, t);
    }

    public double getLeftSide() {
        return this.motorsLeft.get();
    }
    public double getRightSide() {
        return this.motorsRight.get();
    }

    public int getLeftEnc() {
        return this.encoderLeft.get();
    }
    public int getRightEnc() {
        return this.encoderRight.get();
    }
    public double getHeading() {
        return this.gyro.getAngle();
    }
    public void resetSensors() {
        this.encoderLeft.reset();
        this.encoderRight.reset();
        this.gyro.reset();
    }

    public void setSafetyEnabled(boolean safe) {
        motorLeft0.setSafetyEnabled(safe);
        motorLeft1.setSafetyEnabled(safe);
        motorRight2.setSafetyEnabled(safe);
        motorRight3.setSafetyEnabled(safe);
    }

    // Sensors
    public double getDistance(){
        return ultrasonic.getValue();
    }
}
