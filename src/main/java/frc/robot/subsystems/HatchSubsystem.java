package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;
import frc.robot.commands.HatchCommand;

public class HatchSubsystem extends Subsystem {
    // TODO: possible replace entire subsystem with a PID subsystem

    private DoubleSolenoid solenoid;
    private WPI_TalonSRX motor;
    // TODO: declare encoder

    public HatchSubsystem() {
        motor = new WPI_TalonSRX(RobotMap.motorHatch);
        solenoid = new DoubleSolenoid(RobotMap.intakeSolenoidForward, RobotMap.intakeSolenoidReverse);
        // TODO: initialize encoder
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
}

