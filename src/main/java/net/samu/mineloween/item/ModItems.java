package net.samu.mineloween.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.block.ModBlocks;

public class ModItems {

    public static final Item ICON = registerItem("icon", new Item(new FabricItemSettings()));

    public static final Item RAW_GEM = registerItem("raw_gem", new Item(new FabricItemSettings()));
    public static final Item GEM_POWDER = registerItem("gem_powder", new Item(new FabricItemSettings()));
    public static final Item GEM = registerItem("gem", new Item(new FabricItemSettings()));
    public static final Item GEM_CRYSTALS = registerItem("gem_crystals", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MineloweenMod.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        entries.add(GEM);
        entries.add(RAW_GEM);
    }

    public static void registerModItems() {
        MineloweenMod.LOGGER.info("Registering Mod Items for " + MineloweenMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
