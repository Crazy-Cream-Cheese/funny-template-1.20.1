package com.ccc.funny.recipe;

import com.ccc.funny.Funny;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipe {
public static void registerRecipe() {
    Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Funny.MOD_ID, FluidHandlingMachinesRecipe.Serializer.ID),
            FluidHandlingMachinesRecipe.Serializer.INSTANCE);
    Registry.register(Registries.RECIPE_TYPE, new Identifier(Funny.MOD_ID, FluidHandlingMachinesRecipe.Type.ID),
            FluidHandlingMachinesRecipe.Type.INSTANCE);
    }
}
