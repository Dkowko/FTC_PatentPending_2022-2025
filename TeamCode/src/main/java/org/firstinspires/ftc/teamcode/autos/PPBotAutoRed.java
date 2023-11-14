package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.botconfigs.PPBot;
import org.firstinspires.ftc.teamcode.vision.AprilTagProcessorPosition;
import org.firstinspires.ftc.teamcode.vision.TFPosDetect;

@Autonomous(name="PPBotAutoRed", group = "ppbot")
public class PPBotAutoRed extends LinearOpMode {

    public PPBot robot;
    public TFPosDetect vision;

    @Override
    public void runOpMode() {

        robot = new PPBot(telemetry, hardwareMap);

        vision = new TFPosDetect();
        vision.initTfod(telemetry, hardwareMap, "modelWcone.tflite");

        int location = 0;
        while (opModeInInit()) {
            robot.closeClaw();
            robot.downWrist();
            vision.telemetryTfod();
            location = vision.currentLocationDetected("Cone");
            telemetry.addData("LOCATION", location);
            telemetry.update();
        }

        vision.closeTfod();

        switch (location) {
            case 2:
                robot.autonomousMove(0, 4, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, 0, -Math.PI / 8, robot.slowSpeed, this);
                robot.autonomousMove(0, 24, 0, robot.slowSpeed, this);
                robot.openClaw();
                robot.autonomousMove(0, -24, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, 0, Math.PI / 8, robot.slowSpeed, this);
                break;
            case 1:
                robot.autonomousMove(0, 28, 0, robot.slowSpeed, this);
                robot.openClaw();
                robot.autonomousMove(0, -24, 0, robot.slowSpeed, this);
                break;
            case 0:
                robot.autonomousMove(0, 14, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, 0, Math.PI / 4, robot.slowSpeed, this);
                robot.autonomousMove(0, 14, 0, robot.slowSpeed, this);
                robot.openClaw();
                robot.autonomousMove(0, -14, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, 0, -Math.PI / 4, robot.slowSpeed, this);
                robot.autonomousMove(0, -10, 0, robot.slowSpeed, this);
                break;
        }

        robot.autonomousMove(36, 0, 0, robot.midSpeed, this);
        robot.autonomousMove(-3, 0, 0 , robot.slowSpeed, this);
    }
}
