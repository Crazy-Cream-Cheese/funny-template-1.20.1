package com.ccc.funny.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent EMESIS = new FoodComponent.Builder().hunger(1).saturationModifier(0.0F).statusEffect(
            new StatusEffectInstance(StatusEffects.NAUSEA,200),0.5f).build();
    public static final FoodComponent LEMON = new FoodComponent.Builder().hunger(3).saturationModifier(0.7F).statusEffect(
            new StatusEffectInstance(StatusEffects.REGENERATION, (int) (Math.random() * 100)),0.3f).build();
    public static final FoodComponent LEMON_DRINK = new FoodComponent.Builder().hunger(5).saturationModifier(0.3F).build();
    public static final FoodComponent RedTea = new FoodComponent.Builder().hunger(0).saturationModifier(0).statusEffect(
            new StatusEffectInstance(StatusEffects.SPEED, 200), 1f).build();
}