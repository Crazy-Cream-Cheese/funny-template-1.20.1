package com.ccc.funny.world.gen;

import com.ccc.funny.world.ModPlacedFeatures;
import com.ccc.funny.world.biome.ModBiomes;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void registerTrees(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.LEMON_ICED_TEA_BIOME),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LemonTree_PLACED_KEY);
    }
}
