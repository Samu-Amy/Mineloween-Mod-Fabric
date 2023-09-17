package net.samu.mineloween.entity.animations;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class ModAnimations {



    public static final Animation OWL_IDLE = Animation.Builder.create(3.2916765f).looping()
            .addBoneAnimation("right_wing",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.9167666f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.2916767f, AnimationHelper.createRotationalVector(-110.04f, -7.83f, -14.05f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.7083433f, AnimationHelper.createRotationalVector(-113.7f, -14.36f, -16.97f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2.0416765f, AnimationHelper.createRotationalVector(-112.21f, -13.36f, -11.88f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2.4167665f, AnimationHelper.createRotationalVector(3f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC)))
            .addBoneAnimation("left_wing",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, AnimationHelper.createRotationalVector(-5f, -0.22f, -2.49f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.3433333f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.4583433f, AnimationHelper.createRotationalVector(-4f, -0.22f, -2.49f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5834333f, AnimationHelper.createRotationalVector(3f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.625f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC)))
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.9167666f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.25f, AnimationHelper.createRotationalVector(10.12f, 42.05f, 6.82f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(20.65f, 46.16f, 12.41f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.7083433f, AnimationHelper.createRotationalVector(13.15f, 46.16f, 12.41f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.9167667f, AnimationHelper.createRotationalVector(20.65f, 46.16f, 12.41f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(2.125f, AnimationHelper.createRotationalVector(11.65f, 46.16f, 12.41f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(2.4583435f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC))).build();
    public static final Animation OWL_FLY = Animation.Builder.create(0.7916766f).looping()
            .addBoneAnimation("right_wing",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -2f, 1f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_wing",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-13.78f, 67.68f, 73.96f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.20834334f, AnimationHelper.createRotationalVector(-66.94f, 29.43f, 11.75f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.7916766f, AnimationHelper.createRotationalVector(-13.78f, 67.68f, 73.96f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_wing",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -2f, 1f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_wing",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-21.15f, -71.03f, -67.83f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.20834334f, AnimationHelper.createRotationalVector(-69.2f, -26.51f, -9.21f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.7916766f, AnimationHelper.createRotationalVector(-21.15f, -71.03f, -67.83f),
                                    Transformation.Interpolations.LINEAR))).build();
}
