package mrevandg.agriculture.update;

import mrevandg.agriculture.update.block.ModBlocks;
import mrevandg.agriculture.update.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgricultureUpdate implements ModInitializer {

    public static final String MOD_ID = "food";

    public static final Logger LOGGER = LoggerFactory.getLogger("food");

    @Override
	public void onInitialize() {
        LOGGER.info("Mod initialized!");

        ModItems.registerModItems();
        ModBlocks.registerBlocks();
    }
}
