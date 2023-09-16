package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.botconfigs.HolonomicBot;

@TeleOp(name="HolonomicBotTele", group="HolonomicBot")
public class HolonomicBotTele extends OpMode {

    // robot reference
    public HolonomicBot robot;

    // called on robot initialization
    @Override
    public void init() {

        // get reference to robot
        robot = new HolonomicBot(telemetry, hardwareMap);
    }

    // looped after start
    @Override
    public void loop() {

        // move robot based on controller inputs
        robot.driveRobotCentric(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
    }
}
