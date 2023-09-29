package net.samu.mineloween.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.samu.mineloween.world.biome.ModBiomes;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);
        MaterialRules.MaterialRule coarseDirtSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, COARSE_DIRT), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.ASH_FOREST),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)),

                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.AUTUMN_FOREST),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)),

                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.DEAD_FOREST),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, coarseDirtSurface)),


                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)))
                ));
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}