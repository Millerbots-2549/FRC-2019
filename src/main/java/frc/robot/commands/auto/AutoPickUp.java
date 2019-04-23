package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.drive.DriveStraight;
import frc.robot.commands.drive.DriveUntilRange;
import frc.robot.commands.hatch.SearchForTarget;


public class AutoPickUp extends CommandGroup {

    public AutoPickUp() {

        addParallel(new SearchForTarget());
        addSequential(new DriveUntilRange(195));
        addSequential(new DriveStraight(-300, 0.7));

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
