package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.botconfigs.HolonomicBot;
import org.firstinspires.ftc.teamcode.botconfigs.PPBot;

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
        robot.driveRobotCentric(-gamepad1.left_stick_x, gamepad1.left_stick_y, -gamepad1.right_stick_x);


        if (gamepad2.left_trigger > 0.5) {
            robot.downWrist(); // DOWN WRIST COMMAND
        }
        if (gamepad2.right_trigger > 0.5) {
            robot.upWrist(); // UP WRIST COMMAND
        }
        if (!gamepad2.left_bumper) {
            if (gamepad2.right_bumper) {
                robot.openClaw(); // OPEN CLAW COMMAND
            }
        } else {
            robot.closeClaw(); // CLOSE CLAW COMMAND
        }

        if(gamepad2.dpad_up)
        {
            robot.eeeRRR.setPower(0.6);
        }
        else if(gamepad2.dpad_down)
        {
            robot.eeeRRR.setPower(-0.6);
        }
        robot.raiseSlide(-gamepad2.left_stick_y);// RAISE THE SLIDE
    }
}
