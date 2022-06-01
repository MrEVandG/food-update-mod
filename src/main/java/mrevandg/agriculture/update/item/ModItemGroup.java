package mrevandg.agriculture.update.item;

import mrevandg.agriculture.update.AgricultureUpdate;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup AGRICULTURE_UPDATE = FabricItemGroupBuilder.build(new Identifier(AgricultureUpdate.MOD_ID, "agriculture_update"),
            () -> new ItemStack(ModItems.DIAMOND_CARROT));
}
