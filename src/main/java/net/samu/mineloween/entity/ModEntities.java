package net.samu.mineloween.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.entity.custom.OwlEntity;

public class ModEntities {
    public static final EntityType<OwlEntity> OWL = Registry.register(Registries.ENTITY_TYPE, new Identifier(MineloweenMod.MOD_ID, "owl"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, OwlEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());
    public static void registerModEntities() {
        MineloweenMod.LOGGER.info("Registering Mod Entities for " + MineloweenMod.MOD_ID);
    }
}
