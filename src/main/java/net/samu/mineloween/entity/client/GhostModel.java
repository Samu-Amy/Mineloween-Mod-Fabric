package net.samu.mineloween.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.samu.mineloween.entity.animations.ModAnimations;
import net.samu.mineloween.entity.custom.GhostEntity;

public class GhostModel<T extends GhostEntity> extends SinglePartEntityModel<T> {
    private final ModelPart ghost;
    public GhostModel(ModelPart root) {
        this.ghost = root.getChild("ghost");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData ghost = modelPartData.addChild("ghost", ModelPartBuilder.create().uv(0, 40).cuboid(-5.0F, -11.0F, -6.0F, 10.0F, 21.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 8).cuboid(-5.0F, -11.0F, 4.0F, 10.0F, 21.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-6.0F, -11.0F, -5.0F, 1.0F, 21.0F, 10.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(5.0F, -11.0F, -5.0F, 1.0F, 21.0F, 10.0F, new Dilation(0.0F))
                .uv(26, 28).cuboid(-4.0F, -12.0F, -5.0F, 8.0F, 1.0F, 10.0F, new Dilation(0.0F))
                .uv(26, 39).cuboid(-5.0F, -12.0F, -4.0F, 10.0F, 1.0F, 8.0F, new Dilation(0.0F))
                .uv(34, 55).cuboid(-3.0F, -13.0F, -4.0F, 6.0F, 1.0F, 8.0F, new Dilation(0.0F))
                .uv(34, 48).cuboid(-4.0F, -13.0F, -3.0F, 8.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 0.0F));

        ModelPartData bottom5 = ghost.addChild("bottom5", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 10.0F, 0.0F));

        ModelPartData cube_r1 = bottom5.addChild("cube_r1", ModelPartBuilder.create().uv(4, 7).cuboid(-1.0F, -0.9857F, -0.6543F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -0.0436F));

        ModelPartData bottom6 = ghost.addChild("bottom6", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 10.0F, 3.0F));

        ModelPartData cube_r2 = bottom6.addChild("cube_r2", ModelPartBuilder.create().uv(4, 7).cuboid(2.0F, -0.9857F, -0.6543F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -3.0F, 0.0F, -1.5708F, -0.0436F));

        ModelPartData bottom7 = ghost.addChild("bottom7", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 9.0F, -3.0F));

        ModelPartData cube_r3 = bottom7.addChild("cube_r3", ModelPartBuilder.create().uv(4, 7).cuboid(-4.0F, -0.9857F, -0.6543F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 3.0F, 0.0F, -1.5708F, -0.0436F));

        ModelPartData bottom8 = ghost.addChild("bottom8", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 10.0F, 0.0F));

        ModelPartData cube_r4 = bottom8.addChild("cube_r4", ModelPartBuilder.create().uv(4, 7).cuboid(-1.0F, -0.9857F, -0.6543F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0436F));

        ModelPartData bottom9 = ghost.addChild("bottom9", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 10.0F, 3.0F));

        ModelPartData cube_r5 = bottom9.addChild("cube_r5", ModelPartBuilder.create().uv(4, 7).cuboid(-4.0F, -0.9857F, -0.6543F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -3.0F, 0.0F, 1.5708F, 0.0436F));

        ModelPartData bottom10 = ghost.addChild("bottom10", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 10.0F, -3.0F));

        ModelPartData cube_r6 = bottom10.addChild("cube_r6", ModelPartBuilder.create().uv(4, 7).cuboid(2.0F, -0.9857F, -0.6543F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 3.0F, 0.0F, 1.5708F, 0.0436F));

        ModelPartData bottom11 = ghost.addChild("bottom11", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 10.0F, -5.0F));

        ModelPartData cube_r7 = bottom11.addChild("cube_r7", ModelPartBuilder.create().uv(4, 7).cuboid(-1.0F, -0.9857F, -0.6543F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

        ModelPartData bottom12 = ghost.addChild("bottom12", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 10.0F, -5.0F));

        ModelPartData cube_r8 = bottom12.addChild("cube_r8", ModelPartBuilder.create().uv(4, 7).cuboid(-4.0F, -0.9857F, -0.6543F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

        ModelPartData bottom4 = ghost.addChild("bottom4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 10.0F, 5.0F));

        ModelPartData cube_r9 = bottom4.addChild("cube_r9", ModelPartBuilder.create().uv(4, 7).cuboid(2.0F, -0.9857F, -0.6543F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 3.098F, 0.0F, -3.1416F));

        ModelPartData bottom3 = ghost.addChild("bottom3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 10.0F, 5.0F));

        ModelPartData cube_r10 = bottom3.addChild("cube_r10", ModelPartBuilder.create().uv(4, 7).cuboid(-4.0F, -0.9857F, -0.6543F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 3.098F, 0.0F, -3.1416F));

        ModelPartData bottom2 = ghost.addChild("bottom2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 10.0F, 5.0F));

        ModelPartData cube_r11 = bottom2.addChild("cube_r11", ModelPartBuilder.create().uv(4, 7).cuboid(-1.0F, -0.9857F, -0.6543F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 3.098F, 0.0F, -3.1416F));

        ModelPartData bottom1 = ghost.addChild("bottom1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 10.0F, -5.0F));

        ModelPartData cube_r12 = bottom1.addChild("cube_r12", ModelPartBuilder.create().uv(4, 7).cuboid(2.0F, -0.9857F, -0.6543F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    private void setHeadAngles(GhostEntity entity, float headYaw, float headPitch, float animationProgress) {
        headYaw = MathHelper.clamp(headYaw, -360.0f, 360.0f);

        this.ghost.yaw = headYaw * 0.017453292f;
    }

    @Override
    public void setAngles(GhostEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

        this.animateMovement(ModAnimations.GHOST_IDLE, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ModAnimations.GHOST_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, ModAnimations.GHOST_ATTACK, ageInTicks, 1f);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        ghost.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return ghost;
    }
}