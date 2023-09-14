package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.openftc.apriltag.AprilTagDetection;

@Autonomous(name = "WithCam", group = "WithCam")
public class CamDetectionAll extends LinearOpMode {

    VisionDevice vision;

    DcMotor motorFL;
    DcMotor motorFR;
    DcMotor motorBL;
    DcMotor motorBR;


    @Override
    public void runOpMode() throws InterruptedException {
        motorFL = hardwareMap.dcMotor.get("motorFL");
        motorFR = hardwareMap.dcMotor.get("motorFR");
        motorBL = hardwareMap.dcMotor.get("motorBL");
        motorBR = hardwareMap.dcMotor.get("motorBR");

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

            sleep(1300);

            motorFL.setPower(0);
            motorFR.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);

        } else if (visionTag.id == vision.MIDDLE) {

            // MIDDLE
            motorFL.setPower(.5);
            motorFR.setPower(.5);
            motorBL.setPower(-.5);
            motorBR.setPower(-.5);

            sleep(1500);

            motorFL.setPower(0);
            motorFR.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);

        } else if (visionTag.id == vision.RIGHT) {

            // RIGHT
            motorFL.setPower(.5);
            motorFR.setPower(.5);
            motorBL.setPower(-.5);
            motorBR.setPower(-.5);

            sleep(100);

            motorFL.setPower(0);
            motorFR.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);

            sleep(1500);

            motorFL.setPower(.5);
            motorFR.setPower(-.5);
            motorBL.setPower(.5);
            motorBR.setPower(-.5);

            sleep(1200);

            motorFL.setPower(0);
            motorFR.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);

            sleep(1500);

            motorFL.setPower(.5);
            motorFR.setPower(.5);
            motorBL.setPower(-.5);
            motorBR.setPower(-.5);

            sleep(1450);

            motorFL.setPower(0);
            motorFR.setPower(0);
            motorBL.setPower(0);
            motorBR.setPower(0);

        } else {

            telemetry.addData("id", "invalid");
            telemetry.update();
        }
    }
}
