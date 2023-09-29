package net.samu.mineloween.world.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.samu.mineloween.world.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class AshSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        // TODO: aggiungi Autumn Ash Sapling
        if (random.nextBoolean()) {
            return ModConfiguredFeatures.ASH_KEY_1;
        } else {
            return ModConfiguredFeatures.ASH_KEY_2;
        }
    }
}
