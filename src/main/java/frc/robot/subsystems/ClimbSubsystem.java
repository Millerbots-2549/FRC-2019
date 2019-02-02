package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;
import frc.robot.commands.ClimbCommand;
import edu.wpi.first.wpilibj.DoubleSolenoid;


public class ClimbSubsystem extends Subsystem {


    //Motors
    //TODO: Parameters?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
    private DoubleSolenoid frontClimbDoubleNoid = new DoubleSolenoid(RobotMap.climbFront_sol_fwd, RobotMap.climbFront_sol_rev);
    private DoubleSolenoid backClimbDoubleNoid = new DoubleSolenoid(RobotMap.climbBack_sol_fwd, RobotMap.climbBack_sol_rev);

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