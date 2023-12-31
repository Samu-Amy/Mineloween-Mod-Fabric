package net.samu.mineloween.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.samu.mineloween.world.ModPlacedFeatures;
import net.samu.mineloween.world.biome.ModBiomes;

public class ModTreeGeneration {
    public static void generateTrees() {
        // ----- VANILLA BIOMES -----
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WOODED_BADLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ASH_1_PLAINS_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ASH_1_FOREST_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WOODED_BADLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ASH_2_PLAINS_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ASH_2_FOREST_PLACED_KEY);

        // ----- ASH FOREST -----
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.ASH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ASH_1_ASH_FOREST_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.ASH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ASH_2_ASH_FOREST_PLACED_KEY);

        // ----- AUTUMN FOREST -----
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.AUTUMN_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AUTUMNAL_ASH_1_AUTUMNAL_FOREST_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.AUTUMN_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AUTUMNAL_ASH_2_AUTUMNAL_FOREST_PLACED_KEY);

        // ----- DEAD FOREST -----
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.DEAD_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DEAD_OAK_TREE_1_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.DEAD_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DEAD_OAK_TREE_2_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.DEAD_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DEAD_DARK_OAK_TREE_1_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.DEAD_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DEAD_DARK_OAK_TREE_2_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.DEAD_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DEAD_ASH_TREE_1_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.DEAD_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DEAD_ASH_TREE_2_PLACED_KEY);
    }
}
