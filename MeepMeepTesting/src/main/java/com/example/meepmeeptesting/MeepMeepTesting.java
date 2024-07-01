package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(100, 100, Math.toRadians(180), Math.toRadians(180), 18)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(12, 60, Math.toRadians(270)))
                .lineToY(34.5)
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(47,34.5), Math.toRadians(0))
                .waitSeconds(1)
                .strafeTo(new Vector2d(-52,34.5))
                .waitSeconds(1)
                .strafeTo(new Vector2d(47,34.5))
                .waitSeconds(1)
                .strafeTo(new Vector2d(-52,34.5))
                .waitSeconds(1)
                .strafeTo(new Vector2d(47,34.5))
                .waitSeconds(1)
                .strafeTo(new Vector2d(-34,34.5))
                .splineTo(new Vector2d(-52,24), Math.toRadians(180))
                .waitSeconds(1)
                .splineTo(new Vector2d(-34,34.5), Math.toRadians(0))
                .strafeTo(new Vector2d(47,34.5))
                .waitSeconds(1)
                .strafeTo(new Vector2d(47,59))
                .strafeTo(new Vector2d(59,59))
                .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}