package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);
        int blue = 0;

        RoadRunnerBotEntity blueBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(100, 100, Math.toRadians(180), Math.toRadians(180), 18)
                .setColorScheme(new ColorSchemeBlueDark())
                .build();

        RoadRunnerBotEntity redBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(100, 100, Math.toRadians(180), Math.toRadians(180), 18)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        blue = 1;
        blueBot.runAction(blueBot.getDrive().actionBuilder(new Pose2d(12, 60*blue, Math.toRadians(270)))
                .lineToY(34.5*blue)
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(47,34.5*blue), Math.toRadians(0))
                .waitSeconds(1)
                .strafeTo(new Vector2d(-52,34.5*blue))
                .waitSeconds(1)
                .strafeTo(new Vector2d(47,34.5*blue))
                .waitSeconds(1)
                .strafeTo(new Vector2d(-52,34.5*blue))
                .waitSeconds(1)
                .strafeTo(new Vector2d(47,34.5*blue))
                .waitSeconds(1)
                .strafeTo(new Vector2d(-34,34.5*blue))
                .splineTo(new Vector2d(-52,24*blue), Math.toRadians(180))
                .waitSeconds(1)
                .splineTo(new Vector2d(-34,34.5*blue), Math.toRadians(0))
                .strafeTo(new Vector2d(47,34.5*blue))
                .waitSeconds(1)
                .strafeTo(new Vector2d(47,59*blue))
                .strafeTo(new Vector2d(59,59*blue))
                .build());

        blue = -1;
        redBot.runAction(redBot.getDrive().actionBuilder(new Pose2d(12, 60*blue, Math.toRadians(270)))
                .lineToY(34.5*blue)
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(47,34.5*blue), Math.toRadians(0))
                .waitSeconds(1)
                .strafeTo(new Vector2d(-52,34.5*blue))
                .waitSeconds(1)
                .strafeTo(new Vector2d(47,34.5*blue))
                .waitSeconds(1)
                .strafeTo(new Vector2d(-52,34.5*blue))
                .waitSeconds(1)
                .strafeTo(new Vector2d(47,34.5*blue))
                .waitSeconds(1)
                .strafeTo(new Vector2d(-34,34.5*blue))
                .splineTo(new Vector2d(-52,24*blue), Math.toRadians(180))
                .waitSeconds(1)
                .splineTo(new Vector2d(-34,34.5*blue), Math.toRadians(0))
                .strafeTo(new Vector2d(47,34.5*blue))
                .waitSeconds(1)
                .strafeTo(new Vector2d(47,59*blue))
                .strafeTo(new Vector2d(59,59*blue))
                .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(blueBot)
                .addEntity(redBot)
                .start();
    }
}