package net.samu.mineloween;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.entity.ModEntities;
import net.samu.mineloween.entity.client.*;
import net.samu.mineloween.entity.layer.ModModelLayers;
import net.samu.mineloween.particle.AutumnalLeavesParticle;
import net.samu.mineloween.particle.ModParticles;
import net.samu.mineloween.screen.GemstoneGrinderScreen;
import net.samu.mineloween.screen.ModScreenHandlers;

public class MineloweenModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MALVA_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAVANDA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_LAVANDA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MALVA_FLOWER, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASH_SAPLING, RenderLayer.getCutout());

        ParticleFactoryRegistry.getInstance().register(ModParticles.AUTUMNAL_LEAVES_PARTICLE, AutumnalLeavesParticle.Factory::new);

        HandledScreens.register(ModScreenHandlers.GEMSTONE_GRINDER_SCREEN_HANDLER, GemstoneGrinderScreen::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.OWL, OwlModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GHOST, GhostModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GHOST_VILLAGER, GhostVillagerModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.OWL, OwlRenderer::new);
        EntityRendererRegistry.register(ModEntities.GHOST, GhostRenderer::new);
        EntityRendererRegistry.register(ModEntities.GHOST_VILLAGER, GhostVillagerRenderer::new);
    }
}
