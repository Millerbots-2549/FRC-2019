package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.HatchCommand;

public class HatchSubsystem extends Subsystem {
    //  possible replace entire subsystem with a PID subsystem

    private DoubleSolenoid solenoid;
    private WPI_TalonSRX motor;

    private double speed = 1;
    private int encMax = 7500;
    private int encMin = -7500;
    private int encRange = encMax - encMin;
    private int encSlowMargin = 4000;

    public HatchSubsystem() {
        motor = new WPI_TalonSRX(RobotMap.HATCH_MOTOR);
        solenoid = new DoubleSolenoid(RobotMap.HATCH_SOL_FWD, RobotMap.HATCH_SOL_REV);

    }

    public void initDefaultCommand() {
        setDefaultCommand(new HatchCommand());
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


        SmartDashboard.putNumber("Hatch Motor", n*speed);
        SmartDashboard.putNumber("Hatch Position", getPos());

        if(getPos() >= encMax) {
            n = (n > 0 ? 0 : n);
            //n = (1 - (getPos() / encMax)) * speed;
        }
        else if(getPos() <= encMin) {
            n = (n > 0 ? n : 0);
            //n = (1 - (getPos() / encMin)) * speed;
        }


        motor.set(n*speed);
    }

    public void setRightMax() {
        encMax = getPos();
        encMin = encMax - encRange;
        SmartDashboard.putNumber("Hatch Right Max", encMax);
        SmartDashboard.putNumber("Hatch Left Max", encMin);
    }

    public void setLeftMax() {
        encMin = getPos();
        encMax = encMin + encRange;
        SmartDashboard.putNumber("Hatch Left Max", encMin);
        SmartDashboard.putNumber("Hatch Right Max", encMax);
    }

    public int getPos() {
        return motor.getSelectedSensorPosition();
    }

}

