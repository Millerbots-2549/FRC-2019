package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import frc.robot.RobotMap;
import frc.robot.commands.hatch.HatchPeriodic;

public class HatchSubsystem extends Subsystem {
    //  possible replace entire subsystem with a PID subsystem

    //private DoubleSolenoid solenoid;
    private WPI_TalonSRX motor;

//    private double _speed = .5;

    public HatchSubsystem() {
        motor = new WPI_TalonSRX(RobotMap.HATCH_MOTOR);
//        solenoid = new DoubleSolenoid(RobotMap.HATCH_SOL_FWD, RobotMap.HATCH_SOL_REV);

        motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
                0,
                30);

        motor.config_kP(0, 0.1);

        motor.setSelectedSensorPosition(0, 0, 30);

        motor.configForwardSoftLimitEnable(true);
        motor.configReverseSoftLimitEnable(true);
        motor.configForwardSoftLimitThreshold(15000);
        motor.configReverseSoftLimitThreshold(0);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new HatchPeriodic());
    }

//    public void extend() {
//        solenoid.set(DoubleSolenoid.Value.kReverse);
//        System.out.println("Hatch extended");
//    }
//
//    public void retract() {
//        solenoid.set(DoubleSolenoid.Value.kForward);
//        System.out.println("Hatch retract");
//    }
//
//    public void solenoidOff() {
//        solenoid.set(DoubleSolenoid.Value.kOff);
//        System.out.println("Hatch solenoid off");
//    }

    public void driveSlide(double n) {
//        SmartDashboard.putNumber("Hatch Motor", n*_speed);
//        SmartDashboard.putNumber("Hatch Position", getPos());

        motor.set(n);
    }

    public void goToPosition(int position) {
        motor.set(ControlMode.Position, position);
    }

    public int getPos() {
        return motor.getSelectedSensorPosition();
    }

    public void resetEncoder() {
        motor.setSelectedSensorPosition(0, 0, 30);
        motor.configForwardSoftLimitThreshold(15000);
        motor.configReverseSoftLimitThreshold(0);
    }

    public void resetEncoder(boolean forward) {
        if(forward) {
            motor.setSelectedSensorPosition(15000, 0, 30);

        }
        else if(!forward) {
            motor.setSelectedSensorPosition(0, 0, 30);

        }
        motor.configForwardSoftLimitThreshold(15000);
        motor.configReverseSoftLimitThreshold(0);
    }

    public void stop() {
        motor.stopMotor();
    }

    public void PID() {

    }
}

