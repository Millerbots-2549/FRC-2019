package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
public class IntakeSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    // TODO: Create Solenoid

    DoubleSolenoid doubleSolenoid = new DoubleSolenoid(RobotMap.intakeSolenoidForward, RobotMap.intakeSolenoidReverse);


    // TODO: Create Motor
    public void initDefaultCommand() {
        // TODO: Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }
    public void raiseElevator(){
        doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void lowerElevator(){
        doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
}

