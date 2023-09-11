package net.samu.mineloween.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.recipe.GemstoneGrinderRecipe;
import net.samu.mineloween.screen.GemstoneGrinderScreen;

public class MineloweenModREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new GemstoneGrinderCategory());

        registry.addWorkstations(GemstoneGrinderCategory.GEMSTONE_GRINDER, EntryStacks.of(ModBlocks.GEMSTONE_GRINDER));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(GemstoneGrinderRecipe.class, GemstoneGrinderRecipe.Type.INSTANCE, GemstoneGrinderDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), GemstoneGrinderScreen.class, GemstoneGrinderCategory.GEMSTONE_GRINDER);
    }
}
