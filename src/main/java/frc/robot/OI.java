/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.actions.climb.RaiseBack;
import frc.robot.commands.actions.climb.RaiseFront;
import frc.robot.commands.actions.compressors.*;
import frc.robot.commands.actions.drive.PrecisionMode;
import frc.robot.commands.actions.drive.ReverseControls;
import frc.robot.commands.actions.hatch.*;
import frc.robot.commands.actions.intake.*;
import frc.robot.commands.actions.climb.Climb;


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

    // CONTROLLERS
    public Joystick ctrlDrive = new Joystick(0);
    public Joystick ctrlManip = new Joystick(1);


    // BUTTONS
    public Button reverseControlsBack = new JoystickButton(ctrlDrive, 10);
    public Button reverseControlsForward = new JoystickButton(ctrlDrive, 11);
    public Button driverControlsReversed = new JoystickButton(ctrlDrive, 7);
    public Button driverPrecisionMode = new JoystickButton(ctrlDrive, 8);

    public Button hatchEject = new JoystickButton(ctrlManip, 1);
    public Button intakeRaise = new JoystickButton(ctrlManip, 4);
    public Button intakeLower = new JoystickButton(ctrlManip, 3);
    public Button intakeSpin = new JoystickButton(ctrlManip,5);
    public Button shootSpin = new JoystickButton(ctrlManip, 6);
    public Button climbFront = new JoystickButton(ctrlManip, 7);
    public Button climbRear = new JoystickButton(ctrlManip, 8);
    public POVButton hatchVisionSearch = new POVButton(ctrlManip, 0); // when button 8 // TODO: cantallon srxc
    public POVButton resetEncoderMin = new POVButton(ctrlManip, 270);
    public POVButton resetEncoderMax = new POVButton(ctrlManip, 90);
    public POVButton climb = new POVButton(ctrlManip, 0);
    public POVButton climbDown;

    // AXES
    private int axis_drive = 1;
    private int axis_drive_rotation = 4; // joy 0
    private int axis_drive_turnInPlace = 2;

    private int axis_hatch_slide_main = 3;
    private int axis_hatch_slide_aux = 2;

    // VARIABLES
    private double drive_axis_speed = -1;

    public OI() {

        // TODO: Finish Controls

//        reverseControlsBack.whenPressed(new ReverseControls(true));
//        reverseControlsForward.whenPressed(new ReverseControls(false));

        // DRIVE
        driverControlsReversed.toggleWhenPressed(new ReverseControls());
        driverPrecisionMode.toggleWhenPressed(new PrecisionMode());

        // MANIPULATOR CONTROLLER
        hatchVisionSearch.whileHeld(new SearchForTarget());
        hatchEject.cancelWhenPressed(new SearchForTarget());
        hatchEject.whenPressed(new EjectHatch());
        intakeRaise.whenPressed(new RaiseIntake());
        intakeLower.whenPressed(new LowerIntake());
        intakeSpin.whenPressed(new IntakeBall());
        shootSpin.whenPressed(new ShootBall());
        climbFront.toggleWhenPressed(new RaiseFront());
        climbRear.toggleWhenPressed(new RaiseBack());
        //climb.whenPressed(new Climb());
        resetEncoderMin.whenPressed(new ResetEncoder(false));
        resetEncoderMax.whenPressed(new ResetEncoder(true));

        /*
         * TODO: create actions and associated buttons
         * RaiseFront, RaiseRear,
         * RaiseIntake, LowerIntake,
         * IntakeBall, ShootBall,
         * DriveForward
         */

        // Smartdashboard controls
        SmartDashboard.putData("Compressor", new StopCompressor());

        //SmartDashboard.putData("Right Hatch setMax", new SetRightEncoderMax());
        //SmartDashboard.putData("Left Hatch setMax", new SetLeftEncoderMax());

    }

    public void update() {
        SmartDashboard.putNumber("Joy hatch", getAxisHatch());
        SmartDashboard.putNumber("Joy drive", getAxisDrive());
        SmartDashboard.putNumber("Joy turn", getAxisTurn());
    }

    public void drivePrecisionMode() { drive_axis_speed *= .7; }
    public void driveNormalMode() { drive_axis_speed *= 1/.7; }
    public void reverseDrive() {
        drive_axis_speed = -drive_axis_speed;
    }
    public boolean getDriveReversed() {
        return (drive_axis_speed < 0);
    }

    public Joystick getCtrlDrive() {
        return ctrlDrive;
    }
    public Joystick getCtrlManip() {
        return ctrlManip;
    }

    // Drivetrain
    public double getAxisDrive() {
        return ctrlDrive.getRawAxis(axis_drive) * drive_axis_speed;
    }
    public double getAxisTurn() {
        return ctrlDrive.getRawAxis(axis_drive_rotation) * Math.abs(drive_axis_speed);
    }
//    public double getAxisTurnInPlace() {
//        return ctrlDrive.getRawAxis(axis_drive_turnInPlace);
//    }

    // Hatch
    public double getAxisHatch() {
        double drive = ctrlManip.getRawAxis(axis_hatch_slide_main) - ctrlManip.getRawAxis(axis_hatch_slide_aux);
        if(drive <= 0.1953125 && drive >= -0.1953125)
            drive = 0;
        return drive;
    }

    // Climb

}


