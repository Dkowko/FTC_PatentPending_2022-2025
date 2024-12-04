package org.firstinspires.ftc.teamcode.autos.demo;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.botconfigs.HolonomicBot;
import org.firstinspires.ftc.teamcode.hardware.AutoMotor;
import org.firstinspires.ftc.teamcode.vision.AprilTagProcessorPosition;
import org.firstinspires.ftc.teamcode.vision.TFPosDetect;

    @Autonomous(name="NitinAuto.java", group = "ppbot")
    public class NitinAuto extends LinearOpMode {

        public HolonomicBot robot;
        public AutoMotor slide;

        @Override
        public void runOpMode() {

            robot = new HolonomicBot(telemetry, hardwareMap);

            robot.closeClaw();
            slide = new AutoMotor(hardwareMap, "motorLS", telemetry, (int)(385 / (1.3 * Math.PI)));



            sleep(1000); //robot stays still / "sleeps"
            robot.upWrist(); //robot wrist lifts/raises
            robot.upWrist();
            sleep(1000);


            //slide.autonomousMove(-10, 2, this); // robot slide moves
            //sleep(500);


            robot.autonomousMove(-5, 10, 0, 0.35, this);
            //robot.autonomousMove(0, 0, 0 , robot.slowSpeed, this);


            sleep(1000); // pause

            //robot.claw.setPosition(0.74);
            sleep(1000); // pause
            //robot.autonomousMove(0, -2, 0, robot.midSpeed, this);


            robot.autonomousMove(-56, -3, 0, 0.5, this);
            robot.autonomousMove(0, -2, 0, 0.5, this);



        }
    }




