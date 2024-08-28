package com.ccc.funny.world;

import com.ccc.funny.Funny;
import com.ccc.funny.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> LemonIcedTeaEssence_PLACED_KEY = registerKey("lemon_iced_tea_essence_placed");
    public static final RegistryKey<PlacedFeature> LemonIcedTeaSoul_PLACED_KEY = registerKey("lemon_iced_tea_soul_placed");
    public static final RegistryKey<PlacedFeature> LemonTree_PLACED_KEY = registerKey("lemon_tree_placed");

    public static void boostrap(Registerable<PlacedFeature> context){
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, LemonIcedTeaEssence_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LemonIcedTeaEssence_Key),
                ModOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-5),YOffset.fixed(100))));

        register(context,LemonIcedTeaSoul_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LemonIcedTeaSoul_Key),
                ModOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-60),YOffset.fixed(10))));

        register(context,LemonTree_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.Lemon_Tree),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2,0.1f,2),
                        ModBlocks.LemonTreeSapling));
    }
    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Funny.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
