package net.samu.mineloween.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASH_KEY_1 = registerKey("ash_1");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASH_KEY_2 = registerKey("ash_2");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GEM_ORE_KEY = registerKey("gem_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
//        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overwolrdGemOres = List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.GEM_ORE.getDefaultState()));

//        List<OreFeatureConfig.Target> overwolrdGemOres = List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.GEM_ORE.getDefaultState()),
//                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.GEM_ORE.getDefaultState())); TODO: fai versione deepslate e usa questa lista

        register(context, ASH_KEY_1, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ASH_LOG), new ForkingTrunkPlacer(5, 5, 3),
                BlockStateProvider.of(ModBlocks.ASH_LEAVES), new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(2), ConstantIntProvider.create(3), 80),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, ASH_KEY_2, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ASH_LOG), new ForkingTrunkPlacer(5, 5, 3),
                BlockStateProvider.of(ModBlocks.ASH_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(2), 2),
                new TwoLayersFeatureSize(1, 1, 2)).build());

        register(context, GEM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overwolrdGemOres, 6, 0.5f));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MineloweenMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                  RegistryKey<ConfiguredFeature<?, ?>> key,F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
