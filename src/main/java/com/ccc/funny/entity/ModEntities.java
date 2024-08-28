package com.ccc.funny.entity;

import com.ccc.funny.Funny;
import com.ccc.funny.entity.custom.KobeBryantEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<KobeBryantEntity> KobeBryant = Registry.register(Registries.ENTITY_TYPE, new Identifier(Funny.MOD_ID,"kobe_bryant"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER,KobeBryantEntity::new).dimensions(EntityDimensions.changing(0.5f,1.8f)).build());
}