package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.botconfigs.PPBot;

@TeleOp(name="PPBotTele", group="PPBot")
public class PPBotTele extends LinearOpMode {


    // robot reference
    public PPBot robot;

    // looped after start
    @Override
    public void runOpMode() {


        robot = new PPBot(telemetry, hardwareMap);

        robot.openClaw();
        robot.downWrist();

        waitForStart();

        while(opModeIsActive())
        {
            loopMode();
        }
    }

    public void loopMode(){
        //robot.updateSpeed(gamepad1);
        //robot.updateGyro(gamepad1);

        // move robot based on controller inputs
        robot.driveRobotCentric(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);

        // move claw and slide

    }
}
