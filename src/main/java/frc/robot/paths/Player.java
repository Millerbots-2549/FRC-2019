package frc.robot.paths;

import frc.robot.Robot;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Player {

    Scanner scanner;
    long startTime;

    boolean onTime = true;
    double nextDouble;

    public Player() throws FileNotFoundException {
        scanner = new Scanner(new File("/home/lvuser/path.csv"));
        scanner.useDelimiter(",|\\n");

        startTime = System.currentTimeMillis();
    }

    public Player(String fileName) throws FileNotFoundException {
        scanner = new Scanner(new File("/home/lvuser/" + fileName + ".csv"));
        scanner.useDelimiter(",|\\n");

        startTime = System.currentTimeMillis();
    }

    public void play() {
        if((scanner != null) && (scanner.hasNextDouble())) {
            double t_delta;

            if(onTime) {
                nextDouble = scanner.nextDouble();
            }

            t_delta = nextDouble - (System.currentTimeMillis()-startTime);

            if(t_delta <= 0) {

                double left = scanner.nextDouble();
                double right = scanner.nextDouble();
                Robot.drivetrain.driveTank(left, right);

                onTime = true;
            } else {
                onTime = false;
            }
        } else {
            this.end();
            if(scanner != null) {
                scanner.close();
                scanner = null;
            }
        }
    }

    public void end() {

        Robot.drivetrain.driveTank(0, 0);

        if(scanner != null) {
            scanner.close();
        }
    }

}
