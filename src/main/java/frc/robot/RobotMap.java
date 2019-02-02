/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    // CAN
    public static int motorLeft0 = 0;
    public static int motorLeft1 = 1;
    public static int motorRight2 = 2;
    public static int motorRight3 = 3;
    public static int hatch_motor = 4;

    //PWM
    public static int intake_spark = 1;

    // PCM
    public static int hatch_sol_fwd = 0;
    public static int hatch_sol_rev = 1;

    public static int intake_sol_fwd = 2;
    public static int intake_sol_rev = 3;

    public static int climbFront_sol_fwd = 4;
    public static int climbFront_sol_rev = 5;
    public static int climbBack_sol_fwd = 6;
    public static int climbBack_sol_rev = 7;
}