/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.*;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    public Joystick joystick1;

    // TODO: configure buttons

    // Buttons
    private int button_intakeRaise = 4;
    private int button_intake = 2;
    private int button_blatBlatBlat = 1;
    private int button_noBlatBlatBlat = 1;

    // Axes
    private int axis_drive = 1;
    private int axis_drive_rotation = 0;
    private int axis_hatch = 4;

    public OI() {

        joystick1 = new Joystick(  0);

        // Smartdashboard buttons
    }

    public Joystick getJoystick1() {
        return joystick1;
    }

    public boolean getIntakeRaise() {
        return joystick1.getRawButtonReleased(button_intakeRaise);
    }

    public double getDrive() {
        return joystick1.getRawAxis(axis_drive);
    }

    public double getDriveRotation() {
        return joystick1.getRawAxis(axis_drive_rotation);
    }

    public double getHatchSpeed() {
        return joystick1.getRawAxis(axis_hatch);
    }

    public boolean getHatchBlatBlatBlat() { return joystick1.getRawButton(button_blatBlatBlat); }

    public double getHatchMove() {return joystick1.getRawAxis(axis_hatch); }

    public boolean getIntakeSpin() {return joystick1.getRawButton(button_intake); }
}

