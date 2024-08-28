package com.ccc.funny.mixin;

import net.minecraft.client.gui.screen.SplashOverlay;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SplashOverlay.class)
public class GSMixin {
    @Mutable
    @Shadow
    @Final
    private static int MOJANG_RED = ColorHelper.Argb.getArgb(255, 255, 255, 255);

    @Mutable
    @Shadow
    @Final
    static Identifier LOGO = new Identifier("textures/gui/title/gs.png");


}