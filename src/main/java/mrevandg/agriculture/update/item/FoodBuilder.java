package mrevandg.agriculture.update.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponent.Builder;

public class FoodBuilder {
    public static FoodComponent buildFoodComponent(int hunger, float saturation, boolean edibleToDogs) {
        Builder c = new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation);
        if (edibleToDogs) {
            c.meat();
        }
        return c.build();
    }
}
