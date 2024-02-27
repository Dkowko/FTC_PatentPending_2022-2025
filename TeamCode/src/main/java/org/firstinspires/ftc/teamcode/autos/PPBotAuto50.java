package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.botconfigs.PPBot;
import org.firstinspires.ftc.teamcode.vision.TFPosDetect;

@Autonomous(name="PPBotAuto50", group = "ppbot")
public class PPBotAuto50 extends LinearOpMode {

    public PPBot robot;
    public TFPosDetect vision;

    @Override
    public void runOpMode() {

        robot = new PPBot(telemetry, hardwareMap);

        vision = new TFPosDetect();
        vision.initTfod(telemetry, hardwareMap, "Cone_Blue.tflite");

        int location = 0;
        while (opModeInInit()) {
            robot.closeClaw(); // set claw and wrist to start position
            robot.downWrist();
            robot.holdDrone();
            vision.telemetryTfod(); // output debug info from vision device
            location = vision.currentLocationDetected("Cone"); // get location of "Cone"
            telemetry.addData("LOCATION", location); // output debug info from vision device
            telemetry.update(); // output debug info from vision device
        }

        vision.closeTfod();

        robot.slide.autonomousMove(-2, 1, this);
        robot.autonomousMove(0, 18, 0, robot.slowSpeed, this);

        switch (location) {
            case 0:
                robot.autonomousMove(0, 0, -Math.PI / 4, robot.slowslowSpeed, this);
                robot.autonomousMove(-16, 0, 0, robot.slowslowSpeed, this);
                robot.autonomousMove(4, 0, 0, robot.slowslowSpeed, this);
                robot.autonomousMove(12, 0, 0, robot.lowmidSpeed, this);
                robot.autonomousMove(0, 0, Math.PI / 4, robot.slowSpeed, this);
                break;
            case 1:
                robot.autonomousMove(0, 0, -Math.PI / 2, robot.slowslowSpeed, this);
                robot.autonomousMove(-18, 0, 0, robot.slowslowSpeed, this);
                robot.autonomousMove(4, 0, 0, robot.slowslowSpeed, this);
                robot.autonomousMove(14, 0, 0, robot.lowmidSpeed, this);
                robot.autonomousMove(0, 0, Math.PI / 2, robot.slowSpeed, this);
                break;
            case 2:
                robot.autonomousMove(0, 0, -13 * Math.PI / 16, robot.slowslowSpeed, this);
                robot.autonomousMove(-12, 0, 0, robot.slowslowSpeed, this);
                robot.autonomousMove(4, 0, 0, robot.slowslowSpeed, this);
                robot.autonomousMove(8, 0, 0, robot.lowmidSpeed, this);
                robot.autonomousMove(0, 0, 13 * Math.PI / 16, robot.slowSpeed, this);
                break;
        }

        robot.autonomousMove(-30, 6, 0, robot.slowSpeed, this);
        robot.autonomousMove(0, 0, Math.PI / 2, robot.slowSpeed, this);

        robot.upWrist();
        robot.slide.autonomousMove(-2, 1, this);
        switch (location) {
            case 0:
                robot.autonomousMove(-8, 8, 0, robot.slowSpeed, this);
                break;
            case 1:
                robot.autonomousMove(0, 8, 0, robot.slowSpeed, this);
                break;
            case 2:
                robot.autonomousMove(8, 8, 0, robot.slowSpeed, this);
                break;
        }
        robot.openClaw();
        sleep(500);
        robot.autonomousMove(0, -4, 0, robot.slowSpeed, this);

        robot.autonomousMove(0, 0, -Math.PI / 2, robot.slowSpeed, this);
        switch (location) {
            case 0:
                robot.autonomousMove(0, -12, 0, robot.slowSpeed, this);
                break;
            case 1:
                robot.autonomousMove(0, -20, 0, robot.slowSpeed, this);
                break;
            case 2:
                robot.autonomousMove(0, -28, 0, robot.slowSpeed, this);
                break;
        }
    }
}
