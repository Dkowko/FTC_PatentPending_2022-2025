package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.botconfigs.PPBot;
import org.firstinspires.ftc.teamcode.vision.AprilTagProcessorPosition;

@Autonomous(name="PPBotAuto", group = "ppbot")
public class PPBotAuto extends LinearOpMode {

    public PPBot robot;
    public AprilTagProcessorPosition vision;

    @Override
    public void runOpMode() {

        robot = new PPBot(telemetry, hardwareMap);

        vision = new AprilTagProcessorPosition(telemetry);
        vision.initAprilTag(hardwareMap);

        int location = 0;
        while (opModeInInit()) {
            vision.telemetryAprilTag();
            location = vision.currentLocationDetected();
            telemetry.update();
        }

        vision.closeAprilTag();

        telemetry.addData("Location", location);
        telemetry.update();
        sleep(1000);

        switch (location) {
            case 0:
                robot.autonomousMove(0, 0, Math.PI / 8, robot.slowSpeed, this);
                robot.autonomousMove(0, 23, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, -20, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, 0, -Math.PI / 8, robot.slowSpeed, this);
                sleep(500);
                break;
            case 1:
                robot.autonomousMove(0, 26, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, -23, 0, robot.slowSpeed, this);
                break;
            case 2:
                robot.autonomousMove(0, 0, -Math.PI / 8, robot.slowSpeed, this);
                robot.autonomousMove(0, 23, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, -20, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, 0, Math.PI / 8, robot.slowSpeed, this);
                break;
        }

        robot.autonomousMove(-36, 0, 0, robot.midSpeed, this);
    }
}
