package net.samu.mineloween.compat;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.block.ModBlocks;

import java.util.LinkedList;
import java.util.List;

public class GemstoneGrinderCategory implements DisplayCategory<BasicDisplay> {
    public static final Identifier TEXTURE = new Identifier(MineloweenMod.MOD_ID, "textures/gui/gemstone_grinder_gui.png");
    public static final CategoryIdentifier<GemstoneGrinderDisplay> GEMSTONE_GRINDER = CategoryIdentifier.of(MineloweenMod.MOD_ID, "gemstone_grinder");
    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return GEMSTONE_GRINDER;
    }

    @Override
    public Text getTitle() {
        return Text.literal("Gemstone Grinder");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.GEMSTONE_GRINDER.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 35);
        List<Widget> widgets = new LinkedList<>();

        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 175, 82)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 44, startPoint.y + 35)).entries(display.getInputEntries().get(0)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 116, startPoint.y + 35)).markOutput().entries(display.getOutputEntries().get(0)));

        return DisplayCategory.super.setupDisplay(display, bounds);
    }

    @Override
    public int getDisplayHeight() {
        return 90;
    }
}
