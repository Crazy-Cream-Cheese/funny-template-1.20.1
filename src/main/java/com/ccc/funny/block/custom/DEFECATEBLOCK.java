package com.ccc.funny.block.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.function.Function;
import java.util.stream.Stream;

public class DEFECATEBLOCK extends Block {
    public static final VoxelShape SHAPES = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(1, 2, 1, 15, 4, 15),
            Block.createCuboidShape(2, 4, 2, 14, 6, 14),
            Block.createCuboidShape(3, 6, 3, 13, 8, 13),
            Block.createCuboidShape(4, 8, 4, 12, 10, 12),
            Block.createCuboidShape(5, 10, 5, 11, 12, 11),
            Block.createCuboidShape(6, 12, 6, 10, 14, 10),
            Block.createCuboidShape(7, 14, 7, 9, 16, 9)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public DEFECATEBLOCK(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient()) {
            if (EntityType.PLAYER == entity.getType()) {
                PlayerEntity player = (PlayerEntity) entity;
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 2));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20, 0));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 2));
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES;
    }
}