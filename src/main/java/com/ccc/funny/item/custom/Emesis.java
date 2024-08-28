package com.ccc.funny.item.custom;

import com.ccc.funny.sounds.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;

public class Emesis extends Item {
    public Emesis(Settings settings) {
        super(settings);
    }


    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user.getType() == EntityType.PLAYER && !world.isClient()) {
            PlayerEntity player = (PlayerEntity) user;
            player.playSound(ModSounds.EAT_EMESIS, SoundCategory.VOICE, 1.0f, 1.0f);
        }
        return super.finishUsing(stack, world, user);
    }
}