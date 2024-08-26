package com.ccc.funny.entity.client;

import com.ccc.funny.Funny;
import com.ccc.funny.entity.custom.KobeBryantEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class KobeBryantRenderer extends MobEntityRenderer<KobeBryantEntity, KobeBryant<KobeBryantEntity>> {
    public static final Identifier TEXTURE = new Identifier(Funny.MOD_ID, "textures/entity/kobebryant.png");

    public KobeBryantRenderer(EntityRendererFactory.Context context) {
        super(context, new KobeBryant<>(context.getPart(ModModelLayers.KobeBryant)), 0.5f);
    }

    @Override
    public Identifier getTexture(KobeBryantEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(KobeBryantEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (!mobEntity.isBaby()) {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
