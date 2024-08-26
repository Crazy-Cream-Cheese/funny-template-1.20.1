package com.ccc.funny.block.entity;

import com.ccc.funny.Funny;
import com.ccc.funny.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<FluidHandlingMachinesBlockEntity> Fluid_Handling_Machines_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE,new Identifier(Funny.MOD_ID,"fluid_handling_machines_block_entity"),
            FabricBlockEntityTypeBuilder.create(FluidHandlingMachinesBlockEntity::new,
            ModBlocks.FluidHandlingMachines).build());
    public static void registerBlockEntities(){}
}
