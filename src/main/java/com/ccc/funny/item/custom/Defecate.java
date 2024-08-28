package com.ccc.funny.item.custom;

import com.ccc.funny.sounds.ModSounds;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class Defecate extends Item {

    public Defecate(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 2));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20, 0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 2));
            user.sendMessage(Text.translatable("message.funny.defecate"));
        }
        return super.use(world, user, hand);
    }
}