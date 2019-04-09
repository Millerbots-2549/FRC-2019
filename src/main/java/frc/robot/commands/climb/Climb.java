package frc.robot.commands.climb;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.drive.*;

//LVL 3
public class Climb extends CommandGroup {
    public Climb(){
        //climb sequence here
//        addSequential(new RetractLift());
//        addSequential(new ExtendNoid(), 3);
//        addParallel(new DriveStraight(0.7, 2));
//        addParallel(new ClimbDrive(), 5);
//        addSequential(new ExtendLift(), 3);
//        addSequential(new DriveStraight(0.7), 2);



    }
}

//LvL 2
//public class Climb extends CommandGroup {
//
//    public Climb() {
//        addSequential(new RaiseFront());
//        addSequential(new DriveStraight(0.7, .75));
//        addSequential(new RetractFront());
//        addSequential(new DriveStraight(0.7, .9));
//        addSequential(new RaiseBack());
//        addSequential(new DriveStraight(0.65, .9));
//        addSequential(new RetractBack());
//        addSequential(new DriveStraight(0.8, .5));
//    }
//}
