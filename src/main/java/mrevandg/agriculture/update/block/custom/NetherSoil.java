//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mrevandg.agriculture.update.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Iterator;
import java.util.Random;

import static net.minecraft.block.AbstractBlock.Settings;

public class NetherSoil extends FarmlandBlock {
    public NetherSoil() {
        super(Settings.of(Material.STONE, MapColor.DULL_RED));
        this.setDefaultState(this.getDefaultState().with(MOISTURE, 0));
    }

    private static boolean isLavaNearby(WorldView world, BlockPos pos) {
        Iterator var2 = BlockPos.iterate(pos.add(-4, 0, -4), pos.add(4, 1, 4)).iterator();
        BlockPos blockPos;
        do {
            if (!var2.hasNext()) {
                return false;
            }
            blockPos = (BlockPos)var2.next();
        } while(!world.getFluidState(blockPos).isIn(FluidTags.LAVA));
        return true;
    }
    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (!world.isClient && fallDistance > 0.5F && entity instanceof LivingEntity && (entity instanceof PlayerEntity || world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) && entity.getWidth() * entity.getWidth() * entity.getHeight() > 0.512F) {
            setToNetherrack(state, world, pos);
        }

        super.onLandedUpon(world, state, pos, entity, fallDistance);
    }

    public static void setToNetherrack(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, pushEntitiesUpBeforeBlockChange(state, Blocks.NETHERRACK.getDefaultState(), world, pos));
    }

    private static boolean hasCrop(BlockView world, BlockPos pos) {
        Block block = world.getBlockState(pos.up()).getBlock();
        return block instanceof CropBlock || block instanceof StemBlock || block instanceof AttachedStemBlock;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = (Integer)state.get(MOISTURE);
        if (!isLavaNearby(world, pos)) {
            if (i > 0) {
                world.setBlockState(pos, (BlockState)state.with(MOISTURE, i - 1), 2);
            } else if (!hasCrop(world, pos)) {
                setToDirt(state, world, pos);
            }
        } else if (i < 7) {
            world.setBlockState(pos, (BlockState)state.with(MOISTURE, 7), 2);
        }
    }
}
