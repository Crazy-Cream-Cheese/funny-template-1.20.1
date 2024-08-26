package com.ccc.funny.world;

import com.ccc.funny.Funny;
import com.ccc.funny.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> LemonIcedTeaEssence_Key = registerKey("lemon_iced_tea_essence_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> LemonIcedTeaSoul_Key = registerKey("lemon_iced_tea_soul_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> Lemon_Tree = registerKey("lemon_tree");

    public static void boostrap(Registerable<ConfiguredFeature<?,?>> context){
        RuleTest Place = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest Place2 = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overWorld = List.of(
                OreFeatureConfig.createTarget(Place, ModBlocks.LemonIcedTeaEssence.getDefaultState()),
                OreFeatureConfig.createTarget(Place2, ModBlocks.LemonIcedTeaSoul.getDefaultState()));

        register(context, LemonIcedTeaEssence_Key,Feature.ORE,new OreFeatureConfig(overWorld,3));

        register(context, LemonIcedTeaSoul_Key,Feature.ORE,new OreFeatureConfig(overWorld,3));

        register(context, Lemon_Tree, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.LEMON_LOG),
                new StraightTrunkPlacer(6, 3, 1),
                BlockStateProvider.of(ModBlocks.LEMON_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(2), 3),
                new TwoLayersFeatureSize(1, 0, 2)

        ).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Funny.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
