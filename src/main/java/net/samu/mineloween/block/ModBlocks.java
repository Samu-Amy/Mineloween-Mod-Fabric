package net.samu.mineloween.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.block.custom.DecorativeBookshelfBlock;
import net.samu.mineloween.block.custom.GemstoneGrinderBlock;
import net.samu.mineloween.block.custom.MalvaCropBlock;
import net.samu.mineloween.world.tree.AshSaplingGenerator;

public class ModBlocks {

    // -------- Blocchi --------
    public static final Block GEM_ORE = registerBlock("gem_ore", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE)));
    public static final Block DEEPSLATE_GEM_ORE = registerBlock("deepslate_gem_ore", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE)));
    public static final Block GEMMED_COBBLESTONE = registerBlock("gemmed_cobblestone", new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
    public static final Block GEMMED_COBBLESTONE_STAIRS = registerBlock("gemmed_cobblestone_stairs", new StairsBlock(ModBlocks.GEMMED_COBBLESTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
    public static final Block GEMMED_COBBLESTONE_SLAB = registerBlock("gemmed_cobblestone_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
    public static final Block GEMMED_COBBLESTONE_WALL = registerBlock("gemmed_cobblestone_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE_WALL)));
    public static final Block GEMMED_COBBLESTONE_FENCE_GATE = registerBlock("gemmed_cobblestone_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));

    public static final Block GEMSTONE_GRINDER = registerBlock("gemstone_grinder", new GemstoneGrinderBlock(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque()));
    public static final Block DECORATIVE_BOOKSHELF = registerBlock("decorative_bookshelf", new DecorativeBookshelfBlock(FabricBlockSettings.copyOf(Blocks.BOOKSHELF)));


    // -------- Trees --------
    public static final Block ASH_LOG = registerBlock("ash_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block ASH_WOOD = registerBlock("ash_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block STRIPPED_ASH_LOG = registerBlock("stripped_ash_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block STRIPPED_ASH_WOOD = registerBlock("stripped_ash_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block ASH_PLANKS = registerBlock("ash_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block ASH_LEAVES = registerBlock("ash_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block ASH_SAPLING = registerBlock("ash_sapling", new SaplingBlock(new AshSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block ASH_WOOD_STAIRS = registerBlock("ash_wood_stairs", new StairsBlock(ModBlocks.ASH_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block ASH_WOOD_SLAB = registerBlock("ash_wood_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block ASH_WOOD_FENCE_GATE = registerBlock("ash_wood_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));


    // -------- Crop --------
    public static final Block MALVA_CROP = registerBlockWithoutBlockItem("malva_crop", new MalvaCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block MALVA_FLOWER = registerBlock("malva_flower", new FlowerBlock(StatusEffects.REGENERATION, 5, FabricBlockSettings.copyOf(Blocks.AZURE_BLUET)));
    public static final Block POTTED_MALVA_FLOWER = registerBlockWithoutBlockItem("potted_malva_flower", new FlowerPotBlock(MALVA_FLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_AZURE_BLUET)));
    public static final Block LAVANDA = registerBlock("lavanda", new FlowerBlock(StatusEffects.RESISTANCE, 5, FabricBlockSettings.copyOf(Blocks.AZURE_BLUET)));
    public static final Block POTTED_LAVANDA = registerBlockWithoutBlockItem("potted_lavanda", new FlowerPotBlock(LAVANDA, FabricBlockSettings.copyOf(Blocks.POTTED_AZURE_BLUET)));
//    public static final Block BELLADONNA_BUSH = registerBlockWithoutBlockItem("belladonna_bush", new SweetBerryBushBlock(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MineloweenMod.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(MineloweenMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(MineloweenMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        MineloweenMod.LOGGER.info("Registering ModBlocks for " + MineloweenMod.MOD_ID);
    }
}
