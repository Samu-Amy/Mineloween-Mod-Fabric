package net.samu.mineloween.entity.layer;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;

public class ModModelLayers {
    public static final EntityModelLayer OWL = new EntityModelLayer(new Identifier(MineloweenMod.MOD_ID, "owl"), "main");
    public static final EntityModelLayer GHOST = new EntityModelLayer(new Identifier(MineloweenMod.MOD_ID, "ghost"), "main");
    public static final EntityModelLayer GHOST_VILLAGER = new EntityModelLayer(new Identifier(MineloweenMod.MOD_ID, "ghost_villager"), "main");
}
