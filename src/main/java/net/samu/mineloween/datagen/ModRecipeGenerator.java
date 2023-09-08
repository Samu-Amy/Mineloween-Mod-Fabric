package net.samu.mineloween.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(ModBlocks.GEM_ORE), RecipeCategory.MISC, ModItems.RAW_GEM, 2f, 200, "gem");
        offerBlasting(exporter, List.of(ModBlocks.GEM_ORE), RecipeCategory.MISC, ModItems.RAW_GEM, 2f, 100, "gem");

        // TODO: metti questa ricetta in un blocco dedicato a macinare gli ore (grinder)
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_POWDER, 2)
                .input(ModItems.RAW_GEM)
                .criterion(hasItem(ModItems.RAW_GEM), conditionsFromItem(ModItems.RAW_GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_POWDER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_CRYSTALS, 3)
                .pattern(" P ")
                .pattern("PSP")
                .pattern(" P ")
                .input('P', ModItems.GEM_POWDER)
                .input('S', Items.AMETHYST_SHARD)
                .criterion(hasItem(ModItems.GEM_POWDER), conditionsFromItem(ModItems.GEM_POWDER))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_CRYSTALS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM)
                .pattern("PPP")
                .pattern("PSP")
                .pattern("PPP")
                .input('P', ModItems.GEM_POWDER)
                .input('S', Items.AMETHYST_SHARD)
                .criterion(hasItem(ModItems.GEM_POWDER), conditionsFromItem(ModItems.GEM_POWDER))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GEMMED_COBBLESTONE, 8)
                .pattern("CCC")
                .pattern("CGC")
                .pattern("CCC")
                .input('G', ModItems.GEM_CRYSTALS)
                .input('C', Blocks.COBBLESTONE)
                .criterion(hasItem(ModItems.GEM_CRYSTALS), conditionsFromItem(ModItems.GEM_CRYSTALS))
                .criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GEMMED_COBBLESTONE)));
    }
}
