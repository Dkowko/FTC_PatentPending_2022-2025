package org.firstinspires.ftc.teamcode.botconfigs;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardware.MecDriveFlip;

public class HolonomicBot {

    // debugging device
    public Telemetry tele;

    // mecanum wheel drive train
    public MecanumDrive drive;
    public Motor motorFL;
    public Motor motorFR;
    public Motor motorBL;
    public Motor motorBR;

    // speeds
    public double linearSpeed = 1;
    public double turnSpeed = 1;
    public double speedFactor = 1;

    public double tickPerInch = 28 * 20 / (3 * Math.PI);

    public HolonomicBot(Telemetry tele, HardwareMap map) {

        // store debugging device
        this.tele = tele;

        // initialize drive train
        motorFL = new Motor(map, "motorFL");
        motorFR = new Motor(map, "motorFR");
        motorBL = new Motor(map, "motorBL");
        motorBR = new Motor(map, "motorBR");
        drive = new MecDriveFlip(motorFL, motorFR, motorBL, motorBR);

        // run mode
        setRunMode(Motor.RunMode.PositionControl);
    }

    public void setRunMode(Motor.RunMode mode) {

        motorFL.setRunMode(mode);
        motorFR.setRunMode(mode);
        motorBL.setRunMode(mode);
        motorBR.setRunMode(mode);
    }

    public double[] toMotor(double x, double y, double rot) {

        return new double[] {
                +x +y +rot,
                +x -y +rot,
                -x +y +rot,
                -x -y +rot
        };
    }

    public void setTargetPosition(double x, double y, double rot) {

        double[] asMotor = toMotor(x, y, rot);
        setTargetPosition(new int[] {
                motorFL.getCurrentPosition() + (int)(asMotor[0] * tickPerInch),
                motorFR.getCurrentPosition() + (int)(asMotor[1] * tickPerInch),
                motorBL.getCurrentPosition() + (int)(asMotor[2] * tickPerInch),
                motorBR.getCurrentPosition() + (int)(asMotor[3] * tickPerInch)
        });
    }

    public void toTargetPosition(double speed) {

        motorFL.set(speed);
        motorFR.set(speed);
        motorBL.set(speed);
        motorBR.set(speed);
    }

    public void waitUntilNotBusy(LinearOpMode opMode) {

        while (isBusy() && opMode.opModeIsActive()) { }
    }

    public boolean isBusy() {

        return motorFL.motor.isBusy() || motorFR.motor.isBusy() || motorBL.motor.isBusy() || motorBR.motor.isBusy();
    }

    public void setTargetPosition(int[] asMotor) {

        motorFL.setTargetPosition(asMotor[0]);
        motorFL.setTargetPosition(asMotor[1]);
        motorFL.setTargetPosition(asMotor[2]);
        motorFL.setTargetPosition(asMotor[3]);
    }

    public void autonomousMove(double x, double y, double rot, double speed, LinearOpMode opMode) {

        setTargetPosition(x, y, rot);
        toTargetPosition(speed);
        waitUntilNotBusy(opMode);
        driveRobotCentric(0, 0, 0);
    }

    public void driveRobotCentric(double x, double y, double rot) {
        drive.driveRobotCentric(x * linearSpeed * speedFactor, y * linearSpeed * speedFactor, rot * speedFactor);
    }
}
