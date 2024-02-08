package org.firstinspires.ftc.teamcode.hardware;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class AutoMotor extends Motor {

    int tickPerInch;
    Telemetry tele;

    public AutoMotor(HardwareMap map, String name, Telemetry tele, int tickPerInch) {
        super(map, name);
        this.tickPerInch = tickPerInch;
        this.tele = tele;
    }

    public void waitUntilNotBusy(double speed, LinearOpMode opMode) {

        tele.update();
        while (motor.isBusy() && opMode.opModeIsActive()) { tele.update(); motor.setPower(speed); }
    }

    public void autonomousMove(double x, double speed, LinearOpMode opMode) {

        motor.setTargetPosition(motor.getCurrentPosition() + (int)(x * tickPerInch));
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        waitUntilNotBusy(speed, opMode);
        set(0);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}
