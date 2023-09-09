package net.samu.mineloween.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.ComposterBlock;
import net.samu.mineloween.item.ModItems;

public class ModRegistries {
    public static void registerModStuff() {
        registerFuels();
        registerModCompostables();
    }

    public static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.LEAF, 50);
    }

    private static void registerModCompostables() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MALVA_FLOWERS, 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MALVA_SEEDS, 0.3f);
    }
}
