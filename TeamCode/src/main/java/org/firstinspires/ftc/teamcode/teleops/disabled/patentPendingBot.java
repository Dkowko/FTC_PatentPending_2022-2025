package org.firstinspires.ftc.teamcode.teleops.disabled;

import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.GyroWrap;
import org.firstinspires.ftc.teamcode.botconfigs.pp;
import org.firstinspires.ftc.teamcode.hardware.GamepadSystem;

// Rohan's teleop to test claw for cones
@TeleOp(name="patentPendingBot", group="ClawLiftBot")
public class patentPendingBot extends OpMode {

    GyroWrap gyro;


    pp robot;
    //    Servo rightClaw;
//    Servo leftClaw;
    public ServoEx wrist;
    public ServoEx claw;


    public double armSpeed = 0.75;

    public double turnSpeed = 0.75;
    public double linearSpeed = 0.75;
    public double speed;
    public double turn;
    public double strafe;


    // input system reference
    GamepadSystem input;

    // called on program initialization
    @Override
    public void init() {

        gyro = new GyroWrap(null, telemetry, hardwareMap, "gyro", 0, false);


        robot = new pp(telemetry, hardwareMap);
        input = new GamepadSystem(this);

//        rightClaw = hardwareMap.servo.get("rightClaw");
//        leftClaw = hardwareMap.servo.get("leftClaw");
        wrist = new SimpleServo(hardwareMap, "rightClaw", 0, 90);
        claw = new SimpleServo(hardwareMap, "leftClaw", 0, 90);

        input = new GamepadSystem(this);
    }

    // called repeatedly during program
    @Override
    public void loop() {
        speed = -gamepad1.left_stick_y;
        turn = -gamepad1.right_stick_x;
        strafe = -gamepad1.left_stick_x;
        robot.motorLS.set(gamepad2.left_stick_y);
//        robot.rightClaw.setPosition(gamepad2.right_stick_x);
//        robot.leftClaw.setPosition(-gamepad2.right_stick_x);
        robot.drive.driveFieldCentric(
                input.gamepad1.getLeftY() * -linearSpeed,
                input.gamepad1.getLeftX() * -linearSpeed,
                input.gamepad1.getRightX() * -turnSpeed,
                -gyro.getAngle() / 2 / Math.PI * 360);

        telemetry.addData("gyro", gyro.getAngle());
        if (gamepad2.left_trigger > 0.5) downWrist();
        else if (gamepad2.right_trigger > 0.5) upWrist();
        if (gamepad2.left_bumper) closeClaw();
        else if (gamepad2.right_bumper) openClaw();

    }





    public void upWrist() {

        wrist.setPosition(0.35);
    }

    public void downWrist() {

        wrist.setPosition(0.05);
    }

    public void openClaw() {

        claw.setPosition(0.75);
    }

    public void closeClaw() {

        claw.setPosition(0.6);
    }
}
