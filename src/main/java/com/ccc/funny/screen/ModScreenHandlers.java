package com.ccc.funny.screen;

import com.ccc.funny.Funny;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<FluidHandlingMachinesScreenHandler> Fluid_Handling_Machines_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER,new Identifier(Funny.MOD_ID,"fluid_handling_machines"),
                    new ExtendedScreenHandlerType<>(FluidHandlingMachinesScreenHandler::new));
    public static void registerScreenHandlers(){}
}
