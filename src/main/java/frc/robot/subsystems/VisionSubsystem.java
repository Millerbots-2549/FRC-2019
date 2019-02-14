package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableValue;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.commands.VisionCommand;

public class VisionSubsystem extends Subsystem {

    NetworkTableEntry xEntry;
    NetworkTableEntry yEntry;
    NetworkTableEntry zEntry;
    NetworkTableEntry resXEntry;

    private int resXDefault = 320;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public VisionSubsystem() {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("camera_values"); // todo: change key
        xEntry = table.getEntry("object_x_0");
        yEntry = table.getEntry("object_y_0");
        zEntry = table.getEntry("object_z_0");
        resXEntry = table.getEntry("camera_width");

        xEntry.setDefaultNumber(0);
        yEntry.setDefaultNumber(0);
        zEntry.setDefaultNumber(0);
        resXEntry.setDefaultNumber(resXDefault);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new VisionCommand());

    }

    public int getX() {
        int x = 0;
        xEntry.setNumber(x);
        return x;
    }
    public int getY() {
        int y = 0;
        yEntry.setNumber(y);
        return y;
    }
    public int getZ(){
        int z = 0;
        zEntry.setNumber(z);
        return z;
    }
    public int camResX(){
        int res = resXDefault;
        resXEntry.setNumber(res);
        return res;
    }
}


