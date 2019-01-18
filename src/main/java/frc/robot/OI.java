/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

import javax.naming.ldap.Control;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //////////////////////////////////
    // SINGLE JOY STICK//
    /////////////////////////////////
    private int portJoy = 0;
    private Joystick joyMain = new Joystick(portJoy);

    ///////////////////
    // Joystick AXES //
    ///////////////////
    private int joyDriveAxis = 1;



    ////////////////////////////////
    // CONTROLLER //
    ///////////////////////////////
    private int portCtrl=1;
    private Joystick ctrl = new Joystick(portCtrl);

    /////////////
    //CTRL AXES//
    /////////////

    private int ctrlDriveL = 5;
    private int ctrlDriveR = 1;
    private int ctrlBoxIn = 2;
    private int ctrlBoxOut = 3;





    /////////////
    // GETTERS//
    ////////////

    public enum ControllerType {controller, joystick}
    public ControllerType ctrlType = ControllerType.joystick;

    public void setCtrlType(ControllerType ctrlType) {this.ctrlType = ctrlType;}

    //////////
    //JOY
    /////////

    public double getDriveM() {
        if(ctrlType == ControllerType.joystick) return -joyMain.getRawAxis(joyDriveAxis);
        return 0;
    }


    /////////
    //CTRL
    ////////
    public double getDriveL() {
        if(ctrlType == ControllerType.controller) return -ctrl.getRawAxis(ctrlDriveL);
        return 0;
    }

    public double getDriveR() {
        if(ctrlType == ControllerType.controller) return -ctrl.getRawAxis(ctrlDriveR);
        return 0;
    }




  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
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

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
