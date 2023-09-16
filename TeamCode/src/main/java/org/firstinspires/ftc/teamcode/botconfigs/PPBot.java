package org.firstinspires.ftc.teamcode.botconfigs;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class PPBot extends HolonomicBot {

    public double slowSpeed = 0.4;
    public double midSpeed = 0.7;
    public double fastSpeed = 1;

    public PPBot(Telemetry tele, HardwareMap map) {

        super(tele, map);
        speedFactor = fastSpeed;
    }

    public void updateSpeed(Gamepad gamepad1) {

        if (gamepad1.a) speedFactor = midSpeed;
        if (gamepad1.b) speedFactor = slowSpeed;
        if (gamepad1.x) speedFactor = fastSpeed;
    }
}
