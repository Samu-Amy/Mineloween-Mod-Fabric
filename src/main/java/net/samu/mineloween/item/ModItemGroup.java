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
                        entries.add(ModBlocks.GEMMED_COBBLESTONE);

                        entries.add(ModItems.RAW_GEM);
                        entries.add(ModItems.GEM);
                        entries.add(ModItems.ICON);
                    }).build());

    public static void registerItemGroups() {

    }
}
