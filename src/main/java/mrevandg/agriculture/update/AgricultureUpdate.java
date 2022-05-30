package mrevandg.agriculture.update;

import mrevandg.agriculture.update.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgricultureUpdate implements ModInitializer {

    public static final String MOD_ID = "food";

    public static final Logger LOGGER = LoggerFactory.getLogger("food");
    // ITEMS
    public static final Item DIAMOND_CARROT = new Item(new Item.Settings().group(ItemGroup.FOOD));
	public static final Item DIAMOND_DUST = new Item(new Item.Settings().group(ItemGroup.MISC));
	// NETHERBERRY


    @Override
	public void onInitialize() {
        LOGGER.info("Mod initialized!");

        ModItems.registerModItems();
    }
}
