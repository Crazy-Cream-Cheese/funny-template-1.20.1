package com.ccc.funny.block;

import com.ccc.funny.Funny;
import com.ccc.funny.block.custom.SyrupFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static final FlowableFluid FLOWING_Syrup = register("flowing_syrup", new SyrupFluid.Flowing());
    public static final FlowableFluid Syrup = register("syrup", new SyrupFluid.Still());
    private static <T extends Fluid> T register(String id, T value) {
        return Registry.register(Registries.FLUID, Identifier.of(Funny.MOD_ID, id), value);
    }

    static {
        for (Fluid fluid : Registries.FLUID) {
            for (FluidState fluidState : fluid.getStateManager().getStates()) {
                Fluid.STATE_IDS.add(fluidState);
            }
        }
    }
    public static void registerModFluids() {

    }
}
