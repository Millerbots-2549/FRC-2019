package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.HatchCommand;

public class HatchSubsystem extends Subsystem {

    DoubleSolenoid hatchNoidOne;
    //TODO: Motor
    //TODO: Solanoid 2 Pistons
    //TODO: Encoders
    public void initDefaultCommand() {
        setDefaultCommand(new HatchCommand());
    }
}

