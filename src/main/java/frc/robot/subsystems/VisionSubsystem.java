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

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public VisionSubsystem() {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("datatable"); // todo: change key
        xEntry = table.getEntry("X");
        yEntry = table.getEntry("Y");
        zEntry = table.getEntry("Z");
    }

    public void initDefaultCommand() {
        setDefaultCommand(new VisionCommand());

    }

    public int getX() {
        return 0;
    }
    public int getY() {
        return 0;
    }
    public int getZ(){
        return 0;
    }
    public int camResX(){
      return 0;
    }
}


