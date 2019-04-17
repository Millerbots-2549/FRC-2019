package frc.robot;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

public class Paths {

    public final double k_max_velocity = 3.0; // 10
    public final double k_max_acceleration = k_max_velocity * 0.9;
    public final int k_tpr_left = 240;// 480;
    public final int k_tpr_right = 240; // 480;
    public final double k_wheel_diameter = 0.1524; // 0.5
    public final double k_wheel_base_width = 0.6096; // 2.0
    public final double k_speed_mult = 1;

    private Trajectory.Config config = new Trajectory.Config(
            Trajectory.FitMethod.HERMITE_QUINTIC,
            Trajectory.Config.SAMPLES_FAST,
            0.01,
            k_max_velocity,
            k_max_acceleration,
            60.0
    );

//    Waypoint[] points = {
//            new Waypoint(0, 0, 0),
//            new Waypoint(3, -1, 0)
//    };
//    public Trajectory lvl2ToLeftCargo = Pathfinder.generate(points, config);
//
//    Waypoint[] points2 = {
//            new Waypoint(0, 0, 0),
//            new Waypoint(-0.5, 0, 0)
//    };
//    public Trajectory backUp = Pathfinder.generate(points2, config);
//
//    Waypoint[] points3 = {
//            new Waypoint(0, 0, 0),
//            new Waypoint(2, 2, Pathfinder.d2r(-90))
//    };
//    public Trajectory pickUpLeft = Pathfinder.generate(points3, config);

    public Paths() {

    }
}
