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

}