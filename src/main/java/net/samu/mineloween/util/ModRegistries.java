package net.samu.mineloween.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
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
import net.samu.mineloween.entity.ModEntities;
import net.samu.mineloween.entity.custom.OwlEntity;
import net.samu.mineloween.item.ModItems;
import net.samu.mineloween.villager.ModVillagers;

public class ModRegistries {
    public static void registerModStuff() {
        registerFuels();
        registerModCompostables();
        registerStrippables();
        registerFlammables();
        registerCustomTrades();
        registerAttributes();
    }

    public static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.LEAF, 50);
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.OWL, OwlEntity.createOwlAttributes());
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
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASH_WOOD_STAIRS, 5, 18);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASH_WOOD_SLAB, 5, 10);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASH_WOOD_FENCE_GATE, 5, 15);
    }

    private static void registerCustomTrades() {
        // ----- GOLD TRADES -----
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 14),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 14),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 14),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 14),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 14),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 14),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 14),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 14),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 14),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 14),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 14),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 14),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 14),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 14),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        // ----- HERBORIST -----
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
