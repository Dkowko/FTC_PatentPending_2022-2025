package org.firstinspires.ftc.teamcode.autos.demo;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.vision.AprilTagProcessorPosition;

@Autonomous(name="AprilTagPositionDemo", group="Concept")
public class AprilTagPositionDemo extends LinearOpMode {

    AprilTagProcessorPosition aprilTagProcessorPosition = new AprilTagProcessorPosition(telemetry);

    @Override
    public void runOpMode() {

        aprilTagProcessorPosition.initAprilTag(hardwareMap);

        while (opModeInInit()) {
            aprilTagProcessorPosition.telemetryAprilTag();
            telemetry.update();
        }

        aprilTagProcessorPosition.closeAprilTag();
    }
}
