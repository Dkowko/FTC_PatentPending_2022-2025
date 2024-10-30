package org.firstinspires.ftc.teamcode.autos.demo;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.botconfigs.PPBot;
import org.firstinspires.ftc.teamcode.vision.AprilTagProcessorPosition;
import org.firstinspires.ftc.teamcode.vision.TFPosDetect;

    @Autonomous(name="NitinAuto.java", group = "ppbot")
    public class NitinAuto extends LinearOpMode {

        public PPBot robot;

        @Override
        public void runOpMode() {

            robot = new PPBot(telemetry, hardwareMap);

            robot.closeClaw();




            sleep(1000); //robot stays still / "sleeps"
            robot.upWrist(); //robot wrist lifts/raises
            robot.upWrist();
            sleep(1000);


            robot.slide.autonomousMove(-10, 2, this); // robot slide moves
            sleep(500);


            robot.autonomousMove(-5, 10, 0, robot.slowSpeed, this);
            //robot.autonomousMove(0, 0, 0 , robot.slowSpeed, this);


            sleep(1000); // pause

            //robot.claw.setPosition(0.74);
            sleep(1000); // pause
            //robot.autonomousMove(0, -2, 0, robot.midSpeed, this);


            robot.autonomousMove(56, -3, 0, robot.midSpeed, this);
            robot.autonomousMove(0, -2, 0, robot.midSpeed, this);



        }
    }




