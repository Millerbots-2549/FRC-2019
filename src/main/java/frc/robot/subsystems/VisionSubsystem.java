package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.vision.VisionPeriodic;

public class VisionSubsystem extends Subsystem {

//    NetworkTableEntry xEntry;
//    NetworkTableEntry yEntry;
//    NetworkTableEntry zEntry;
//    NetworkTableEntry resXEntry;
//    NetworkTableEntry senseEntry;
//
//    private int resXDefault = 320;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public VisionSubsystem() {
//        NetworkTableInstance inst = NetworkTableInstance.getDefault();
//        NetworkTable table = inst.getTable("camera_values"); // todo: change key
//        xEntry = table.getEntry("hatch_cog_x");
//        yEntry = table.getEntry("hatch_cog_y");
//        zEntry = table.getEntry("hatch_cog_z");
//        resXEntry = table.getEntry("camera_width");
//        senseEntry = table.getEntry("hatch_sensing");
//
//        xEntry.setDefaultNumber(0);
//        yEntry.setDefaultNumber(0);
//        zEntry.setDefaultNumber(0);
//        resXEntry.setDefaultNumber(resXDefault);
//        senseEntry.setDefaultBoolean(false);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new VisionPeriodic());

    }

    public int getX() {
//        int x = 0;
//        xEntry.setNumber(x);
//        return (int)SmartDashboard.getNumber("hatch_cog_x", resXDefault/2);
        return (int)SmartDashboard.getNumber("hatch_cog_x", camResX()/2);
    }
    public int getY() {
//        int y = 0;
//        yEntry.setNumber(y);
//        return y;
        return (int)SmartDashboard.getNumber("hatch_cog_y", 0);
    }
    public int getZ() {
//        int z = 0;
//        zEntry.setNumber(z);
//        return z;
        return (int)SmartDashboard.getNumber("hatch_cog_z", 0);
    }
    public int camResX() {
//        int res = resXDefault;
//        resXEntry.setNumber(res);
//        return (int)SmartDashboard.getNumber("camera_width", camResX());
        return (int)SmartDashboard.getNumber("camera_width", 320);
    }
    public boolean sensingHatch() {
//        boolean sensing = false;
//        senseEntry.setBoolean(sensing);
//        return SmartDashboard.getBoolean("hatch_sensing", false);
        return SmartDashboard.getBoolean("hatch_sensing", false);
    }

    public void setDefaults() {
//        xEntry.setDefaultNumber(0);
//        yEntry.setDefaultNumber(0);
//        zEntry.setDefaultNumber(0);
//        resXEntry.setDefaultNumber(resXDefault);
//        senseEntry.setDefaultBoolean(false);
    }
}


