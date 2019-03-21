package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;


public class ClimbSubsystem extends Subsystem {

    //lvl 3
    //Motors
    private DoubleSolenoid climbNoid = new DoubleSolenoid(RobotMap.CLIMB_SOL_FWD, RobotMap.CLIMB_SOL_REV);
    private Spark climbSpark = new Spark(RobotMap.CLIMB_SPARK);
    private Talon ClimbWheel = new Talon(RobotMap.CLIMB_WHEEL_SPARK);

    public ClimbSubsystem(){ }

    @Override

    public void initDefaultCommand() {}

    public void driveLift(double speed) {
        climbSpark.set(speed);
    }

    public void driveWheels(double speed) {
        ClimbWheel.set(speed);
    }

    public void extend(){
        climbNoid.set(DoubleSolenoid.Value.kForward);
        System.out.print("Climb piston extended");
    }

    public void retract(){
        climbNoid.set(DoubleSolenoid.Value.kReverse);
        System.out.print("Climb piston retracted");
    }

    public void noidStop(){
        climbNoid.set(DoubleSolenoid.Value.kOff);
        System.out.println("Solenoid off");
    }

    public void raise(){
        climbSpark.set(1);
        System.out.println("Climb moving down");
    }
    public void lower(){
        climbSpark.set(-1);
        System.out.println("Climb moving up");
    }
    public void stopLift(){
        climbSpark.set(0);
        System.out.println("Deadass the motor for climbing that Jack Finn O'Kane made is off now.");
    }
    public void stallLift() {
        climbSpark.set(-.6);
    }
    public void forward(){
        climbSpark.set(0.7);
        System.out.println("Climb wheels moving forward.");
    }
    public void stopWheels(){
        climbSpark.set(0);
        System.out.println("Climb wheels stopped.");
    }
}










    //lvl 2
//    //Motors
//    private DoubleSolenoid frontClimbDoubleNoid = new DoubleSolenoid(RobotMap.CLIMB_FRONT_SOL_FWD, RobotMap.CLIMB_FRONT_SOL_REV);
//    private DoubleSolenoid backClimbDoubleNoid = new DoubleSolenoid(RobotMap.CLIMB_BACK_SOL_FWD, RobotMap.CLIMB_BACK_SOL_REV);
//
//    public ClimbSubsystem(){
//
//    }
//
//    @Override
//
//    public void initDefaultCommand() {
//
//    }
//
//    public void extendFront(){
//        frontClimbDoubleNoid.set(DoubleSolenoid.Value.kReverse);
//        System.out.println("Front piston extended");
//    }
//
//    public void extendBack(){
//        backClimbDoubleNoid.set(DoubleSolenoid.Value.kReverse);
//        System.out.println("Back piston extended");
//    }
//    public void retractFront(){
//        frontClimbDoubleNoid.set(DoubleSolenoid.Value.kForward);
//        System.out.println("Front piston retracted");
//    }
//
//    public void retractBack(){
//        backClimbDoubleNoid.set(DoubleSolenoid.Value.kForward);
//        System.out.println("Back piston retracted");
//    }
//
//    public void solenoidsOff(){
//        backClimbDoubleNoid.set(DoubleSolenoid.Value.kOff);
//        frontClimbDoubleNoid.set(DoubleSolenoid.Value.kOff);
//        System.out.println("Solenoids off");
//    }
//}