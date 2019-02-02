package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;
import frc.robot.commands.ClimbCommand;

public class ClimberSubsystem extends Subsystem {

    //Motors
    private DoubleSolenoid solenoidFront;
    private DoubleSolenoid solenoidBack;

    public ClimberSubsystem(){
        solenoidFront = new DoubleSolenoid(RobotMap.climbFront_sol_fwd,RobotMap.climbFront_sol_rev);
        solenoidBack = new DoubleSolenoid(RobotMap.climbBack_sol_fwd,RobotMap.climbBack_sol_rev);
    }

    public void extendFront(){
        solenoidFront.set(DoubleSolenoid.Value.kReverse);
        System.out.println("Climb initialized");
    }

    public void extendBack() {
        solenoidBack.set(DoubleSolenoid.Valu.kReverse);
    }


    public void retractFront(){
        solenoidFront.set(DoubleSolenoid.Value.kForward);
        System.out.println("Climb Finishing");
    }

    public void retractBack(){
        solenoidBack.set(DoubleSolenoid.Value.kForward);
    }
    public void solenoidsOff(){
        solenoidFront.set(DoubleSolenoid.Value.kOff);
        solenoidBack.set(DoubleSolenoid.Value.kOff);
        System.out.println("Climb Complete");-
    }
    )
}