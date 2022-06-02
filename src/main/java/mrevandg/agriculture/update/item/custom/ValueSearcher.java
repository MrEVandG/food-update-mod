package mrevandg.agriculture.update.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class ValueSearcher extends Item {
    public ValueSearcher(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        // search for valuables at the x and z

        if (context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean found = false; // change when an ore is found
            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                Block blockBelow = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();
                if (valuableAtPos(blockBelow)) {
                    outputCoords(positionClicked.down(i), player, blockBelow);
                    found = true;
                    break;
                }
            }
            if (!found) {
                player.sendMessage(new TranslatableText("item.food.valuable_searcher.nothing_found"), true);
            }

            context.getStack().damage(1, player, player1 -> player1.sendToolBreakStatus(player.getActiveHand()));
        }
        return super.useOnBlock(context);
    }

    private void outputCoords(BlockPos blockPos, PlayerEntity player, Block blockBelow) {
        player.sendMessage(new LiteralText("Found " + blockBelow.asItem().getName().getString() + " at (" + blockPos.getX() + ", " + blockPos.getX() + ", " + blockPos.getZ() + ")."), true);
    }
    private boolean valuableAtPos(Block block) {
        return block == Blocks.DIAMOND_ORE || block == Blocks.EMERALD_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE || block == Blocks.DEEPSLATE_EMERALD_ORE;
    }
}
