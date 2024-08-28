package com.ccc.funny.world.biome;

import com.ccc.funny.Funny;
import com.ccc.funny.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerraBlenderAPI implements TerraBlenderApi{
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(Funny.MOD_ID,"overworld"),1));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD,Funny.MOD_ID, ModMaterialRules.makeRules());
    }
}
