package net.samu.mineloween.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import org.jetbrains.annotations.Nullable;

public class AutumnalLeavesParticle extends CherryLeavesParticle {

    public AutumnalLeavesParticle(ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider, double xd, double yd, double zd) {
        super(world, x, y, z, spriteProvider);
    }

    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteProvider) {
            this.sprites = spriteProvider;
        }

        @Nullable
        @Override
        public Particle createParticle(DefaultParticleType parameters, ClientWorld clientWorld, double x, double y, double z, double xd, double yd, double zd) {
            return new AutumnalLeavesParticle(clientWorld, x, y, z, this.sprites, xd, yd, zd);
        }
    }
}

//public class AutumnalLeavesParticle extends SpriteBillboardParticle {
//    public AutumnalLeavesParticle(ClientWorld world, double xCoord, double yCoord, double zCoord, SpriteProvider spriteSet, double xd, double yd, double zd) {
//
//        super(world, xCoord, yCoord, zCoord, xd, yd, zd);
//    }
//
//    @Override
//    public ParticleTextureSheet getType() {
//        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
//    }
//
//    public static class Factory implements ParticleFactory<DefaultParticleType> {
//        private final SpriteProvider sprites;
//
//        public Factory(SpriteProvider spriteProvider) {
//            this.sprites = spriteProvider;
//        }
//
//        public Particle createParticle(DefaultParticleType particleType)
//    }
//}
