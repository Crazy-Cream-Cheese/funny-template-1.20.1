package com.ccc.funny.dategen;

import com.ccc.funny.block.ModBlocks;
import com.ccc.funny.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.LEMON_LOG.asItem())
                .add(ModBlocks.LEMON_WOOD.asItem())
                .add(ModBlocks.STRIPPED_LEMON_LOG.asItem())
                .add(ModBlocks.STRIPPED_LEMON_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.LEMON_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.YouSeeMeDisc);
    }
}
