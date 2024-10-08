package org.firstinspires.ftc.teamcode.teleops.disabled;

import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.botconfigs.PursuitBot;
import org.firstinspires.ftc.teamcode.hardware.GamepadSystem;

// Rohan's teleop to test claw for cones
@TeleOp(name="ClawLiftTele", group="ClawLiftBot")
public class ClawLiftTele extends OpMode {

    PursuitBot robot;

    public double armSpeed = 0.75;

    public double turnSpeed = 0.75;
    public double linearSpeed = 0.75;

    // motor declaration
    public ServoEx clawL;
    public ServoEx clawR;
    public Motor armB;
    public Motor armF;

    // input system reference
    GamepadSystem input;

    // called on program initialization
    @Override
    public void init() {

        robot = new PursuitBot(telemetry, hardwareMap);

        // initialize hardware devices
        clawL = new SimpleServo(hardwareMap, "clawL", 0, 180);
        clawR = new SimpleServo(hardwareMap, "clawR", 0, 180);
        armF = new Motor(hardwareMap, "armF");
        armB = new Motor(hardwareMap, "armB");

        armF.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        armB.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        input = new GamepadSystem(this);
    }

    // called repeatedly during program
    @Override
    public void loop() {

        robot.drive.driveRobotCentric(
                input.gamepad1.getLeftY() * linearSpeed,
                input.gamepad1.getLeftX() * linearSpeed,
                input.gamepad1.getRightX() * turnSpeed);

        armF.set(input.gamepad2.getRightY() * armSpeed);
        armB.set(input.gamepad2.getLeftY() * armSpeed);

        //full close=1
        if (input.gamepad2.getButton(GamepadKeys.Button.RIGHT_BUMPER)) {
            clawL.setPosition(1);
            clawR.setPosition(0);
            telemetry.addData("servo", "close");
            telemetry.update();
        }
        //full open=0
        if (input.gamepad2.getButton(GamepadKeys.Button.LEFT_BUMPER)) {
            clawL.setPosition(0);
            clawR.setPosition(1);
            telemetry.addData("servo", "open");
            telemetry.update();
        }

    }
}
