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
            robot.closeClaw();
            vision.telemetryAprilTag();
            location = vision.currentLocationDetected();
            telemetry.update();
        }

        vision.closeAprilTag();

        switch (location) {
            case 0:
                robot.autonomousMove(0, 4, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, 0, Math.PI / 8, robot.slowSpeed, this);
                robot.autonomousMove(0, 24, 0, robot.slowSpeed, this);
                robot.openClaw();
                robot.autonomousMove(0, -24, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, 0, -Math.PI / 8, robot.slowSpeed, this);
                break;
            case 1:
                robot.autonomousMove(0, 28, 0, robot.slowSpeed, this);
                robot.openClaw();
                robot.autonomousMove(0, -24, 0, robot.slowSpeed, this);
                break;
            case 2:
                robot.autonomousMove(0, 12, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, 0, -Math.PI / 4, robot.slowSpeed, this);
                robot.autonomousMove(0, 16, 0, robot.slowSpeed, this);
                robot.openClaw();
                robot.autonomousMove(0, -16, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, 0, Math.PI / 4, robot.slowSpeed, this);
                robot.autonomousMove(0, -8, 0, robot.slowSpeed, this);
                break;
        }

        robot.autonomousMove(-36, 0, 0, robot.midSpeed, this);
        robot.autonomousMove(3, 0, 0 , robot.slowSpeed, this);
    }
}