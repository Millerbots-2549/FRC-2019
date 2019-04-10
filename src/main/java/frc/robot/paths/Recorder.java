package frc.robot.paths;

import frc.robot.Robot;

import java.io.IOException;
import java.io.FileWriter;

public class Recorder {

    FileWriter writer;

    long startTime;

    public Recorder() throws IOException {
        startTime = System.currentTimeMillis();
        writer = new FileWriter("/home/lvuser/path.csv");
    }

    public Recorder(String fileName) throws IOException {
        startTime = System.currentTimeMillis();
        writer = new FileWriter("/home/lvuser/" + fileName + ".csv");
    }

    public void record() throws IOException {
        if(writer != null) {
            writer.append("" + (System.currentTimeMillis()-startTime));

            // csv format:
            // timeElapsed,left,right

            writer.append("," + Robot.drivetrain.getLeftSide());
            writer.append("," + Robot.drivetrain.getRightSide() + "\n");
        }
    }

    public void end() throws IOException {
        if(writer != null) {
            writer.flush();
            writer.close();
        }
    }
}
