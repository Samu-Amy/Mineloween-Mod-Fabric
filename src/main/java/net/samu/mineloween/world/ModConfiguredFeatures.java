package net.samu.mineloween.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.block.ModBlocks;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASH_KEY_1 = registerKey("ash_1");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASH_KEY_2 = registerKey("ash_2");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, ASH_KEY_1, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ASH_LOG), new ForkingTrunkPlacer(5, 5, 3),
                BlockStateProvider.of(ModBlocks.ASH_LEAVES), new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(2), ConstantIntProvider.create(3), 80),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, ASH_KEY_2, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ASH_LOG), new ForkingTrunkPlacer(5, 5, 3),
                BlockStateProvider.of(ModBlocks.ASH_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 3),
                new TwoLayersFeatureSize(1, 1, 2)).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MineloweenMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                  RegistryKey<ConfiguredFeature<?, ?>> key,F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
