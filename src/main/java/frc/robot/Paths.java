package frc.robot;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

public class Paths {

    private Trajectory.Config config = new Trajectory.Config(
            Trajectory.FitMethod.HERMITE_CUBIC,
            Trajectory.Config.SAMPLES_HIGH,
            0.01,
            1.0,
            0.7,
            60.0
    );

    public Trajectory lvl2ToLeftCargo;

    public Paths() {
        Waypoint[] points = {
                new Waypoint(0, 0, 0),
                new Waypoint(2, -2, Pathfinder.d2r(90))
        };
        lvl2ToLeftCargo = Pathfinder.generate(points, config);
    }
}
