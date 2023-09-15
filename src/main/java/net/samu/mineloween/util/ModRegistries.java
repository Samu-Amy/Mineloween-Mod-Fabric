package net.samu.mineloween.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.item.ModItems;
import net.samu.mineloween.villager.ModVillagers;

public class ModRegistries {
    public static void registerModStuff() {
        registerFuels();
        registerModCompostables();
        registerStrippables();
        registerFlammables();
        registerCustomTrades();
    }

    public static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.LEAF, 50);
    }

    private static void registerModCompostables() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MALVA_SEEDS, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MALVA_FLOWERS, 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.LAVANDA, 0.65f);
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.ASH_LOG, ModBlocks.STRIPPED_ASH_LOG);
        StrippableBlockRegistry.register(ModBlocks.ASH_WOOD, ModBlocks.STRIPPED_ASH_WOOD);
    }

    private static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASH_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASH_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ASH_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ASH_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASH_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASH_LEAVES, 30, 60);
    }

    private static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModBlocks.LAVANDA, 3), 10, 4, 0.02f));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.MALVA_FLOWERS, 2), 10, 3, 0.02f));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.MALVA_SEEDS, 3), 8, 6, 0.04f));
        });
    }
}
