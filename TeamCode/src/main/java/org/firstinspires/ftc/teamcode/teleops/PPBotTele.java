package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.botconfigs.PPBot;

@TeleOp(name="PPBotTele", group="PPBot")
public class PPBotTele extends OpMode {

    // robot reference
    public PPBot robot;

    // called on robot initialization
    @Override
    public void init() {

        // get reference to robot
        robot = new PPBot(telemetry, hardwareMap);
    }

    @Override
    public void init_loop() {

        robot.openClaw();
        robot.downWrist();
        //robot.holdDrone();
    }

    // looped after start
    @Override
    public void loop() {

        robot.updateSpeed(gamepad1);
        robot.updateGyro(gamepad1);

        // move robot based on controller inputs
        robot.driveFieldCentric(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x, robot.gyro.getAngle());

        // move claw and slide
        //if (gamepad1.left_bumper) robot.holdDrone();
        //else if (gamepad1.right_bumper) robot.releaseDrone();
        if (gamepad2.left_trigger > 0.5) robot.downWrist();
        else if (gamepad2.right_trigger > 0.5) robot.upWrist();
        if (gamepad2.left_bumper) robot.closeClaw();
        else if (gamepad2.right_bumper) robot.openClaw();
        robot.lift.set(-gamepad2.right_stick_y);
        robot.raiseSlide(-gamepad2.left_stick_y);
    }
}
