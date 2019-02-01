package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeCommand;

public class IntakeSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    // TODO: Create Motor

    // TODO: move initialization to constructor
    private DoubleSolenoid doubleSolenoid;

    // TODO: create constructor

    public IntakeSubsystem() {
        doubleSolenoid = new DoubleSolenoid(RobotMap.intake_sol_fwd, RobotMap.intake_sol_rev);
    }

    public void initDefaultCommand() {
        // TODO: Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new IntakeCommand());
    }

    public void raise(){
        doubleSolenoid.set(DoubleSolenoid.Value.kForward);
        System.out.println("Intake raise");
    }

    public void lower(){
        doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
        System.out.println("Intake rower");
    }

    public void solenoidOff() {
        doubleSolenoid.set(DoubleSolenoid.Value.kOff);
        System.out.println("Intake solenoid off");
    }
}

