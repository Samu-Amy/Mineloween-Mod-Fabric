package net.samu.mineloween.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.entity.custom.GhostVillagerEntity;
import net.samu.mineloween.entity.custom.OwlEntity;
import net.samu.mineloween.entity.layer.ModModelLayers;

public class GhostVillagerRenderer extends MobEntityRenderer<GhostVillagerEntity, GhostVillagerModel<GhostVillagerEntity>> {
    private static final Identifier TEXTURE = new Identifier(MineloweenMod.MOD_ID, "textures/entity/ghost_villager.png");
    public GhostVillagerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new GhostVillagerModel<>(ctx.getPart(ModModelLayers.GHOST_VILLAGER)), 0.4f);
    }

    @Override
    public Identifier getTexture(GhostVillagerEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(GhostVillagerEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.65f, 0.65f, 0.65f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
