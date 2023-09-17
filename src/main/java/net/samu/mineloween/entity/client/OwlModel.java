package net.samu.mineloween.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.OcelotEntityModel;
import net.minecraft.client.render.entity.model.ParrotEntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.util.math.MathHelper;
import net.samu.mineloween.entity.animations.ModAnimations;
import net.samu.mineloween.entity.custom.OwlEntity;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
public class OwlModel<T extends OwlEntity> extends SinglePartEntityModel<T> {
    private final ModelPart owl;
    private final ModelPart head;
    private final ModelPart right_wing;
    private final ModelPart left_wing;
    public OwlModel(ModelPart root) {
        this.owl = root.getChild("owl");
        this.head = owl.getChild("head");
        this.right_wing = owl.getChild("right_wing");
        this.left_wing = owl.getChild("left_wing");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData owl = modelPartData.addChild("owl", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = owl.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -9.0F, -3.0F, 6.0F, 7.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 3).cuboid(1.0F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 23).cuboid(0.5F, -0.15F, -2.0F, 2.0F, 0.15F, 3.0F, new Dilation(0.0F))
                .uv(0, 23).cuboid(-2.5F, -0.15F, -2.0F, 2.0F, 0.15F, 3.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-2.0F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_wing = owl.addChild("right_wing", ModelPartBuilder.create().uv(16, 19).cuboid(-1.0F, 0.0F, -2.0F, 1.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -9.0F, 0.0F));

        ModelPartData left_wing = owl.addChild("left_wing", ModelPartBuilder.create().uv(20, 9).cuboid(0.0F, 0.0F, -2.0F, 1.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -9.0F, 0.0F));

        ModelPartData head = owl.addChild("head", ModelPartBuilder.create().uv(0, 13).cuboid(-0.5F, -2.5F, -3.2F, 1.0F, 1.5F, 1.0F, new Dilation(0.0F))
                .uv(0, 13).cuboid(-2.5F, -5.0F, -2.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F))
                .uv(10, 16).cuboid(0.8F, -4.0F, -2.8F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(10, 13).cuboid(-1.8F, -4.0F, -2.8F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.0F, 0.0F));

        ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(10, 19).cuboid(-2.0F, -0.1F, -1.15F, 3.0F, 0.1F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -5.0F, -1.25F, -3.1416F, 0.0F, 2.5307F));

        ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(9, 8).cuboid(-2.0F, -0.1F, -1.2F, 3.0F, 0.1F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -5.0F, -1.0F, 0.0F, 0.0F, 0.6109F));
        return TexturedModelData.of(modelData, 32, 32);
    }
//    @Override
//    public void setAngles(OwlEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//        this.getPart().traverse().forEach(ModelPart::resetTransform);
//        this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);
//
//        this.animateMovement(ModAnimations.OWL_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
//        this.updateAnimation(entity.idleAnimationState, ModAnimations.OWL_IDLE, ageInTicks, 1f);
//        this.animateMovement(ModAnimations.OWL_FLY, limbSwing, limbSwingAmount, 2f, 2.5f);
//    }

    private void setHeadAngles(OwlEntity entity, float headYaw, float headPitch, float animationProgress) {
        headYaw = MathHelper.clamp(headYaw, -180.0f, 180.0f);
        headPitch = MathHelper.clamp(headPitch, -15.0f, 45.0f);

        this.head.yaw = headYaw * 0.017453292f;
        this.head.pitch = headPitch * 0.017453292f;
    }


    @Override
    public void setAngles(OwlEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

        this.updateAnimation(entity.idleAnimationState, ModAnimations.OWL_IDLE, ageInTicks, 1f);
        this.animateMovement(ModAnimations.OWL_FLY, limbSwing, limbSwingAmount, 1f, 1.5f);
    }

    public void animateModel(OwlEntity owlEntity, float f, float g, float h) {
        this.animateModel(getPose(owlEntity), owlEntity, f);
    }

    private void animateModel(OwlModel.Pose pose, OwlEntity owlEntity, float f) {
        switch (pose) {
            case STANDING:
                this.updateAnimation(owlEntity.idleAnimationState, ModAnimations.OWL_IDLE, f, 1f);
            case FLYING:
                this.updateAnimation(owlEntity.flyAnimationState, ModAnimations.OWL_FLY, f, 1f);
            default:
                break;
        }

    }
    private static OwlModel.Pose getPose(OwlEntity owl) {
        if (owl.isInAir()) {
            return Pose.FLYING;
        } else {
            return Pose.STANDING;
        }
    }

    @Environment(EnvType.CLIENT)
    public static enum Pose {
        FLYING,
        STANDING;

        private Pose() {
        }
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        owl.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return owl;
    }
}