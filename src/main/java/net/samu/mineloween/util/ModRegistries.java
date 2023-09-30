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
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.entity.ModEntities;
import net.samu.mineloween.entity.custom.GhostEntity;
import net.samu.mineloween.entity.custom.GhostVillagerEntity;
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

        registry.add(ModItems.LEAVES, 50);
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.OWL, OwlEntity.createOwlAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.GHOST, GhostEntity.createGhostAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.GHOST_VILLAGER, GhostVillagerEntity.createGhostVillagerAttributes());
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
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.AUTUMNAL_ASH_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASH_WOOD_STAIRS, 5, 18);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASH_WOOD_SLAB, 5, 10);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASH_WOOD_FENCE_GATE, 5, 15);
    }

    private static void registerCustomTrades() {
        // ----- GOLD TRADES -----
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_POWDER, 14),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_COIN, 3),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_POWDER, 14),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_COIN, 3),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_POWDER, 14),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_COIN, 3),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_POWDER, 14),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_COIN, 3),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_POWDER, 14),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_COIN, 3),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_POWDER, 14),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_COIN, 3),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_POWDER, 14),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_COIN, 3),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_POWDER, 14),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_COIN, 3),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_POWDER, 14),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_COIN, 3),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_POWDER, 14),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_COIN, 3),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_POWDER, 14),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_COIN, 3),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_POWDER, 14),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_COIN, 3),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_POWDER, 14),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_COIN, 3),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//
//        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_POWDER, 14),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });
//        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 1, factories -> {
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.GOLD_COIN, 3),
//                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
//        });

        // ----- HERBORIST -----
        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 1, factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(ModBlocks.LAVANDA, 3), 10, 2, 0.02f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(ModBlocks.LAVANDA, 3), 10, 2, 0.02f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.MALVA_FLOWERS, 2), 10, 2, 0.02f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(ModItems.MALVA_FLOWERS, 2), 10, 2, 0.02f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.RESIN, 3), 8, 3, 0.04f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 6),
                    new ItemStack(ModItems.RESIN, 3), 8, 3, 0.04f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.MALVA_SEEDS, 3), 8, 4, 0.06f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 6),
                    new ItemStack(ModItems.MALVA_SEEDS, 3), 8, 4, 0.06f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.STRING, 8), 8, 4, 0.04f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.STRING, 8), 8, 4, 0.04f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.FABRIC, 4), 8, 4, 0.04f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(ModItems.FABRIC, 4), 8, 4, 0.04f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 4, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.MEDICINAL_PASTE, 2), 6, 4, 0.04f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 4, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 6),
                    new ItemStack(ModItems.MEDICINAL_PASTE, 2), 6, 4, 0.04f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 4, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.HEALING_MEDICINAL_PASTE, 2), 6, 4, 0.04f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 4, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 12),
                    new ItemStack(ModItems.HEALING_MEDICINAL_PASTE, 2), 6, 4, 0.04f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 5, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.BANDAGE, 1), 5, 4, 0.04f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 5, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 15),
                    new ItemStack(ModItems.BANDAGE, 1), 5, 4, 0.04f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 5, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 7),
                    new ItemStack(ModItems.HEALING_BANDAGE, 1), 5, 4, 0.04f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 5, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 21),
                    new ItemStack(ModItems.HEALING_BANDAGE, 1), 5, 4, 0.04f));
        });

        // ----- GEM WORKER -----
        TradeOfferHelper.registerVillagerOffers(ModVillagers.GEM_WORKER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 14),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.GEM_WORKER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(Items.EMERALD, 1), 50, 1, 0.01f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.GEM_WORKER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_POWDER, 16),
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.GOLD_COIN, 4), 20, 2, 0.02f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.GEM_WORKER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.RAW_GEM, 2),
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.GEM_POWDER, 4), 10, 3, 0.02f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.GEM_WORKER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.RAW_GEM, 2),
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(ModItems.GEM_POWDER, 4), 10, 3, 0.02f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.GEM_WORKER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.GOLD_INGOT, 2),
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.GOLD_POWDER, 4), 10, 3, 0.02f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.GEM_WORKER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.GOLD_INGOT, 2),
                    new ItemStack(ModItems.GOLD_COIN, 3),
                    new ItemStack(ModItems.GOLD_POWDER, 4), 10, 3, 0.02f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.GEM_WORKER, 3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.GOLD_COIN, 24),
                    new ItemStack(ModBlocks.GEMSTONE_GRINDER, 1), 2, 8, 0.1f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.GEM_WORKER, 3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModBlocks.GEMSTONE_GRINDER, 1), 2, 8, 0.1f));
        });
    }
}
