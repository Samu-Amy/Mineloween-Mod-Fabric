package net.samu.mineloween.block.custom;

import net.minecraft.block.*;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.item.ItemConvertible;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.samu.mineloween.item.ModItems;
import net.samu.mineloween.particle.ModParticles;

public class AutumnalAshLeaves extends LeavesBlock {
    public AutumnalAshLeaves(AbstractBlock.Settings settings) {
        super(settings);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        if (random.nextInt(10) == 0) {
            BlockPos blockPos = pos.down();
            BlockState blockState = world.getBlockState(blockPos);
            if (!isFaceFullSquare(blockState.getCollisionShape(world, blockPos), Direction.UP)) {
                ParticleUtil.spawnParticle(world, pos, random, ModParticles.AUTUMNAL_LEAVES_PARTICLE);
            }
//            if (!isFaceFullSquare(blockState.getCollisionShape(world, blockPos), Direction.UP)) {
//                ParticleUtil.spawnParticles(world, blockPos, ModParticles.AUTUMNAL_LEAVES_PARTICLE, 1, Direction.DOWN);
//            }
        }
    }
}
