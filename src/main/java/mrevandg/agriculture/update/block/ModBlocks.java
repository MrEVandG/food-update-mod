package mrevandg.agriculture.update.block;

import mrevandg.agriculture.update.AgricultureUpdate;
import mrevandg.agriculture.update.block.custom.BlueberryBushBlock;
import mrevandg.agriculture.update.block.custom.NetherSoil;
import mrevandg.agriculture.update.block.custom.NetherberrySeedsBlock;
import mrevandg.agriculture.update.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block NETHERBERRY_SEEDS = registerBlockWithoutBlockItem("netherberry_seeds",
            new NetherberrySeedsBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()));

    public static final Block NETHER_SOIL = registerBlock("nether_soil",
        new NetherSoil(), ModItemGroup.AGRICULTURE_UPDATE);
    // BLUEBERRY BUSH
    public static final Block BLUEBERRY_BUSH = registerBlockWithoutBlockItem("blueberry_bush",
        new BlueberryBushBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()));


    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(AgricultureUpdate.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(AgricultureUpdate.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(AgricultureUpdate.MOD_ID, name), block);
    }
    public static void registerBlocks() {
        AgricultureUpdate.LOGGER.info("Registering blocks for namespace " + AgricultureUpdate.MOD_ID);
    }

}
