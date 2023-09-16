package net.samu.mineloween.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.samu.mineloween.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {


    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        // ----- MINEABLE -----
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(
                ModBlocks.GEM_ORE,
                ModBlocks.DEEPSLATE_GEM_ORE,
                ModBlocks.GEMMED_COBBLESTONE,
                ModBlocks.GEMMED_COBBLESTONE_STAIRS,
                ModBlocks.GEMMED_COBBLESTONE_SLAB,
                ModBlocks.GEMMED_COBBLESTONE_WALL,
                ModBlocks.GEMMED_COBBLESTONE_FENCE_GATE,
                ModBlocks.GEMSTONE_GRINDER
        );

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(
                ModBlocks.ASH_LOG,
                ModBlocks.ASH_WOOD,
                ModBlocks.STRIPPED_ASH_LOG,
                ModBlocks.STRIPPED_ASH_WOOD,
                ModBlocks.ASH_PLANKS,
                ModBlocks.ASH_WOOD_STAIRS,
                ModBlocks.ASH_WOOD_SLAB,
                ModBlocks.ASH_WOOD_FENCE_GATE
        );


        // ----- NEED TOOL -----
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GEM_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_GEM_ORE);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.ASH_WOOD_STAIRS);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "need_tool_level_5")));
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "need_tool_level_6")));


        // ----- BLOCKS TAGS -----
        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.ASH_LOG, ModBlocks.ASH_WOOD, ModBlocks.STRIPPED_ASH_LOG, ModBlocks.STRIPPED_ASH_WOOD);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.ASH_PLANKS);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.GEMMED_COBBLESTONE_STAIRS, ModBlocks.ASH_WOOD_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.GEMMED_COBBLESTONE_SLAB, ModBlocks.ASH_WOOD_SLAB);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.GEMMED_COBBLESTONE_WALL);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.GEMMED_COBBLESTONE_FENCE_GATE, ModBlocks.ASH_WOOD_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.ASH_SAPLING);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(ModBlocks.ASH_LOG, ModBlocks.ASH_WOOD, ModBlocks.STRIPPED_ASH_LOG,
                ModBlocks.STRIPPED_ASH_WOOD, ModBlocks.ASH_WOOD_STAIRS, ModBlocks.ASH_WOOD_SLAB, ModBlocks.ASH_WOOD_FENCE_GATE);
    }
}
