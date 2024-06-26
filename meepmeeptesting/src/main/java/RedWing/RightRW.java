package RedWing;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class RightRW {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(77, 77, Math.toRadians(180), Math.toRadians(180), 7.55)
                .setDimensions(11,14.5)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-29, -60, Math.toRadians(270)))
                                .back(25)
                                .turn(Math.toRadians(-90))
                                .forward(6)
                                .turn(Math.toRadians(180))
                                .strafeRight(18)
                                .forward(82)
                                .strafeLeft(11)
                                .waitSeconds(1)
                                .strafeRight(18)
                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
