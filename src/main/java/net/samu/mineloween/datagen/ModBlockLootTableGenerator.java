package net.samu.mineloween.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.samu.mineloween.block.ModBlocks;
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

        addDrop(ModBlocks.DECORATIVE_BOOKSHELF);

        addDrop(ModBlocks.GEM_ORE, oreDrops(ModBlocks.GEM_ORE, ModItems.RAW_GEM));
    }
}
