package net.samu.mineloween.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.block.ModBlocks;

public class ModItemGroup {
    public static final ItemGroup MINELOWEEN_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(MineloweenMod.MOD_ID, "mineloween_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mineloween_group")).icon(() -> new ItemStack(ModItems.ICON))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ASH_LOG);
                        entries.add(ModBlocks.ASH_WOOD);
                        entries.add(ModBlocks.STRIPPED_ASH_LOG);
                        entries.add(ModBlocks.STRIPPED_ASH_WOOD);
                        entries.add(ModBlocks.ASH_PLANKS);
                        entries.add(ModBlocks.ASH_WOOD_STAIRS);
                        entries.add(ModBlocks.ASH_WOOD_SLAB);
                        entries.add(ModBlocks.ASH_WOOD_FENCE_GATE);
                        entries.add(ModBlocks.ASH_LEAVES);
                        entries.add(ModBlocks.AUTUMNAL_ASH_LEAVES);
                        entries.add(ModBlocks.ASH_SAPLING);

                        entries.add(ModBlocks.GEM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_GEM_ORE);
                        entries.add(ModBlocks.GEMMED_COBBLESTONE);
                        entries.add(ModBlocks.GEMMED_COBBLESTONE_STAIRS);
                        entries.add(ModBlocks.GEMMED_COBBLESTONE_SLAB);
                        entries.add(ModBlocks.GEMMED_COBBLESTONE_WALL);
                        entries.add(ModBlocks.GEMMED_COBBLESTONE_FENCE_GATE);

                        entries.add(ModBlocks.GEMSTONE_GRINDER);
//                        entries.add(ModBlocks.DECORATIVE_BOOKSHELF);

                        entries.add(ModItems.GOLD_POWDER);
                        entries.add(ModItems.GOLD_COIN);
                        entries.add(ModItems.RAW_GEM);
                        entries.add(ModItems.GEM_POWDER);
                        entries.add(ModItems.GEM_CRYSTALS);
                        entries.add(ModItems.GEM);
                        entries.add(ModItems.DARK_INGOT);

                        entries.add(ModItems.GEM_SWORD);
                        entries.add(ModItems.GEM_PICKAXE);
                        entries.add(ModItems.GEM_AXE);
                        entries.add(ModItems.GEM_SHOVEL);
                        entries.add(ModItems.GEM_HOE);

                        entries.add(ModItems.GEM_HELMET);
                        entries.add(ModItems.GEM_CHESTPLATE);
                        entries.add(ModItems.GEM_LEGGINGS);
                        entries.add(ModItems.GEM_BOOTS);

                        entries.add(ModItems.SCYTHE);
                        entries.add(ModItems.DARK_SCYTHE);

                        entries.add(ModItems.CHOCOLATE);

                        entries.add(ModItems.LEAVES);
                        entries.add(ModItems.RESIN);
                        entries.add(ModItems.MALVA_SEEDS);
                        entries.add(ModItems.MALVA_FLOWERS);
                        entries.add(ModBlocks.LAVANDA);

                        entries.add(ModItems.DRIED_ASH_LEAVES);
                        entries.add(ModItems.MALVA_POWDER);
                        entries.add(ModItems.MEDICINAL_PASTE);
                        entries.add(ModItems.HEALING_MEDICINAL_PASTE);

                        entries.add(ModItems.FABRIC);
                        entries.add(ModItems.BANDAGE);
                        entries.add(ModItems.HEALING_BANDAGE);

                        entries.add(ModItems.OWL_SPAWN_EGG);
                        entries.add(ModItems.GHOST_SPAWN_EGG);
                        entries.add(ModItems.GHOST_VILLAGER_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups() {

    }
}
