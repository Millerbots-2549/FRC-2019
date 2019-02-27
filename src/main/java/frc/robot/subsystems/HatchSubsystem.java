package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.RobotMap;
import frc.robot.commands.actions.hatch.HatchPeriodic;

public class HatchSubsystem extends Subsystem {
    //  possible replace entire subsystem with a PID subsystem

    private DoubleSolenoid solenoid;
    private WPI_TalonSRX motor;

    private double _speed = 1;
    private int _encMax = 7500;
    private int _encMin = -7500;
    private int _encRange = _encMax - _encMin;
    private int encSlowMargin = 4000;

    public HatchSubsystem() {
        motor = new WPI_TalonSRX(RobotMap.HATCH_MOTOR);
        solenoid = new DoubleSolenoid(RobotMap.HATCH_SOL_FWD, RobotMap.HATCH_SOL_REV);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new HatchPeriodic());
    }

    public void extend() {
        solenoid.set(DoubleSolenoid.Value.kReverse);
        System.out.println("Hatch extended");
    }

    public void retract() {
        solenoid.set(DoubleSolenoid.Value.kForward);
        System.out.println("Hatch retract");
    }

    public void solenoidOff() {
        solenoid.set(DoubleSolenoid.Value.kOff);
        System.out.println("Hatch solenoid off");
    }

    public void driveSlide(double n) {
        SmartDashboard.putNumber("Hatch Motor", n*_speed);
        SmartDashboard.putNumber("Hatch Position", getPos());

        // too far left too far right stops
        if(getPos() >= _encMax) {
            n = (n > 0 ? 0 : n);
            //n = (1 - (getPos() / encMax)) * speed;
        }
        else if(getPos() <= _encMin) {
            n = (n > 0 ? n : 0);
            //n = (1 - (getPos() / encMin)) * speed;
        }

        motor.set(ControlMode.PercentOutput, n*_speed);
    }

    public void goToPosition(int position) {
        motor.set(ControlMode.Position, position);
    }

    public void setRightMax() {
        _encMax = getPos();
        _encMin = _encMax - _encRange;
        SmartDashboard.putNumber("Hatch Right Max", _encMax);
        SmartDashboard.putNumber("Hatch Left Max", _encMin);
    }

    public void setLeftMax() {
        _encMin = getPos();
        _encMax = _encMin + _encRange;
        SmartDashboard.putNumber("Hatch Left Max", _encMin);
        SmartDashboard.putNumber("Hatch Right Max", _encMax);
    }

    public int getPos() {
        return motor.getSelectedSensorPosition();
    }

    public void PID() {

    }
}

