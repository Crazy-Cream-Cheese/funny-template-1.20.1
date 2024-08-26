package com.ccc.funny.block;

import com.ccc.funny.Funny;
import com.ccc.funny.block.custom.DEFECATEBLOCK;
import com.ccc.funny.block.custom.FluidHandlingMachines;
import com.ccc.funny.block.custom.FreshLemonIcedTeaBlock;
import com.ccc.funny.block.custom.TeaTreeCrop;
import com.ccc.funny.world.tree.LemonTreeSaplingGen;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block DEFECATE_BLOCK = registerBlock("defecate_block", new DEFECATEBLOCK(FabricBlockSettings.copyOf(Blocks.SCULK).hardness(3)));
    public static final Block LEMON_LOG = registerBlock("lemon_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block LEMON_WOOD = registerBlock("lemon_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_LEMON_LOG = registerBlock("stripped_lemon_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_LEMON_WOOD = registerBlock("stripped_lemon_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block LEMON_PLANKS = registerBlock("lemon_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block LEMON_LEAVES = registerBlock("lemon_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).ticksRandomly()));
    public static final Block FreshLemonIcedTeaBlock = registerBlock("fresh_lemon_iced_tea_block", new FreshLemonIcedTeaBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).sounds(BlockSoundGroup.SCULK).mapColor(MapColor.YELLOW)));
    public static final Block StickyLemonIcedTeaBlock = registerBlock("sticky_lemon_iced_tea_block", new Block(FabricBlockSettings.copyOf(Blocks.SCULK).strength(1.5f).sounds(BlockSoundGroup.SCULK_SENSOR).mapColor(MapColor.YELLOW)));
    public static final Block LemonIcedTeaSoul = registerBlock("lemon_iced_tea_soul", new Block(FabricBlockSettings.copyOf(Blocks.SCULK_SHRIEKER).strength(50.0f, 1200.0F).mapColor(MapColor.GOLD)));
    public static final Block LemonIcedTeaEssence = registerBlock("lemon_iced_tea_essence", new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(75.0F, 1200.0F).mapColor(MapColor.PALE_YELLOW)));
    public static final Block LemonTreeSapling = registerBlock("lemon_tree_sapling", new SaplingBlock(new LemonTreeSaplingGen(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block Syrup = Registry.register(Registries.BLOCK, Identifier.of(Funny.MOD_ID, "syrup"), new FluidBlock(ModFluids.Syrup, AbstractBlock.Settings.copy(Blocks.LAVA)));
    public static final Block FluidHandlingMachines = registerBlock("fluid_handling_machines", new FluidHandlingMachines(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE)));
    public static final Block RED_TEA_TREE = Registry.register(Registries.BLOCK, new Identifier(Funny.MOD_ID, "red_tea_tree"), new TeaTreeCrop(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH)));
    private static Block registerBlock(String name, Block block) {
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Funny.MOD_ID, name), block);
    }
    private static Item registerBlockItems(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Funny.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
    }
}