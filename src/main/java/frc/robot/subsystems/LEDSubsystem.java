package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SerialPort;

public class LEDSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private SerialPort arduino;


    public void initDefaultCommand() {
        // TODO: Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }

    public LEDSubsystem() {
        arduino = new SerialPort(9600, SerialPort.Port.kUSB);
        //arduino.writeString("a");
    }

    public void fillBlue() {
        arduino.writeString("a");
    }

    public void fillOrange() {
        arduino.writeString("b");
    }

    public void makeRainbow() {
        arduino.writeString("c");
    }

    public void setDisabled() {
        arduino.writeString("d");
    }
}

