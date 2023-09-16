package net.samu.mineloween.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.block.custom.MalvaCropBlock;
import net.samu.mineloween.item.ModItems;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.GEMMED_COBBLESTONE);
        addDrop(ModBlocks.GEMMED_COBBLESTONE_STAIRS);
        addDrop(ModBlocks.GEMMED_COBBLESTONE_SLAB, slabDrops(ModBlocks.GEMMED_COBBLESTONE_SLAB));
        addDrop(ModBlocks.GEMMED_COBBLESTONE_WALL);
        addDrop(ModBlocks.GEMMED_COBBLESTONE_FENCE_GATE);
        addDrop(ModBlocks.ASH_LOG);
        addDrop(ModBlocks.ASH_WOOD);
        addDrop(ModBlocks.STRIPPED_ASH_LOG);
        addDrop(ModBlocks.STRIPPED_ASH_WOOD);
        addDrop(ModBlocks.ASH_PLANKS);
        addDrop(ModBlocks.ASH_WOOD_STAIRS);
        addDrop(ModBlocks.ASH_WOOD_SLAB);
        addDrop(ModBlocks.ASH_WOOD_FENCE_GATE);
        addDrop(ModBlocks.ASH_SAPLING);
        addDrop(ModBlocks.ASH_LEAVES, leavesDrops(ModBlocks.ASH_LEAVES, ModBlocks.ASH_SAPLING, 0.05f));

        addDrop(ModBlocks.DECORATIVE_BOOKSHELF);

        addDrop(ModBlocks.GEM_ORE, oreDrops(ModBlocks.GEM_ORE, ModItems.RAW_GEM));
        addDrop(ModBlocks.DEEPSLATE_GEM_ORE, oreDrops(ModBlocks.DEEPSLATE_GEM_ORE, ModItems.RAW_GEM));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.MALVA_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(MalvaCropBlock.AGE, MalvaCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.MALVA_CROP, this.cropDrops(ModBlocks.MALVA_CROP, ModItems.MALVA_FLOWERS, ModItems.MALVA_SEEDS, builder2));
    }
}
