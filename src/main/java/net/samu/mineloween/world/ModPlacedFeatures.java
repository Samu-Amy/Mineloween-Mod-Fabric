package net.samu.mineloween.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ASH_1_PLAINS_PLACED_KEY = registerKey("ash_1_plains_placed");
    public static final RegistryKey<PlacedFeature> ASH_1_FOREST_PLACED_KEY = registerKey("ash_1_forest_placed");
    public static final RegistryKey<PlacedFeature> ASH_2_PLAINS_PLACED_KEY = registerKey("ash_2_plains_placed");
    public static final RegistryKey<PlacedFeature> ASH_2_FOREST_PLACED_KEY = registerKey("ash_2_forest_placed");
    public static final RegistryKey<PlacedFeature> GEM_ORE_PLACED_KEY = registerKey("gem_ore_placed");
    public static final RegistryKey<PlacedFeature> LAVANDA_PLACED_KEY = registerKey("lavanda_placed");
    public static final RegistryKey<PlacedFeature> MALVA_FLOWER_PLACED_KEY = registerKey("malva_flower_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        // ----- ORES -----
        register(context, GEM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GEM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(20))));

        // ---- TREES -----
        register(context, ASH_1_PLAINS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ASH_KEY_1),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 1), ModBlocks.ASH_SAPLING)); // 1/extraChance = intero (es. 0.1 va bene, 0.3 no)

        register(context, ASH_1_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ASH_KEY_1),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.ASH_SAPLING));

        register(context, ASH_2_PLAINS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ASH_KEY_2),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 1), ModBlocks.ASH_SAPLING));

        register(context, ASH_2_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ASH_KEY_2),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.ASH_SAPLING));

        // ----- FLOWERS -----
        register(context, LAVANDA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LAVANDA_KEY),
                RarityFilterPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, MALVA_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MALVA_FLOWER_KEY),
                RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MineloweenMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
