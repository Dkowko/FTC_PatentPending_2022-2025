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
            robot.upWrist();
            vision.telemetryTfod(); // output debug info from vision device
            location = vision.currentLocationDetected("Cone"); // get location of "Cone"
            telemetry.addData("LOCATION", location); // output debug info from vision device
            telemetry.update(); // output debug info from vision device
        }

        vision.closeTfod();

        robot.autonomousMove(0, 18, 0, robot.slowSpeed, this);

        switch (location) {
            case 0:
                robot.autonomousMove(0, 0, 3 * Math.PI / 4, robot.slowSpeed, this);
                robot.autonomousMove(6, 0, 0, robot.slowSpeed, this);
                robot.autonomousMove(-6, 0, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, 0, -3 * Math.PI / 4, robot.slowSpeed, this);
                break;
            case 1:
                robot.autonomousMove(0, 0, Math.PI / 2, robot.slowSpeed, this);
                robot.autonomousMove(8, 0, 0, robot.slowSpeed, this);
                robot.autonomousMove(-8, 0, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, 0, -Math.PI / 2, robot.slowSpeed, this);
                break;
            case 2:
                robot.autonomousMove(0, 0, Math.PI / 4, robot.slowSpeed, this);
                robot.autonomousMove(6, 0, 0, robot.slowSpeed, this);
                robot.autonomousMove(-6, 0, 0, robot.slowSpeed, this);
                robot.autonomousMove(0, 0, -Math.PI / 4, robot.slowSpeed, this);
                break;
        }

        robot.autonomousMove(-30, 8, 0, robot.slowSpeed, this);
        robot.autonomousMove(0, 0, Math.PI / 2, robot.slowSpeed, this);

        robot.slide.autonomousMove(-6, 1, this);
        robot.autonomousMove(0, 8, 0, robot.slowSpeed, this);
        robot.openClaw();
    }
}
