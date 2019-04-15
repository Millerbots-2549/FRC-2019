package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.drive.DrivePath;
import frc.robot.commands.drive.TurnInPlace;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;


public class Test extends CommandGroup {

    public Test() {



        addSequential(new TurnInPlace(-90));
        addSequential(new TurnInPlace(90));
        addSequential(new DrivePath(Robot.paths.lvl2ToLeftCargo, false));
        addSequential(new DrivePath(Robot.paths.backUp, true));
        addSequential(new TurnInPlace(-90));
        addSequential(new DrivePath(Robot.paths.pickUpLeft, false));

        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the arm.
    }
}
