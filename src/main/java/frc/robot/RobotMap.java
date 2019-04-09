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
    public static final int MOTOR_LEFT_0 = 0;
    public static final int MOTOR_LEFT_1 = 1;
    public static final int MOTOR_RIGHT_2 = 2;
    public static final int MOTOR_RIGHT_3 = 3;
    public static final int HATCH_MOTOR = 4;

    //PWM
    public static final int INTAKE_SPARK = 0;
    public static final int CLIMB_SPARK = 1;
    public static final int INTAKE_SOL_REV = 3;;
    public static final int CLIMB_WHEEL_SPARK = 2;

    //DIO
    public static final int[] ODOMETER_LEFT = {0, 1};
    public static final int[] ODOMETER_RIGHT = {2, 3};

    // PCM
    public static final int HATCH_SOL_FWD = 0;
    public static final int HATCH_SOL_REV = 1;

    public static final int INTAKE_SOL_FWD = 2;

        //lvl 3
//    public static final int CLIMB_SOL_FWD = 5;
//    public static final int CLIMB_SOL_REV = 4;


        //lvl 2
    public static final int CLIMB_FRONT_SOL_FWD = 5;
    public static final int CLIMB_FRONT_SOL_REV = 4;
    public static final int CLIMB_BACK_SOL_FWD = 7;
    public static final int CLIMB_BACK_SOL_REV = 6;
}