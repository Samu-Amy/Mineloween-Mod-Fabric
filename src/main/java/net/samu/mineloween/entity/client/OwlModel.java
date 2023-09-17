package net.samu.mineloween.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
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
                .uv(15, 0).cuboid(0.5F, 0.0F, -2.0F, 2.0F, 0.0F, 3.0F, new Dilation(0.0F))
                .uv(12, 13).cuboid(-2.5F, 0.0F, -2.0F, 2.0F, 0.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-2.0F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_wing = owl.addChild("right_wing", ModelPartBuilder.create().uv(16, 19).cuboid(-1.0F, 0.0F, -2.0F, 1.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -9.0F, 0.0F));

        ModelPartData left_wing = owl.addChild("left_wing", ModelPartBuilder.create().uv(20, 9).cuboid(0.0F, 0.0F, -2.0F, 1.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -9.0F, 0.0F));

        ModelPartData testa = owl.addChild("testa", ModelPartBuilder.create().uv(0, 13).cuboid(-0.5F, -11.5F, -3.5F, 1.0F, 1.5F, 1.0F, new Dilation(0.0F))
                .uv(0, 13).cuboid(-2.5F, -14.0F, -2.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(OwlEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

//        this.animateMovement(ModAnimations.OWL_WALK, limbSwing, limbSwingAmount, 2f, 2.5f); TODO: da fare
        this.updateAnimation(entity.idleAnimationState, ModAnimations.OWL_IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(OwlEntity entity, float headYaw, float headPitch, float animationProgress) {
        headYaw = MathHelper.clamp(headYaw, -120.0f, 120.0f);
        headPitch = MathHelper.clamp(headPitch, -10.0f, 30.0f);

        this.head.yaw = headYaw * 0.017453292f;
        this.head.pitch = headPitch * 0.017453292f;
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