package net.samu.mineloween.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.samu.mineloween.entity.animations.ModAnimations;
import net.samu.mineloween.entity.custom.GhostVillagerEntity;
import net.samu.mineloween.entity.custom.OwlEntity;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
public class GhostVillagerModel<T extends GhostVillagerEntity> extends SinglePartEntityModel<T> {
    private final ModelPart ghost_villager;
    private final ModelPart head;

    public GhostVillagerModel(ModelPart root) {
        this.ghost_villager = root.getChild("ghost_villager");
        this.head = ghost_villager.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData ghost_villager = modelPartData.addChild("ghost_villager", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData head = ghost_villager.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -14.0F, -4.0F, 8.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

        ModelPartData nose = head.addChild("nose", ModelPartBuilder.create().uv(24, 0).cuboid(-1.0F, -5.0F, -6.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

        ModelPartData arms = ghost_villager.addChild("arms", ModelPartBuilder.create().uv(40, 38).cuboid(-4.0F, 2.9019F, -1.5008F, 8.0F, 4.0F, 4.0F, new Dilation(0.0F))
                .uv(44, 22).cuboid(-8.0F, -1.0981F, -1.5008F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -26.05F, -0.8F, -0.7505F, 0.0F, 0.0F));

        ModelPartData mirrored = arms.addChild("mirrored", ModelPartBuilder.create().uv(44, 22).mirrored().cuboid(4.0F, -25.9754F, -5.778F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 24.8773F, 4.2772F));

        ModelPartData right_leg = ghost_villager.addChild("right_leg", ModelPartBuilder.create().uv(0, 22).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -12.0F, 0.0F));

        ModelPartData left_leg = ghost_villager.addChild("left_leg", ModelPartBuilder.create().uv(0, 22).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -12.0F, 0.0F));

        ModelPartData body = ghost_villager.addChild("body", ModelPartBuilder.create().uv(16, 20).cuboid(-4.0F, -4.0F, -3.0F, 8.0F, 12.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    private void setHeadAngles(GhostVillagerEntity entity, float headYaw, float headPitch, float animationProgress) {
        headYaw = MathHelper.clamp(headYaw, -50.0f, 50.0f);
        headPitch = MathHelper.clamp(headPitch, 30, 30.0f);

        this.head.yaw = headYaw * 0.017453292f;
        this.head.pitch = headPitch * 0.017453292f;
    }


    @Override
    public void setAngles(GhostVillagerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

        this.updateAnimation(entity.idleAnimationState, ModAnimations.GHOST_VILLAGER_IDLE, ageInTicks, 1f);
        this.animateMovement(ModAnimations.GHOST_VILLAGER_WALK, limbSwing, limbSwingAmount, 1f, 1.5f);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        ghost_villager.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return ghost_villager;
    }
}