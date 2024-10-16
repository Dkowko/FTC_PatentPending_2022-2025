package org.firstinspires.ftc.teamcode.autos.demo;

public class PPAuto1 {package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.botconfigs.PPBot;
import org.firstinspires.ftc.teamcode.vision.AprilTagProcessorPosition;
import org.firstinspires.ftc.teamcode.vision.TFPosDetect;

    @Autonomous(name="NitinAuto", group = "ppbot")
    public class NitinAuto extends LinearOpMode {

        public PPBot robot;

        @Override
        public void runOpMode() {

            robot = new PPBot(telemetry, hardwareMap);

            robot.closeClaw();




            sleep(1000);
            robot.upWrist();
            robot.upWrist();
            sleep(1000);


            robot.slide.autonomousMove(-10, 2, this);
            sleep(500);


            robot.autonomousMove(-5, 10, 0, robot.slowSpeed, this);
            //robot.autonomousMove(0, 0, 0 , robot.slowSpeed, this);


            sleep(1000);

            //robot.claw.setPosition(0.74);
            sleep(1000);
            //robot.autonomousMove(0, -2, 0, robot.midSpeed, this);


            robot.autonomousMove(56, -3, 0, robot.midSpeed, this);
            robot.autonomousMove(0, -2, 0, robot.midSpeed, this);



        }
    }


}
