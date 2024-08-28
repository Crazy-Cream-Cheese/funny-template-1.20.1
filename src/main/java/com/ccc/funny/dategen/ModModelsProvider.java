package com.ccc.funny.dategen;

import com.ccc.funny.block.custom.TeaTreeCrop;
import com.ccc.funny.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import com.ccc.funny.block.ModBlocks;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEMON_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEMON_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.StickyLemonIcedTeaBlock);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FreshLemonIcedTeaBlock);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LemonIcedTeaSoul);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LemonIcedTeaEssence);
        blockStateModelGenerator.registerLog(ModBlocks.LEMON_LOG).log(ModBlocks.LEMON_LOG).wood(ModBlocks.LEMON_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_LEMON_LOG).log(ModBlocks.STRIPPED_LEMON_LOG).wood(ModBlocks.STRIPPED_LEMON_WOOD);
        blockStateModelGenerator.registerTintableCross(ModBlocks.LemonTreeSapling, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleState(ModBlocks.Syrup);
        blockStateModelGenerator.registerSimpleState(ModBlocks.FluidHandlingMachines);
        blockStateModelGenerator.registerCrop(ModBlocks.RED_TEA_TREE, TeaTreeCrop.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DEFECATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMESIS, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEMON, Models.GENERATED);
        itemModelGenerator.register(ModItems.FUNNY, Models.GENERATED);
        itemModelGenerator.register(ModItems.LemonIcedTeaEssence, Models.GENERATED);
        itemModelGenerator.register(ModItems.LemonIcedTeaSoul, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEMON_DRINK, Models.GENERATED);
        itemModelGenerator.register(ModItems.Syrup_Bucket, Models.GENERATED);
        itemModelGenerator.register(ModItems.PurifiedWater, Models.GENERATED);
        itemModelGenerator.register(ModItems.YouSeeMeDisc, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_TEA_SEED, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_TEA_LEAVE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRY_RED_TEA_LEAVE, Models.GENERATED);
        itemModelGenerator.register(ModItems.Lemon_Iced_Tea_Core, Models.GENERATED);
        itemModelGenerator.register(ModItems.Lemon_Iced_Tea, Models.GENERATED);

        itemModelGenerator.register(ModItems.Kobe_Bryant_Elbow, Models.HANDHELD);
        itemModelGenerator.register(ModItems.Lemon_Iced_Tea_Sword, Models.HANDHELD);
    }
}
