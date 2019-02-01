package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;
import frc.robot.commands.HatchCommand;

public class HatchSubsystem extends Subsystem {

    DoubleSolenoid hatchNoidOne;

    WPI_TalonSRX hatchMotor;
    //TODO: Motor
    //TODO: Solanoid 2 Pistons
    //TODO: Encoders

    public HatchSubsystem() {
        hatchMotor = new WPI_TalonSRX(RobotMap.motorHatch);
        hatchNoidOne = new DoubleSolenoid(RobotMap.intakeSolenoidForward, RobotMap.intakeSolenoidReverse);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new HatchCommand());
    }

    // temporary manual control
    public void move(double speed) {
        hatchMotor.set(speed);
    }

    public void out() {
        hatchNoidOne.set(DoubleSolenoid.Value.kReverse);
        System.out.println("Hatch out");
    }

    public void in() {
        hatchNoidOne.set(DoubleSolenoid.Value.kForward);
        System.out.println("Hatch in");
    }

    public void off() {
        hatchNoidOne.set(DoubleSolenoid.Value.kOff);
        System.out.println("Hatch off");
    }
}

