package net.samu.mineloween.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASH_KEY_1 = registerKey("ash_1");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASH_KEY_2 = registerKey("ash_2");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMNAL_ASH_KEY_1 = registerKey("autumnal_ash_1");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMNAL_ASH_KEY_2 = registerKey("autumnal_ash_2");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEAD_OAK_TREE_KEY_1 = registerKey("dead_oak_tree_1");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEAD_OAK_TREE_KEY_2 = registerKey("dead_oak_tree_2");
//    public static final RegistryKey<ConfiguredFeature<?, ?>> DEAD_OAK_TREE_KEY_3 = registerKey("dead_oak_tree_3");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEAD_DARK_OAK_TREE_KEY_1 = registerKey("dead_tree_1");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEAD_DARK_OAK_TREE_KEY_2 = registerKey("dead_tree_2");
//    public static final RegistryKey<ConfiguredFeature<?, ?>> DEAD_DARK_OAK_TREE_KEY_3 = registerKey("dead_tree_3");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEAD_ASH_TREE_KEY_1 = registerKey("dead_ash_tree_1");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEAD_ASH_TREE_KEY_2 = registerKey("dead_ash_tree_2");
//    public static final RegistryKey<ConfiguredFeature<?, ?>> DEAD_ASH_TREE_KEY_3 = registerKey("dead_ash_tree_3");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GEM_ORE_KEY = registerKey("gem_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LAVANDA_KEY = registerKey("lavanda");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MALVA_FLOWER_KEY = registerKey("malva_flower");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        // ----- ORES -----
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);


        List<OreFeatureConfig.Target> overwolrdGemOres = List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.GEM_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_GEM_ORE.getDefaultState()));

        register(context, GEM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overwolrdGemOres, 6, 0.5f));

        // ----- TREES -----
        register(context, ASH_KEY_1, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ASH_LOG), new ForkingTrunkPlacer(5, 4, 2),
                BlockStateProvider.of(ModBlocks.ASH_LEAVES), new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(2), ConstantIntProvider.create(3), 80),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, ASH_KEY_2, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ASH_LOG), new ForkingTrunkPlacer(4, 3, 2),
                BlockStateProvider.of(ModBlocks.ASH_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(2), 2),
                new TwoLayersFeatureSize(1, 1, 2)).build());

        register(context, AUTUMNAL_ASH_KEY_1, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ASH_LOG), new ForkingTrunkPlacer(5, 4, 2),
                BlockStateProvider.of(ModBlocks.AUTUMNAL_ASH_LEAVES), new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(2), ConstantIntProvider.create(3), 80),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, AUTUMNAL_ASH_KEY_2, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ASH_LOG), new ForkingTrunkPlacer(4, 3, 2),
                BlockStateProvider.of(ModBlocks.AUTUMNAL_ASH_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(2), 2),
                new TwoLayersFeatureSize(1, 1, 2)).build());

        register(context, DEAD_OAK_TREE_KEY_1, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG), new StraightTrunkPlacer(8, 6, 4),
                BlockStateProvider.of(Blocks.OAK_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(1, 1, 2)).build());

        register(context, DEAD_OAK_TREE_KEY_2, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG), new ForkingTrunkPlacer(8, 6, 4),
                BlockStateProvider.of(Blocks.OAK_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(1, 1, 2)).build());

//        register(context, DEAD_OAK_TREE_KEY_3, Feature.TREE, new TreeFeatureConfig.Builder(
//                BlockStateProvider.of(Blocks.OAK_LOG), new BendingTrunkPlacer(8, 6, 4, 5, IntProvider.createValidatingCodec(2, 4)),
//                BlockStateProvider.of(Blocks.OAK_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
//                new TwoLayersFeatureSize(1, 1, 2)).build());

        register(context, DEAD_DARK_OAK_TREE_KEY_1, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.DARK_OAK_LOG), new StraightTrunkPlacer(8, 6, 4),
                BlockStateProvider.of(Blocks.DARK_OAK_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(1, 1, 2)).build());

        register(context, DEAD_DARK_OAK_TREE_KEY_2, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.DARK_OAK_LOG), new ForkingTrunkPlacer(8, 6, 4),
                BlockStateProvider.of(Blocks.DARK_OAK_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(1, 1, 2)).build());

        register(context, DEAD_ASH_TREE_KEY_1, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ASH_LOG), new StraightTrunkPlacer(8, 6 ,4),
                BlockStateProvider.of(ModBlocks.ASH_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(1, 1, 2)).build());

        register(context, DEAD_ASH_TREE_KEY_2, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ASH_LOG), new ForkingTrunkPlacer(8, 6, 4),
                BlockStateProvider.of(ModBlocks.ASH_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(1, 1, 2)).build());

        // ----- FLOWERS -----
        register(context, LAVANDA_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(128, 16, 6, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LAVANDA)))));

        register(context, MALVA_FLOWER_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(4, 2, 1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MALVA_FLOWER)))));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MineloweenMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                  RegistryKey<ConfiguredFeature<?, ?>> key,F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
