package com.ccc.funny.block.entity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

/**
 * 一个简单的 {@code SidedInventory} 实现，仅包含默认方法 + 项目列表 getter。
 *
 * <h2>读取和写入标签</h2>
 * 使用 {@link Inventories#writeNbt（NbtCompound， DefaultedList）} 和 {@link Inventories#readNbt（NbtCompound， DefaultedList）}
 * 在 {@linkplain #getItems（） 项列表} 上。
 *
 * 许可证：<a href=“https://creativecommons.org/publicdomain/zero/1.0/”>CC0</a>
 * @author Juuz
 */
@FunctionalInterface
public interface ImplementedInventory extends SidedInventory {
    /**
     * 获取此库存的 item 列表。
     * 每次调用时都必须返回相同的实例。
     *
     * @return项目列表
     */
    DefaultedList<ItemStack> getItems();

    /**
     * 从道具列表创建库存。
     *
     * @param项目列表的项目
     * @return新的库存
     */
    static ImplementedInventory of(DefaultedList<ItemStack> items) {
        return () -> items;
    }

    /**
     * 创建具有该大小的新库存。
     *
     * @param调整库存大小
     * @return新的库存
     */
    static ImplementedInventory ofSize(int size) {
        return of(DefaultedList.ofSize(size, ItemStack.EMPTY));
    }

    //侧库存

/**
     * 在侧面获取自动化的可用插槽。
     *
     * <p>默认实现返回所有插槽的数组。
     *
     * @param侧
     * @return可用插槽
     */
    @Override
    default int[] getAvailableSlots(Direction side) {
        int[] result = new int[getItems().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }

    /**
     * 如果堆栈可以插入侧面的插槽中，则返回 true。
     *
     * <p>默认实现返回 true。
     *
     * @param插槽
     * @param堆叠堆栈
     * @param侧
     * 如果可以插入堆栈，则@return true
     */
    @Override
    default boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        return true;
    }

    /**
     * 如果可以从侧面的插槽中提取堆栈，则返回 true。
     *
     * <p>默认实现返回 true。
     *
     * @param插槽
     * @param堆叠堆栈
     * @param侧
     * 如果堆栈可以提取，则@return true
     */
    @Override
    default boolean canExtract(int slot, ItemStack stack, Direction side) {
        return true;
    }

    //库存

/**
     * 返回库存大小。
     *
     * <p>默认实现返回 {@link #getItems（）} 的大小。
     *
     * @return库存大小
     */
    @Override
    default int size() {
        return getItems().size();
    }

    /**
     * 如果此库存只有空堆栈，则为 @return true，否则为 false
     */
    @Override
    default boolean isEmpty() {
        for (int i = 0; i < size(); i++) {
            ItemStack stack = getStack(i);
            if (!stack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    /**
     * 获取槽中的项目。
     *
     * @param插槽
     * @return槽中的物品
     */
    @Override
    default ItemStack getStack(int slot) {
        return getItems().get(slot);
    }

    /**
     * 从插槽中取出一叠大小。
     *
     * <p>（默认实现）如果槽中的项目数少于请求的项数，
     * 获取该槽位中的所有物品。
     *
     * @param插槽
     * @param计算项目计数
     * @return堆栈
     */
    @Override
    default ItemStack removeStack(int slot, int count) {
        ItemStack result = Inventories.splitStack(getItems(), slot, count);
        if (!result.isEmpty()) {
            markDirty();
        }

        return result;
    }

   /**
     * 删除 {@code slot} 中的当前堆栈并返回它。
     *
     * <p>默认实现使用 {@link Inventories#removeStack（List， int）}
     *
     * @param插槽
     * @return已删除的堆栈
     */
    @Override
    default ItemStack removeStack(int slot) {
        return Inventories.removeStack(getItems(), slot);
    }

    /**
     * 将 {@code slot} 中的当前堆栈替换为提供的堆栈。
     *
     * <p>如果堆栈对于此清单来说太大 （{@link Inventory#getMaxCountPerStack（）}），
     * 它的大小将调整为此库存的最大数量。
     *
     * @param插槽
     * @param堆叠堆栈
     */
    @Override
    default void setStack(int slot, ItemStack stack) {
        getItems().set(slot, stack);
        if (stack.getCount() > getMaxCountPerStack()) {
            stack.setCount(getMaxCountPerStack());
        }
        markDirty();
    }

    /**
     * 清除 {@linkplain #getItems（） 项列表}}。
     */
    @Override
    default void clear() {
        getItems().clear();
    }

    @Override
    default void markDirty() {
        // 如果需要行为，则覆盖。
    }

    @Override
    default boolean canPlayerUse(PlayerEntity player) {
        return true;
    }
}
