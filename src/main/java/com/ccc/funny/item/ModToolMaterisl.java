package com.ccc.funny.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterisl implements ToolMaterial {
    // 定义一个TERRIER工具材料
    FUNNY(0, 4000, 0, 0, 15, () -> Ingredient.ofItems(ModItems.FUNNY));

    // 定义一个ModToolMaterial类
    private final int miningLevel; //  MiningLevel：采矿等级
    private final int itemDurability; // ItemDurability：物品耐久度
    private final float miningSpeed; // MiningSpeed：采矿速度
    private final float attackDamage; // AttackDamage：攻击伤害
    private final int enchantability; // Enchantability：附魔能力
    private final Supplier<Ingredient> repairIngredient; // RepairIngredient：修复材料

    // 构造函数
    ModToolMaterisl(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    // 获取物品耐久度
    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    // 获取采矿速度
    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    // 获取攻击伤害
    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    // 获取采矿等级
    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    // 获取附魔能力
    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    // 获取修复材料
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
