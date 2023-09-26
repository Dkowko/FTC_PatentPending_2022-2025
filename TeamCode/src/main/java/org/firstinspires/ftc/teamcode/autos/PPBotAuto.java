package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.botconfigs.PPBot;

@Autonomous(name="PPBotAuto", group = "ppbot")
public class PPBotAuto extends LinearOpMode {

    public PPBot robot;

    @Override
    public void runOpMode() {

        robot = new PPBot(telemetry, hardwareMap);

        waitForStart();

        robot.autonomousMove(10, 0, 0, robot.slowSpeed, this);

        telemetry.addLine("done 1");
        telemetry.update();
        sleep(1000);

        robot.autonomousMove(0, 10, 0, robot.slowSpeed, this);

        telemetry.addLine("done 2");
        telemetry.update();
        sleep(1000);

        robot.autonomousMove(0, 0, 10, robot.slowSpeed, this);

        telemetry.addLine("done 3");
        telemetry.update();
        sleep(1000);
    }
}
