package net.samu.mineloween.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.entity.ModEntities;
import net.samu.mineloween.item.custom.BandageItem;
import net.samu.mineloween.item.custom.HealingBandageItem;
import net.samu.mineloween.item.custom.ModScytheItem;

public class ModItems {

    public static final Item ICON = registerItem("icon", new Item(new FabricItemSettings()));


    // -------- Minerali e derivati --------
    public static final Item GOLD_POWDER = registerItem("gold_powder", new Item(new FabricItemSettings()));
    public static final Item GOLD_COIN = registerItem("gold_coin", new Item(new FabricItemSettings()));
    public static final Item RAW_GEM = registerItem("raw_gem", new Item(new FabricItemSettings()));
    public static final Item GEM_POWDER = registerItem("gem_powder", new Item(new FabricItemSettings()));
    public static final Item GEM = registerItem("gem", new Item(new FabricItemSettings()));
    public static final Item GEM_CRYSTALS = registerItem("gem_crystals", new Item(new FabricItemSettings()));
    public static final Item DARK_INGOT = registerItem("dark_ingot", new Item(new FabricItemSettings()));


    // -------- Tools --------
    public static final Item GEM_SWORD = registerItem("gem_sword", new SwordItem(ModToolMaterial.GEM, 7, -2.4f, new FabricItemSettings()));
    public static final Item GEM_PICKAXE = registerItem("gem_pickaxe", new PickaxeItem(ModToolMaterial.GEM, -1, -2.8f, new FabricItemSettings()));
    public static final Item GEM_AXE = registerItem("gem_axe", new AxeItem(ModToolMaterial.GEM, 9, -3f, new FabricItemSettings()));
    public static final Item GEM_SHOVEL = registerItem("gem_shovel", new ShovelItem(ModToolMaterial.GEM, 0, -3f, new FabricItemSettings()));
    public static final Item GEM_HOE = registerItem("gem_hoe", new HoeItem(ModToolMaterial.GEM, -6, 0f, new FabricItemSettings()));

    //TODO: fai versione magica dei tool di gemma (tier magic_gem o dark (più alto del tier gemma, per poter rompere determinati blocchi) e con stessi valori di quelli di gemma, ma con proprietà speciali


    // -------- Armor --------
    public static final Item GEM_HELMET = registerItem("gem_helmet", new ArmorItem(ModArmorMaterials.GEM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GEM_CHESTPLATE = registerItem("gem_chestplate", new ArmorItem(ModArmorMaterials.GEM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GEM_LEGGINGS = registerItem("gem_leggings", new ArmorItem(ModArmorMaterials.GEM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item GEM_BOOTS = registerItem("gem_boots", new ArmorItem(ModArmorMaterials.GEM, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    // -------- Weapons --------
    public static final Item SCYTHE = registerItem("scythe", new ModScytheItem(ModToolMaterial.DARK, 11, -3f, new FabricItemSettings(), false));
    public static final Item DARK_SCYTHE = registerItem("dark_scythe", new ModScytheItem(ModToolMaterial.DARK, 15, -2.8f, new FabricItemSettings(), true));


    // -------- Food --------
    public static final Item CHOCOLATE = registerItem("chocolate", new Item(new FabricItemSettings().food(ModFoodComponents.CHOCOLATE)));


    // -------- Nature --------
    public static final Item LEAVES = registerItem("leaves", new Item(new FabricItemSettings()));
    public static final Item RESIN = registerItem("resin", new Item(new FabricItemSettings()));
    public static final Item MALVA_SEEDS = registerItem("malva_seeds", new AliasedBlockItem(ModBlocks.MALVA_CROP, new FabricItemSettings()));
    public static final Item MALVA_FLOWERS = registerItem("malva_flowers", new Item(new FabricItemSettings()));


    // -------- HERBORISM --------
    public static final Item DRIED_ASH_LEAVES = registerItem("dried_ash_leaves", new Item(new FabricItemSettings()));
    public static final Item MALVA_POWDER = registerItem("malva_powder", new Item(new FabricItemSettings()));
    public static final Item MEDICINAL_PASTE = registerItem("medicinal_paste", new Item(new FabricItemSettings()));
    public static final Item HEALING_MEDICINAL_PASTE = registerItem("healing_medicinal_paste", new Item(new FabricItemSettings()));


    // -------- Items --------
    public static final Item FABRIC = registerItem("fabric", new Item(new FabricItemSettings()));
    public static final Item BANDAGE = registerItem("bandage", new BandageItem(new FabricItemSettings().maxCount(16).maxDamage(1)));
    public static final Item HEALING_BANDAGE = registerItem("healing_bandage", new HealingBandageItem(new FabricItemSettings().maxCount(16).maxDamage(1)));


    // -------- Mobs --------
    public static final Item OWL_SPAWN_EGG = registerItem("owl_spawn_egg", new SpawnEggItem(ModEntities.OWL, 0xa4744c, 0x774d33, new FabricItemSettings()));
    public static final Item GHOST_SPAWN_EGG = registerItem("ghost_spawn_egg", new SpawnEggItem(ModEntities.GHOST, 0xf2f2f2, 0xffffff, new FabricItemSettings()));
    public static final Item GHOST_VILLAGER_SPAWN_EGG = registerItem("ghost_villager_spawn_egg", new SpawnEggItem(ModEntities.GHOST_VILLAGER, 0x7ad2d1, 0x1b514f, new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MineloweenMod.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
    }

    public static void registerModItems() {
        MineloweenMod.LOGGER.info("Registering Mod Items for " + MineloweenMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
