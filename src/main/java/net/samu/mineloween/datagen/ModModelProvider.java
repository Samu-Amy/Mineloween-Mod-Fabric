package net.samu.mineloween.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.block.custom.DecorativeBookshelfBlock;
import net.samu.mineloween.item.ModItems;

import java.util.Optional;

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

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DECORATIVE_BOOKSHELF);
    }

    private void registerDecorativeBookshelfBlock(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier identifier = TexturedModel.CUBE_ALL.upload(ModBlocks.DECORATIVE_BOOKSHELF, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(ModBlocks.DECORATIVE_BOOKSHELF, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.DECORATIVE_BOOKSHELF).coordinate(BlockStateModelGenerator.createBooleanModelMap(DecorativeBookshelfBlock.VARIANT, identifier2, identifier)));
    }

    public BlockStateModelGenerator.BlockTexturePool registerDecorativeBookshelfBlock(BlockStateModelGenerator blockStateModelGenerator, Block decorativeBookshelfBlock) {
        TextureMap textureMap = TextureMap.textureParticle(decorativeBookshelfBlock);
        Identifier identifier = CustomModels.upload(decorativeBookshelfBlock, textureMap, BlockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.CUSTOM_FENCE_SIDE_NORTH.upload(decorativeBookshelfBlock, textureMap, BlockStateModelGenerator.modelCollector);
//        Identifier identifier3 = Models.CUSTOM_FENCE_SIDE_EAST.upload(decorativeBookshelfBlock, textureMap, BlockStateModelGenerator.this.modelCollector);
//        Identifier identifier4 = Models.CUSTOM_FENCE_SIDE_SOUTH.upload(decorativeBookshelfBlock, textureMap, BlockStateModelGenerator.this.modelCollector);
//        Identifier identifier5 = Models.CUSTOM_FENCE_SIDE_WEST.upload(decorativeBookshelfBlock, textureMap, BlockStateModelGenerator.this.modelCollector);
        BlockStateModelGenerator.this.blockStateCollector.accept(BlockStateModelGenerator.createCustomFenceBlockState(decorativeBookshelfBlock, identifier, identifier2, identifier3, identifier4, identifier5));
        Identifier identifier6 = Models.CUSTOM_FENCE_INVENTORY.upload(decorativeBookshelfBlock, textureMap, BlockStateModelGenerator.this.modelCollector);
        BlockStateModelGenerator.this.registerParentedItemModel(decorativeBookshelfBlock, identifier6);
        return this;
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

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GEM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GEM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GEM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GEM_BOOTS));

        itemModelGenerator.register(ModItems.SCYTHE, Models.HANDHELD);
    }
}

