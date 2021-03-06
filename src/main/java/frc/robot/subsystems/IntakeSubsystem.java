package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
import frc.robot.commands.intake.IntakePeriodic;

public class IntakeSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands

    public Spark spinnySpark;
    private DoubleSolenoid doubleSolenoid;


    public IntakeSubsystem() {
        doubleSolenoid = new DoubleSolenoid(RobotMap.INTAKE_SOL_FWD, RobotMap.INTAKE_SOL_REV);
        spinnySpark = new Spark(RobotMap.INTAKE_SPARK);
    }


    public void initDefaultCommand() {
        setDefaultCommand(new IntakePeriodic());
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
    public void spinIn() {
        spinnySpark.set(1);
    }
    public void spinOut(){
        spinnySpark.set(-.8);
    }
    public void spinStop(){
        spinnySpark.set(0);
    }

}

