package frc.robot.commands.actions.climb;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.actions.climb.*;
import frc.robot.commands.actions.drive.*;


public class Climb extends CommandGroup {

    public Climb() {
        addSequential(new RaiseFront());
        addSequential(new DriveStraight(0.25),1);
        addSequential(new RetractFront());
        addSequential(new DriveStraight(0.25), 2);
        addSequential(new RaiseBack());
        addSequential(new DriveStraight(0.25), 1);
        addSequential(new RetractBack());
        addSequential(new DriveStraight(0.25), 2);

    }
}