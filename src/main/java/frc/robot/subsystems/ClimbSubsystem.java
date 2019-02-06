package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.commands.HatchCommand;

public class ClimbSubsystem extends Subsystem {


    //Motors
    private DoubleSolenoid frontClimbDoubleNoid = new DoubleSolenoid(RobotMap.CLIMB_FRONT_SOL_FWD, RobotMap.CLIMB_FRONT_SOL_REV);
    private DoubleSolenoid backClimbDoubleNoid = new DoubleSolenoid(RobotMap.CLIMB_BACK_SOL_FWD, RobotMap.CLIMB_BACK_SOL_REV);

    public ClimbSubsystem(){

    }

    @Override

    public void initDefaultCommand() {
        setDefaultCommand(new HatchCommand());
    }

    public void extendFront(){
        frontClimbDoubleNoid.set(DoubleSolenoid.Value.kReverse);
        System.out.println("Front piston extended");
    }

    public void extendBack(){
        backClimbDoubleNoid.set(DoubleSolenoid.Value.kReverse);
        System.out.println("Back piston extended");
    }

    public void retractFront(){
        frontClimbDoubleNoid.set(DoubleSolenoid.Value.kForward);
        System.out.println("Front piston retracted");
    }

    public void retractBack(){
        backClimbDoubleNoid.set(DoubleSolenoid.Value.kForward);
        System.out.println("Back piston retracted");
    }

    public void solenoidsOff(){
        backClimbDoubleNoid.set(DoubleSolenoid.Value.kOff);
        frontClimbDoubleNoid.set(DoubleSolenoid.Value.kOff);
        System.out.println("Solenoids off");
    }
}