package com.ccc.funny.block.entity;

import com.ccc.funny.item.ModItems;
import com.ccc.funny.recipe.FluidHandlingMachinesRecipe;
import com.ccc.funny.screen.FluidHandlingMachinesScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class FluidHandlingMachinesBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory,ImplementedInventory {
    /*
    *家人们
    *bug是在修不好了
    *哪位大佬能看一看
    *到底错在哪
    *可以将问题提交到github上
     */
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3,ItemStack.EMPTY);

    private static final int INPUT_SLOT_1 = 0;
    private static final int INPUT_SLOT_2 = 1;
    private static final int OUTPUT_SLOT = 2;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 180;

    public FluidHandlingMachinesBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.Fluid_Handling_Machines_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index){
                    case 0 -> FluidHandlingMachinesBlockEntity.this.progress;
                    case 1 -> FluidHandlingMachinesBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0 -> FluidHandlingMachinesBlockEntity.this.progress = value;
                    case 1 -> FluidHandlingMachinesBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("title.funny.fluid_handling_machines");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new FluidHandlingMachinesScreenHandler(syncId,playerInventory,this,this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt,inventory);
        nbt.putInt("fluid_handling_machines",progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt,inventory);
        progress = nbt.getInt("fluid_handling_machines");
    }

    public void tick(World world1, BlockPos pos, BlockState state1) {
        if (world1.isClient()){
            return;
        }
        if (isOutputSlotAvailable()){
            if (this.hasRecipe()){
                System.out.println("has recipe");
                this.increaseCraftProgress();
                markDirty(world1,pos,state1);

                if (hasCraftingFinished()){
                    this.craftItem();
                    this.resetProgress();
                    System.out.println("crafting finished");
                }
            }else {
                this.resetProgress();
                System.out.println("no recipe");
            }
        }else {
            this.resetProgress();
            markDirty(world1, pos, state1);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        Optional<FluidHandlingMachinesRecipe> recipe = getCurrentRecipe();
        this.setStack(OUTPUT_SLOT,new ItemStack(recipe.get().getOutput(null).getItem(),
                getStack(OUTPUT_SLOT).getCount() + recipe.get().getOutput(null).getCount()));
        this.removeStack(INPUT_SLOT_2,1);
        this.removeStack(INPUT_SLOT_1, 9);
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        Optional<FluidHandlingMachinesRecipe> recipe = getCurrentRecipe();

        return recipe.isPresent() &&
                canInsertAmountIntoOutputSlot(recipe.get().getOutput(null)) &&
                canInsertItemIntoOutputSlot(recipe.get().getOutput(null).getItem()) &&
                this.getStack(INPUT_SLOT_2).getCount() >= 1 && this.getStack(INPUT_SLOT_1).getCount() >= 9 &&
                this.getStack(INPUT_SLOT_2).getItem() == ModItems.PurifiedWater;
    }

    private Optional<FluidHandlingMachinesRecipe> getCurrentRecipe() {
        SimpleInventory inv = new SimpleInventory(this.size());
        for (int i = 0; i< this.size(); i++){
            inv.setStack(i,this.getStack(i));
        }
        return getWorld().getRecipeManager().getFirstMatch(FluidHandlingMachinesRecipe.Type.INSTANCE,inv,getWorld());
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean isOutputSlotAvailable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }

}