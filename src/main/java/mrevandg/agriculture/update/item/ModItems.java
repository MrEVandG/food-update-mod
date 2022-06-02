package mrevandg.agriculture.update.item;

import mrevandg.agriculture.update.AgricultureUpdate;
import mrevandg.agriculture.update.block.ModBlocks;
import mrevandg.agriculture.update.item.custom.BlueberryItem;
import mrevandg.agriculture.update.item.custom.ValueSearcher;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item DIAMOND_CARROT = registerItem("diamond_carrot",
            new Item(new FabricItemSettings().group(ModItemGroup.AGRICULTURE_UPDATE)));

    public static final Item DIAMOND_DUST = registerItem("diamond_dust",
            new Item(new FabricItemSettings().group(ModItemGroup.AGRICULTURE_UPDATE)));

    public static final Item NETHERBERRY_FRUIT = registerItem("netherberry_fruit",
            new AliasedBlockItem(ModBlocks.NETHERBERRY_SEEDS,
                    new FabricItemSettings().group(ModItemGroup.AGRICULTURE_UPDATE)));
    // BLUEBERRIES AND BLUEBERRY SEEDS
    public static final Item BLUEBERRY = registerItem("blueberry",
            new BlueberryItem(new FabricItemSettings().group(ModItemGroup.AGRICULTURE_UPDATE)));

    public static final Item BLUEBERRY_SEEDS = registerItem("blueberry_seeds",
            new AliasedBlockItem(ModBlocks.BLUEBERRY_BUSH,
                new FabricItemSettings().group(ModItemGroup.AGRICULTURE_UPDATE)));

    public static final Item VALUE_SEARCHER = registerItem("valuable_searcher",
            new ValueSearcher(new FabricItemSettings().group(ModItemGroup.AGRICULTURE_UPDATE).maxDamage(30)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(AgricultureUpdate.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AgricultureUpdate.LOGGER.info("registering items for " + AgricultureUpdate.MOD_ID);


    }
}
