package com.ccc.funny.sounds;

import com.ccc.funny.Funny;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent EAT_EMESIS = registerSoundsEvent("eat_emesis");
    public static final SoundEvent See_You_Again = registerSoundsEvent("see_you_again");
    public static final SoundEvent YouSeeMe = registerSoundsEvent("you_see_me");
    public static SoundEvent registerSoundsEvent(String name) {
        Identifier idtf = new Identifier(Funny.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, idtf, SoundEvent.of(idtf));
    }
    public static void registerSounds() {

    }
}
