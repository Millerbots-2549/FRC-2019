package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;


public class ClimbSubsystem extends Subsystem {


    //Motors
    private DoubleSolenoid frontClimbDoubleNoid = new DoubleSolenoid(RobotMap.CLIMB_FRONT_SOL_FWD, RobotMap.CLIMB_FRONT_SOL_REV);
    private DoubleSolenoid backClimbDoubleNoid = new DoubleSolenoid(RobotMap.CLIMB_BACK_SOL_FWD, RobotMap.CLIMB_BACK_SOL_REV);

    public ClimbSubsystem(){
    }

    @Override
    protected void initDefaultCommand() {

    }

}