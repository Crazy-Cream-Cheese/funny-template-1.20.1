package com.ccc.funny.dategen;

import com.ccc.funny.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.DEFECATE_BLOCK);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.LemonIcedTeaEssence)
                .add(ModBlocks.LemonIcedTeaSoul);
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.DEFECATE_BLOCK)
                .add(ModBlocks.LemonIcedTeaSoul)
                .add(ModBlocks.LemonIcedTeaEssence);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.LEMON_LOG)
                .add(ModBlocks.LEMON_WOOD)
                .add(ModBlocks.STRIPPED_LEMON_LOG)
                .add(ModBlocks.STRIPPED_LEMON_WOOD);
        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.FreshLemonIcedTeaBlock);
    }
}
