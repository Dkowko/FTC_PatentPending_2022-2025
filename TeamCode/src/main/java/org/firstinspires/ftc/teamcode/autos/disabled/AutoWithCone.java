package org.firstinspires.ftc.teamcode.autos.disabled;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.vision.VisionDevice;
import org.openftc.apriltag.AprilTagDetection;

@Disabled
@Autonomous(name = "WithCamWithCone", group = "WithCamWithCone")
public class AutoWithCone extends LinearOpMode {

    VisionDevice vision;

    DcMotor motorFL;
    DcMotor motorFR;
    DcMotor motorBL;
    DcMotor motorBR;
    DcMotor motorLS;
    public ServoEx rightClaw;
    public ServoEx leftClaw;


    @Override
    public void runOpMode() throws InterruptedException {
        motorFL = hardwareMap.dcMotor.get("motorFL");
        motorFR = hardwareMap.dcMotor.get("motorFR");
        motorBL = hardwareMap.dcMotor.get("motorBL");
        motorBR = hardwareMap.dcMotor.get("motorBR");
        motorLS = hardwareMap.dcMotor.get("motorLS");

        rightClaw = new SimpleServo(hardwareMap, "rightClaw", 0, 180);
        leftClaw = new SimpleServo(hardwareMap, "leftClaw", 0, 180);

        motorFL.setDirection(DcMotor.Direction.REVERSE);
        motorBR.setDirection(DcMotor.Direction.REVERSE);



        vision = new VisionDevice();
        vision.initialize(hardwareMap, telemetry);

        AprilTagDetection visionTag = null;

        while (!isStarted()) {

            visionTag = vision.getTag(telemetry);
        }

        // MOVEMENT CODE    |
        //                  |
        //                  v


        waitForStart();


        if (visionTag == null) {

            telemetry.addData("id", "null");
            telemetry.update();

        } else if (visionTag.id == vision.LEFT) {

            // LEFT
            motorFL.setPower(-.5);
            motorFR.setPower(.5);
            motorBL.setPower(-.5);
            motorBR.setPower(.5);

            sleep(1350);

            motorFL.setPower(0);
            motorFR.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);

            sleep(1500);

            motorFL.setPower(.5);
            motorFR.setPower(.5);
            motorBL.setPower(-.5);
            motorBR.setPower(-.5);

            sleep(1500);

            motorFL.setPower(0);
            motorFR.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);

        } else if (visionTag.id == vision.MIDDLE) {

            // MIDDLE
            // close claw
            rightClaw.setPosition(0.2);
            leftClaw.setPosition(.6);

            sleep(1000);

            // go right
            motorFL.setPower(.3);
            motorFR.setPower(.3);
            motorBL.setPower(-.3);
            motorBR.setPower(-.3);

            sleep(4200);

            motorFL.setPower(0);
            motorFR.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);

            sleep(1000);

             //go right
            motorFL.setPower(.4);
            motorFR.setPower(-.4);
            motorBL.setPower(.4);
            motorBR.setPower(-.4);

            sleep(100);

            motorFL.setPower(0);
            motorFR.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);

            sleep(1000);

            // lift linear slide
            motorLS.setPower(-1);

            sleep(1100);

            motorLS.setPower(-1);

            sleep(1000);

            // go forward
//            motorFL.setPower(.4);
//            motorFR.setPower(.4);
//            motorBL.setPower(-.4);
//            motorBR.setPower(-.4);
//
//            sleep(10);

            motorFL.setPower(0);
            motorFR.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);

//            // lift linear slide
//            motorLS.setPower(-1);
//
//            sleep(1000);
//
//            motorLS.setPower(-1);
//
//            sleep(1000);

            // slower slide
            motorLS.setPower(1);

            sleep(230);

            // drop cone
            rightClaw.setPosition(.5);
            leftClaw.setPosition(.1);

            sleep(100);

//            // close claw
//            rightClaw.setPosition(0.2);
//            leftClaw.setPosition(.6);

            motorFL.setPower(0);
            motorFR.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);

            sleep(1000);




        } else if (visionTag.id == vision.RIGHT) {

            // RIGHT
            rightClaw.setPosition(0.2);
            leftClaw.setPosition(.6);

            motorFL.setPower(.5);
            motorFR.setPower(.5);
            motorBL.setPower(-.5);
            motorBR.setPower(-.5);

            sleep(130);

            motorFL.setPower(0);
            motorFR.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);

            sleep(1500);

            motorFL.setPower(.3);
            motorFR.setPower(-.3);
            motorBL.setPower(.3);
            motorBR.setPower(-.3);

            sleep(100);

            motorLS.setPower(-1);

            sleep(1100);

            motorFL.setPower(.3);
            motorFR.setPower(.3);
            motorBL.setPower(-.3);
            motorBR.setPower(-.3);

            sleep(5);

            // slower slide
            motorLS.setPower(1);

            sleep(230);

            // drop cone
            rightClaw.setPosition(.5);
            leftClaw.setPosition(.1);


//            motorFL.setPower(0);
//            motorFR.setPower(0);
//            motorBL.setPower(0);
//            motorBR.setPower(0);
//
//            sleep(1500);
//
//            motorFL.setPower(.5);
//            motorFR.setPower(.5);
//            motorBL.setPower(-.5);
//            motorBR.setPower(-.5);
//
//            sleep(1450);
//
//            motorFL.setPower(0);
//            motorFR.setPower(0);
//            motorBL.setPower(0);
//            motorBR.setPower(0);

        } else {

            telemetry.addData("id", "invalid");
            telemetry.update();
        }
    }
}
