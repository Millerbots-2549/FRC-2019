package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;


public class PIDHatchSubsystem extends PIDSubsystem {

    private WPI_TalonSRX motor;

    public PIDHatchSubsystem() {
        // Initialize your subsystem here
        super(0, 0, 0 /* TODO: decide which super constructor to use/call and set the appropriate values */);

        motor = new WPI_TalonSRX(RobotMap.HATCH_MOTOR);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system to
        // enable() - Enables the PID controller.
    }


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }


    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }


    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
