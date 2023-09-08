package net.samu.mineloween.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GEM_ORE);
        BlockStateModelGenerator.BlockTexturePool gemmedCobblestoneTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GEMMED_COBBLESTONE);
        gemmedCobblestoneTexturePool.stairs(ModBlocks.GEMMED_COBBLESTONE_STAIRS);
        gemmedCobblestoneTexturePool.slab(ModBlocks.GEMMED_COBBLESTONE_SLAB);
        gemmedCobblestoneTexturePool.wall(ModBlocks.GEMMED_COBBLESTONE_WALL);
        gemmedCobblestoneTexturePool.fenceGate(ModBlocks.GEMMED_COBBLESTONE_FENCE_GATE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEM_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEM_CRYSTALS, Models.GENERATED);
        itemModelGenerator.register(ModItems.DARK_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.GEM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GEM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GEM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GEM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GEM_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SCYTHE, Models.HANDHELD);
    }
}
