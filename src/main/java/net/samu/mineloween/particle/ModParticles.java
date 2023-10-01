package net.samu.mineloween.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.CherryLeavesParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;

public class ModParticles {
    public static final DefaultParticleType AUTUMNAL_LEAVES_PARTICLE = registerParticle("autumnal_leaves_particle", FabricParticleTypes.simple());

    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(MineloweenMod.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        MineloweenMod.LOGGER.info("Registering Particles for " + MineloweenMod.MOD_ID);
    }
}
