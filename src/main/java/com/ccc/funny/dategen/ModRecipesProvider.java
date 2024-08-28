package com.ccc.funny.dategen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import java.util.function.Consumer;

public class ModRecipesProvider extends FabricRecipeProvider {
    /*private static final List<ItemConvertible> Fart_List = List.of(ModItems.DEFECATE);*/
    public ModRecipesProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        /*offerSmelting(exporter, Fart_List, RecipeCategory.MISC, ModItems.DRY_DEFECATE, 0.2f, 200, "fart");*/

    }
}
