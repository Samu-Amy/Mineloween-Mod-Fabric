package net.samu.mineloween.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).add(ModItems.GEM_HELMET, ModItems.GEM_CHESTPLATE, ModItems.GEM_LEGGINGS, ModItems.GEM_BOOTS);

        // Logs and Planks Furnace Burnable and Wood crafting
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).add(ModBlocks.ASH_LOG.asItem(), ModBlocks.ASH_WOOD.asItem(), ModBlocks.STRIPPED_ASH_LOG.asItem(), ModBlocks.STRIPPED_ASH_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.PLANKS).add(ModBlocks.ASH_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.STAIRS).add(ModBlocks.ASH_WOOD_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.SLABS).add(ModBlocks.ASH_WOOD_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(ModBlocks.ASH_WOOD_FENCE_GATE.asItem());
    }
}
