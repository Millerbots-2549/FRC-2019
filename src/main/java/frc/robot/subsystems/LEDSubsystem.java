package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SerialPort;

public class LEDSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private SerialPort arduino;
    private boolean working;


    public void initDefaultCommand() {
        // TODO: Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }

    public LEDSubsystem() {
        try {
            arduino = new SerialPort(9600, SerialPort.Port.kUSB);
            working = true;
        }
        catch(Exception e) {
            System.out.println("LEDS NOT WORKING " + e);
            working = false;
        }
        //arduino.writeString("a");
    }

    public void fillBlue() {
        write("a");
    }

    public void fillOrange() {
        write("b");
    }

    public void makeRainbow() {
        write("c");
    }

    public void setDisabled() {
        write("d");
    }

    private void write(String value) {
        if(working)
            arduino.writeString(value);
    }
}

