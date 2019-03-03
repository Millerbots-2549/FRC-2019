package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.actions.intake.IntakePeriodic;

import static frc.robot.Robot.pdp;

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
        if(pdp.getCurrent(13) < 10){
            spinnySpark.set(1);
            System.out.println("running");
        }
        else
        {
            System.out.println("stopping");
            spinnySpark.set(0);
        }
    }
    public void spinOut(){
        spinnySpark.set(-1);
    }
    public void spinStop(){
        spinnySpark.set(0);
    }

}

