package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.vision.VisionPeriodic;

public class VisionSubsystem extends Subsystem {

    private NetworkTableEntry tapeDetected,
            cargoDetected,
            tapeYaw,
            cargoYaw,
            tapeWanted,
            videoTimestamp;

    private NetworkTableInstance instance;
    private NetworkTable chickenVision;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public VisionSubsystem() {
        instance = NetworkTableInstance.getDefault();
        chickenVision = instance.getTable("ChickenVision");

        tapeWanted = chickenVision.getEntry("Tape");
        tapeDetected = chickenVision.getEntry("tapeDetected");
        cargoDetected = chickenVision.getEntry("cargoDetected");
        tapeYaw = chickenVision.getEntry("tapeYaw");
        cargoYaw = chickenVision.getEntry("cargoYaw");

        tapeWanted.setBoolean(true);

    }

    public void initDefaultCommand() {
        setDefaultCommand(new VisionPeriodic());

    }

    public double getHatchX() {
        return tapeYaw.getDouble(0);
//        int x = 0;
//        xEntry.setNumber(x);
//        return (int)SmartDashboard.getNumber("hatch_cog_x", resXDefault/2);
        //return (int)SmartDashboard.getNumber("hatch_cog_x", camResX()/2);
    }
    public double getCargoX() {
        return cargoYaw.getDouble(0);
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


