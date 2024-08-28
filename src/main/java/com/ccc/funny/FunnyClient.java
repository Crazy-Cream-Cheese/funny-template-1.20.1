package com.ccc.funny;

import com.ccc.funny.block.ModBlocks;
import com.ccc.funny.block.ModFluids;
import com.ccc.funny.entity.ModEntities;
import com.ccc.funny.entity.client.KobeBryant;
import com.ccc.funny.entity.client.KobeBryantRenderer;
import com.ccc.funny.entity.client.ModModelLayers;
import com.ccc.funny.screen.FluidHandlingMachinesScreen;
import com.ccc.funny.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

// 实现ClientModInitializer接口
public class FunnyClient implements ClientModInitializer {
    // 重写onInitializeClient方法
    @Override
    public void onInitializeClient() {
        // 在这里进行客户端初始化操作
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEMON_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LemonTreeSapling, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEFECATE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_TEA_TREE, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.KobeBryant, KobeBryant::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.KobeBryant, KobeBryantRenderer::new);
        HandledScreens.register(ModScreenHandlers.Fluid_Handling_Machines_SCREEN_HANDLER, FluidHandlingMachinesScreen::new);
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.Syrup, ModFluids.FLOWING_Syrup,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        0x979b9d
                ));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.Syrup, ModFluids.FLOWING_Syrup);
    }
}