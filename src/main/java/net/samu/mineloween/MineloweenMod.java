package net.samu.mineloween;

import net.fabricmc.api.ModInitializer;

import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.block.entity.ModBlockEntities;
import net.samu.mineloween.entity.ModEntities;
import net.samu.mineloween.item.ModItemGroup;
import net.samu.mineloween.item.ModItems;
import net.samu.mineloween.particle.ModParticles;
import net.samu.mineloween.recipe.ModRecipes;
import net.samu.mineloween.screen.ModScreenHandlers;
import net.samu.mineloween.util.ModRegistries;
import net.samu.mineloween.villager.ModVillagers;
import net.samu.mineloween.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MineloweenMod implements ModInitializer {
	public static final String MOD_ID = "mineloween";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuff();
		ModParticles.registerParticles();

		ModVillagers.registerVillagers();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandler();

		ModRecipes.registerRecipes();
		ModWorldGeneration.generateModWorldGeneration();

		ModEntities.registerModEntities();
	}
}