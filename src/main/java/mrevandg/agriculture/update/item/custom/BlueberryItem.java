package mrevandg.agriculture.update.item.custom;

import mrevandg.agriculture.update.item.FoodBuilder;
import net.minecraft.item.Item;

public class BlueberryItem extends Item {
    public BlueberryItem(Settings settings) {
        super(settings.food(FoodBuilder.buildFoodComponent(2, 0.35f, true)));
    }
    // that's it. blueberries don't do anything special
}