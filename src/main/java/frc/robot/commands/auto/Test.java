package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.drive.DrivePath;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;

import java.util.concurrent.ThreadLocalRandom;


public class Test extends CommandGroup {

    public Test() {

        Waypoint[] points = new Waypoint[] {
                new Waypoint(-2, -2, Pathfinder.d2r(-45)),
                new Waypoint(-1, -1, Pathfinder.d2r(45)),
                new Waypoint(-2, -2, Pathfinder.d2r(-45)),
                new Waypoint(0, 0, 0)
        };

        Trajectory.Config config = new Trajectory.Config(
                Trajectory.FitMethod.HERMITE_CUBIC,
                Trajectory.Config.SAMPLES_LOW,
                0.05,
                0.5,
                0.25,
                60.0);
        Trajectory trajectory = Pathfinder.generate(points, config);

        addSequential(new DrivePath(trajectory));


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
