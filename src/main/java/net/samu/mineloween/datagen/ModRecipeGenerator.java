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
import net.samu.mineloween.datagen.recipe.GemstoneGrinderRecipeBuilder;
import net.samu.mineloween.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        // -------- Items --------
        offerSmelting(exporter, List.of(ModBlocks.GEM_ORE), RecipeCategory.MISC, ModItems.RAW_GEM, 2f, 200, "gem");
        offerBlasting(exporter, List.of(ModBlocks.GEM_ORE), RecipeCategory.MISC, ModItems.RAW_GEM, 2f, 100, "gem");

        offerSmelting(exporter, List.of(ModBlocks.DEEPSLATE_GEM_ORE), RecipeCategory.MISC, ModItems.RAW_GEM, 2.5f, 200, "gem");
        offerBlasting(exporter, List.of(ModBlocks.DEEPSLATE_GEM_ORE), RecipeCategory.MISC, ModItems.RAW_GEM, 2.5f, 100, "gem");

        // TODO: aggiungi polvere di altri minerali
        new GemstoneGrinderRecipeBuilder(ModItems.RAW_GEM, ModItems.GEM_POWDER, 2)
                .criterion(hasItem(ModItems.RAW_GEM), conditionsFromItem(ModItems.RAW_GEM))
                .offerTo(exporter);

        new GemstoneGrinderRecipeBuilder(Items.GOLD_INGOT, ModItems.GOLD_POWDER, 2)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_CRYSTALS, 6)
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOLD_COIN)
                .pattern("GG")
                .pattern("GG")
                .input('G', ModItems.GOLD_POWDER)
                .criterion(hasItem(ModItems.GOLD_POWDER), conditionsFromItem(ModItems.GOLD_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GOLD_COIN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GOLD_NUGGET, 9)
                .pattern("GG")
                .input('G', ModItems.GOLD_POWDER)
                .criterion(hasItem(ModItems.GOLD_POWDER), conditionsFromItem(ModItems.GOLD_POWDER))
                .offerTo(exporter, new Identifier("gold_nugget_from_gold_powder"));


        // -------- Herborism --------
        offerSmelting(exporter, List.of(ModBlocks.ASH_LEAVES), RecipeCategory.MISC, ModItems.DRIED_ASH_LEAVES, 0.2f, 50, "ash");

        //TODO: polvere di Malva con fiori essiccati (?) e messi in mortaio e pestello

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MALVA_POWDER)
                .input(ModItems.MALVA_FLOWERS)
                .criterion(hasItem(ModItems.MALVA_FLOWERS), conditionsFromItem(ModItems.MALVA_FLOWERS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MALVA_POWDER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FABRIC, 4)
                .pattern("SSS")
                .pattern("SSS")
                .input('S', Items.STRING)
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FABRIC)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MEDICINAL_PASTE, 2)
                .pattern("MLM")
                .pattern("DRD")
                .pattern("MLM")
                .input('L', ModBlocks.LAVANDA)
                .input('M', ModItems.MALVA_FLOWERS)
                .input('D', ModItems.DRIED_ASH_LEAVES)
                .input('R', ModItems.RESIN)
                .criterion(hasItem(ModBlocks.LAVANDA), conditionsFromItem(ModBlocks.LAVANDA))
                .criterion(hasItem(ModItems.MALVA_FLOWERS), conditionsFromItem(ModItems.MALVA_FLOWERS))
                .criterion(hasItem(ModItems.DRIED_ASH_LEAVES), conditionsFromItem(ModItems.DRIED_ASH_LEAVES))
                .criterion(hasItem(ModItems.RESIN), conditionsFromItem(ModItems.RESIN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MEDICINAL_PASTE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HEALING_MEDICINAL_PASTE, 2)
                .pattern("MLM")
                .pattern("DRD")
                .pattern("MLM")
                .input('L', ModBlocks.LAVANDA)
                .input('M', ModItems.MALVA_POWDER)
                .input('D', ModItems.DRIED_ASH_LEAVES)
                .input('R', ModItems.RESIN)
                .criterion(hasItem(ModBlocks.LAVANDA), conditionsFromItem(ModBlocks.LAVANDA))
                .criterion(hasItem(ModItems.MALVA_POWDER), conditionsFromItem(ModItems.MALVA_POWDER))
                .criterion(hasItem(ModItems.DRIED_ASH_LEAVES), conditionsFromItem(ModItems.DRIED_ASH_LEAVES))
                .criterion(hasItem(ModItems.RESIN), conditionsFromItem(ModItems.RESIN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HEALING_MEDICINAL_PASTE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BANDAGE, 2)
                .pattern("MMM")
                .pattern("FFF")
                .input('M', ModItems.MEDICINAL_PASTE)
                .input('F', ModItems.FABRIC)
                .criterion(hasItem(ModItems.MEDICINAL_PASTE), conditionsFromItem(ModItems.MEDICINAL_PASTE))
                .criterion(hasItem(ModItems.FABRIC), conditionsFromItem(ModItems.FABRIC))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BANDAGE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HEALING_BANDAGE, 2) //TODO: sostituisci Ash leaves con Ash leaves essiccate
                .pattern("HHH")
                .pattern("FFF")
                .input('H', ModItems.HEALING_MEDICINAL_PASTE)
                .input('F', ModItems.FABRIC)
                .criterion(hasItem(ModItems.HEALING_MEDICINAL_PASTE), conditionsFromItem(ModItems.HEALING_MEDICINAL_PASTE))
                .criterion(hasItem(ModItems.FABRIC), conditionsFromItem(ModItems.FABRIC))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HEALING_BANDAGE)));


        // -------- Blocks --------
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GEMMED_COBBLESTONE, 4)
                .pattern(" C ")
                .pattern("CGC")
                .pattern(" C ")
                .input('G', ModItems.GEM_CRYSTALS)
                .input('C', Blocks.COBBLESTONE)
                .criterion(hasItem(ModItems.GEM_CRYSTALS), conditionsFromItem(ModItems.GEM_CRYSTALS))
                .criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GEMMED_COBBLESTONE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GEMMED_COBBLESTONE_STAIRS, 4)
                .pattern("C  ")
                .pattern("CC ")
                .pattern("CCC")
                .input('C', ModBlocks.GEMMED_COBBLESTONE)
                .criterion(hasItem(ModBlocks.GEMMED_COBBLESTONE), conditionsFromItem(ModBlocks.GEMMED_COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GEMMED_COBBLESTONE_STAIRS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GEMMED_COBBLESTONE_SLAB, 6)
                .pattern("CCC")
                .input('C', ModBlocks.GEMMED_COBBLESTONE)
                .criterion(hasItem(ModBlocks.GEMMED_COBBLESTONE), conditionsFromItem(ModBlocks.GEMMED_COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GEMMED_COBBLESTONE_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GEMMED_COBBLESTONE_WALL, 6)
                .pattern(" G ")
                .pattern("CCC")
                .pattern("CCC")
                .input('G', ModItems.GEM_CRYSTALS)
                .input('C', Blocks.COBBLESTONE)
                .criterion(hasItem(ModItems.GEM_CRYSTALS), conditionsFromItem(ModItems.GEM_CRYSTALS))
                .criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GEMMED_COBBLESTONE_WALL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GEMMED_COBBLESTONE_FENCE_GATE)
                .pattern("WCW")
                .input('C', ModBlocks.GEMMED_COBBLESTONE)
                .input('W', ModBlocks.GEMMED_COBBLESTONE_WALL)
                .criterion(hasItem(ModBlocks.GEMMED_COBBLESTONE), conditionsFromItem(ModBlocks.GEMMED_COBBLESTONE))
                .criterion(hasItem(ModBlocks.GEMMED_COBBLESTONE_WALL), conditionsFromItem(ModBlocks.GEMMED_COBBLESTONE_WALL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GEMMED_COBBLESTONE_FENCE_GATE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ASH_PLANKS, 4)
                .input(ModBlocks.ASH_LOG).criterion(hasItem(ModBlocks.ASH_LOG), conditionsFromItem(ModBlocks.ASH_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ASH_PLANKS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ASH_WOOD_STAIRS, 4)
                .pattern("P  ")
                .pattern("PP ")
                .pattern("PPP")
                .input('P', ModBlocks.ASH_PLANKS)
                .criterion(hasItem(ModBlocks.ASH_PLANKS), conditionsFromItem(ModBlocks.ASH_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ASH_WOOD_STAIRS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ASH_WOOD_SLAB, 6)
                .pattern("PPP")
                .input('P', ModBlocks.ASH_PLANKS)
                .criterion(hasItem(ModBlocks.ASH_PLANKS), conditionsFromItem(ModBlocks.ASH_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ASH_WOOD_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ASH_WOOD_FENCE_GATE)
                .pattern("SPS")
                .pattern("SPS")
                .input('P', ModBlocks.ASH_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.ASH_PLANKS), conditionsFromItem(ModBlocks.ASH_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ASH_WOOD_FENCE_GATE)));


        // -------- Tools --------
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_SWORD)
                .pattern(" G ")
                .pattern(" G ")
                .pattern(" S ")
                .input('G', ModItems.GEM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_PICKAXE)
                .pattern("GGG")
                .pattern(" S ")
                .pattern(" S ")
                .input('G', ModItems.GEM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_AXE)
                .pattern("GG ")
                .pattern("GS ")
                .pattern(" S ")
                .input('G', ModItems.GEM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_SHOVEL)
                .pattern(" G ")
                .pattern(" S ")
                .pattern(" S ")
                .input('G', ModItems.GEM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_HOE)
                .pattern("GG ")
                .pattern(" S ")
                .pattern(" S ")
                .input('G', ModItems.GEM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_HOE)));


        // -------- Armor --------
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_HELMET)
                .pattern("GGG")
                .pattern("G G")
                .input('G', ModItems.GEM)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_CHESTPLATE)
                .pattern("G G")
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModItems.GEM)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_LEGGINGS)
                .pattern("GGG")
                .pattern("G G")
                .pattern("G G")
                .input('G', ModItems.GEM)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_BOOTS)
                .pattern("G G")
                .pattern("G G")
                .input('G', ModItems.GEM)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_BOOTS)));
    }
}
