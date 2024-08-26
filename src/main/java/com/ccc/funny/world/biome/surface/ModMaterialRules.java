package com.ccc.funny.world.biome.surface;

import com.ccc.funny.block.ModBlocks;
import com.ccc.funny.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule Sticky = makeStateRule(ModBlocks.StickyLemonIcedTeaBlock);
    private static final MaterialRules.MaterialRule Fresh = makeStateRule(ModBlocks.FreshLemonIcedTeaBlock);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, makeStateRule(Blocks.GRASS_BLOCK)/*Fresh*/), Sticky);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.LEMON_ICED_TEA_BIOME),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_6, Fresh)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_30, Sticky),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        ));
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
