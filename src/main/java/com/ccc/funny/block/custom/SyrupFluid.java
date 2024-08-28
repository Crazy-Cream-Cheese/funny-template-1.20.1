package com.ccc.funny.block.custom;

import com.ccc.funny.block.ModBlocks;
import com.ccc.funny.block.ModFluid;
import com.ccc.funny.block.ModFluids;
import com.ccc.funny.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;

public abstract class SyrupFluid extends ModFluid {
    @Override
    public Fluid getStill() {
        return ModFluids.Syrup;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_Syrup;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.Syrup_Bucket;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModBlocks.Syrup.getDefaultState().with(FluidBlock.LEVEL, LavaFluid.getBlockStateLevel(state));
    }

    public static class Flowing extends SyrupFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }
    }
    public static class Still extends SyrupFluid {

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }

        @Override
        public int getLevel(FluidState state) {
            return 8;
        }
    }
}
