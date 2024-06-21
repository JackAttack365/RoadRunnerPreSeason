package org.firstinspires.ftc.teamcode.subsystem.sensor;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Config;

import org.firstinspires.ftc.teamcode.subsystem.SubSystem;

import com.acmerobotics.roadrunner.Pose2d;

public class Odometry extends SubSystem {

    private DcMotorEx parL = null;
    private DcMotorEx parR = null;
    private DcMotorEx perp = null;

    public double x = 0;
    public double y = 0;
    public double heading = 0;

    int lastParLPos = 0;
    int lastParRPos = 0;
    int lastPerpPos = 0;

    public final int TICKS_PER_REV = 2000;
    public final int WHEEL_DIAMETER = 5;
    public final int TICKS_PER_INCH = TICKS_PER_REV*WHEEL_DIAMETER;

    public final double ROBOT_WIDTH = Config.ROBOT_WIDTH;

    public Odometry(Config cfg) {
        super(cfg);
    }

    public Odometry(Config cfg, boolean isOneController) {
        super(cfg, isOneController);
    }

    @Override
    public void init() {
        parL = config.hardwareMap.get(DcMotorEx.class, "leftFrontDrive");
        parR = config.hardwareMap.get(DcMotorEx.class, "rightFrontDrive");
        perp = config.hardwareMap.get(DcMotorEx.class, "rightBackDrive");
    }

    @Override
    public void update() {
        int parLPos = parL.getCurrentPosition();
        int parRPos = parR.getCurrentPosition();
        int perpPos = perp.getCurrentPosition();

        double deltaParL = parLPos - lastParLPos;
        double deltaParR = parRPos - lastParRPos;
        double deltaPerp = perpPos - lastPerpPos;

        lastParLPos = parLPos;
        lastParRPos = parRPos;
        lastPerpPos = perpPos;

        double deltaParLInInches = deltaParL / TICKS_PER_INCH;
        double deltaParRInInches = deltaParR / TICKS_PER_INCH;
        double deltaPerpInInches = deltaPerp / TICKS_PER_INCH;

        double deltaForward = (deltaParLInInches + deltaParRInInches) / 2;
        double deltaHeading = (deltaParRInInches - deltaParLInInches) / ROBOT_WIDTH;

        this.x += deltaForward * Math.cos(heading) + deltaPerpInInches * Math.sin(heading);
        this.y += deltaForward * Math.sin(heading) - deltaPerpInInches * Math.cos(heading);
        this.heading += deltaHeading;
    }

    public Pose2d getPose() {
        return new Pose2d(x,y,heading);
    }


}
