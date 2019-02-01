/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Compressor;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.HatchSubsystem;
import frc.robot.subsystems.IntakeSubsystem;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */




public class Robot extends TimedRobot {
  public static ExampleSubsystem subsystem;
  public static DrivetrainSubsystem drivetrain;
  public static HatchSubsystem hatch;
  public static IntakeSubsystem intake;
  public static OI oi;
//  public static CameraServer cam = new CameraServer();

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  Compressor mainCompressor = new Compressor(0);

  //compressor min max
  public static int compressorMaxPressure = 125;
  public static int compressorMinPressure = 115;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    subsystem = new ExampleSubsystem();
    drivetrain = new DrivetrainSubsystem();
    hatch = new HatchSubsystem();
    oi = new OI();
    CameraServer.getInstance().startAutomaticCapture();

    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {

    setCompressor(false);
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
    setCompressor(true);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    regulatePressure();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    setCompressor(true);
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic()  {
    Scheduler.getInstance().run();
    regulatePressure();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  private void regulatePressure(){
//    if(mainCompressor.get > compressorMaxPressure - 5) mainCompressor.stop();
//    else mainCompressor.start();
//    if(oi.joystick1.getRawButton(7)) mainCompressor.start();
//    else if(oi.joystick1.getRawButton(8)) mainCompressor.stop();
    SmartDashboard.putBoolean("C CLC", mainCompressor.getClosedLoopControl());
    SmartDashboard.putBoolean("C PSV", mainCompressor.getPressureSwitchValue());
    SmartDashboard.putNumber("C CC", mainCompressor.getCompressorCurrent());
  }

  private void setCompressor(boolean value) {
    if(value) {
      mainCompressor.setClosedLoopControl(true);
      System.out.println("Compressor ON");
    }
    else if(!value) {
      mainCompressor.setClosedLoopControl(false);
      System.out.println("Compressor OFF");
    }
  }
}
