package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.drive.DrivePath;
import frc.robot.commands.drive.DriveStraight;
import frc.robot.commands.drive.DriveUntilRange;
import frc.robot.commands.drive.TurnInPlace;
import frc.robot.commands.hatch.EjectHatch;
import frc.robot.commands.hatch.SearchForTarget;


public class Test extends CommandGroup {

    public Test() {



//        addSequential(new TurnInPlace(-90));
//        addSequential(new TurnInPlace(90));
//        addSequential(new DriveStraight(1000, .7));
//        addSequential(new DrivePath(Robot.paths.lvl2ToLeftCargo, false));
        System.out.println("1");
//        addParallel(new SearchForTarget());
//        addSequential(new DriveUntilRange());
//        addParallel(new EjectHatch());
//        addSequential(new DriveStraight(-300, 0.7));
//        System.out.println("2");
////        addSequential(new DrivePath(Robot.paths.backUp, true));
//        addSequential(new TurnInPlace(-90));
//        System.out.println("4");
//        addSequential(new DrivePath(Robot.paths.pickUpLeft, false));
//        System.out.println("5");

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
