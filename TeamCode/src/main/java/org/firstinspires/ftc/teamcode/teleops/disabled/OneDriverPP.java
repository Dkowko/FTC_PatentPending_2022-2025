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
@TeleOp(name="OneDriverPP", group="ClawLiftBot")
public class OneDriverPP extends OpMode {

    GyroWrap gyro;


    pp robot;
    //    Servo rightClaw;
//    Servo leftClaw;
    public ServoEx rightClaw;
    public ServoEx leftClaw;


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
        rightClaw = new SimpleServo(hardwareMap, "rightClaw", 0, 180);
        leftClaw = new SimpleServo(hardwareMap, "leftClaw", 0, 180);

        input = new GamepadSystem(this);
    }

    // called repeatedly during program
    @Override
    public void loop() {
        speed = -gamepad1.left_stick_y;
        turn = -gamepad1.right_stick_x;
        strafe = -gamepad1.left_stick_x;

        if(gamepad1.right_trigger > 0) robot.motorLS.set(gamepad1.right_trigger);
        if(gamepad1.left_trigger > 0) robot.motorLS.set(-1 * gamepad1.left_trigger);

//        robot.motorLS.set(gamepad2.left_stick_y);


//        robot.rightClaw.setPosition(gamepad2.right_stick_x);
//        robot.leftClaw.setPosition(-gamepad2.right_stick_x);
        robot.drive.driveFieldCentric(
                input.gamepad1.getLeftY() * -linearSpeed,
                input.gamepad1.getLeftX() * -linearSpeed,
                input.gamepad1.getRightX() * -turnSpeed,
                -gyro.getAngle() / 2 / Math.PI * 360);

        telemetry.addData("gyro", gyro.getAngle());

// new code
        //full close=1
        if (input.gamepad1.getButton(GamepadKeys.Button.RIGHT_BUMPER)) {
            rightClaw.setPosition(0);
            leftClaw.setPosition(.4);
            telemetry.addData("servo", "close");
            telemetry.update();
        }
        //full open=0
        if (input.gamepad1.getButton(GamepadKeys.Button.LEFT_BUMPER)) {
            rightClaw.setPosition(.5);
            leftClaw.setPosition(.1);
            telemetry.addData("servo", "open");
            telemetry.update();




//        robot.drive.driveRobotCentric(
//                input.gamepad1.getLeftY() * -linearSpeed,
//                input.gamepad1.getLeftX() * -linearSpeed,
//                input.gamepad1.getRightX() * -turnSpeed);
        }

    }}

