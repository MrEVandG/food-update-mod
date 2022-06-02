package mrevandg.agriculture.update.block.custom;

import mrevandg.agriculture.update.block.ModBlocks;
import mrevandg.agriculture.update.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class NetherberrySeedsBlock extends CropBlock {
    public NetherberrySeedsBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.NETHERBERRY_FRUIT;
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.NETHER_SOIL);
    }
}
