package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.botconfigs.PPBot;
import org.firstinspires.ftc.teamcode.vision.TFPosDetect;

@Autonomous(name="PPBotAutoFar", group = "ppbot")
public class PPBotAutoFar extends LinearOpMode {

    public PPBot robot;
    public TFPosDetect vision;

    @Override
    public void runOpMode() {

        robot = new PPBot(telemetry, hardwareMap);

        vision = new TFPosDetect();
        vision.initTfod(telemetry, hardwareMap, "Cone_Blue.tflite");

        int location = 0;
        while (opModeInInit()) {
            robot.closeClaw();
            robot.downWrist();
            robot.holdDrone();
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
                robot.autonomousMove(0, -2, 0, robot.slowSpeed, this);
                break;
            case 1:
                robot.autonomousMove(0, 28, 0, robot.slowSpeed, this);
                robot.openClaw();
                robot.autonomousMove(0, -26, 0, robot.slowSpeed, this);
                break;
            case 0:
                robot.autonomousMove(0, 14, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, 0, Math.PI / 4, robot.slowSpeed, this);
                robot.autonomousMove(0, 12, 0, robot.slowSpeed, this);
                robot.openClaw();
                robot.autonomousMove(0, -12, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, 0, -Math.PI / 4, robot.slowSpeed, this);
                robot.autonomousMove(0, -12, 0, robot.slowSpeed, this);
                break;
        }
    }
}
