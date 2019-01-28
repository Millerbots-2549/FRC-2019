package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeCommand;

public class IntakeSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    // TODO: Create Solenoid

    // TODO: Create Motor

    // TODO: move initialization to constructor
    private DoubleSolenoid doubleSolenoid = new DoubleSolenoid(RobotMap.intakeSolenoidForward, RobotMap.intakeSolenoidReverse);

    // TODO: create constructor

    public void initDefaultCommand() {
        // TODO: Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new IntakeCommand());
    }

    public void raiseElevator(){
        doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void lowerElevator(){
        doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
}

