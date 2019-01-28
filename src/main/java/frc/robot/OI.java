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

    public Joystick ctrlDrive;
    // TODO: declare controller for manipulators named ctrlManip

    // TODO: finish controls

    // Buttons
    private int button_intakeRaise = 4;
    private int button_blatblatBlat = 0;
    private int button_quickTurn = 5; // todo check

    // Axes
    private int axis_drive = 1;
    private int axis_drive_rotation = 0;
    private int axis_hatch = 4;
    private int axis_hatchmove = 0;
    private int axis_intakespin = 0;

    public OI() {

        ctrlDrive = new Joystick(  0);
        // TODO: initialize ctrlManip

        // Smartdashboard controls
    }

    public Joystick getCtrlDrive() {
        return ctrlDrive;
    }
    // TODO: create get for ctrlManip named getCtrlManip

    // BUTTONS

    public boolean getQuickTurn() {
        return ctrlDrive.getRawButton(button_quickTurn);
    }

    public boolean getIntakeRaise() {
        return ctrlDrive.getRawButtonReleased(button_intakeRaise);
    }

    public boolean getHatchBlatBlatBlat() { return ctrlDrive.getRawButton(button_blatblatBlat); }

    // AXES

    // Drivetrain
    public double getAxisDrive() {
        return ctrlDrive.getRawAxis(axis_drive);
    }
    public double getAxisTurn() {
        return ctrlDrive.getRawAxis(axis_drive_rotation);
    }

    // Intake
    public double getIntakeSpin() {return ctrlDrive.getRawAxis(axis_intakespin); }

    // Hatch

    // Climber

    // TODO: replace hatch oi methods with vision system
    public double getHatchSpeed() {
        return ctrlDrive.getRawAxis(axis_hatch);
    }
    public double getHatchMove() {return ctrlDrive.getRawAxis(axis_hatchmove); }
}

