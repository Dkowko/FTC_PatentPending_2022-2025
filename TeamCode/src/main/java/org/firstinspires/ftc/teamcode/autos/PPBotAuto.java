package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.botconfigs.PPBot;

public class PPBotAuto extends LinearOpMode {

    public PPBot robot;

    @Override
    public void runOpMode() {

        robot = new PPBot(telemetry, hardwareMap);

        waitForStart();

        robot.autonomousMove(10, 0, 0, robot.slowSpeed, this);
        sleep(1000);
        robot.autonomousMove(0, 10, 0, robot.slowSpeed, this);
        sleep(1000);
        robot.autonomousMove(0, 0, 10, robot.slowSpeed, this);
        sleep(1000);
    }
}
