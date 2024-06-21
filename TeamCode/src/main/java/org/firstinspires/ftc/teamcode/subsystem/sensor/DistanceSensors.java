package org.firstinspires.ftc.teamcode.subsystem.sensor;

import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Config;
import org.firstinspires.ftc.teamcode.subsystem.SubSystem;

public class DistanceSensors extends SubSystem {
    DistanceSensor left, right;

    DistanceUnit defaultDistanceUnit = DistanceUnit.INCH;
    public DistanceSensors(Config cfg) {
        super(cfg);
    }

    public DistanceSensors(Config cfg, Boolean isOneController) {
        super(cfg,isOneController);
    }

    @Override
    public void init() {
        left = config.hardwareMap.get(DistanceSensor.class, "leftDistance");
        right = config.hardwareMap.get(DistanceSensor.class, "rightDistance");
    }

    @Override
    public void update() {
        config.telemetry.addData("Distance: Left %0.2f, Right %0.2f", String.valueOf(left.getDistance(defaultDistanceUnit)), right.getDistance(defaultDistanceUnit));
    }
}
