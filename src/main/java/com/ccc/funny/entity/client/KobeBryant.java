
package com.ccc.funny.entity.client;

import com.ccc.funny.entity.animation.KobeBryantAnimation;
import com.ccc.funny.entity.custom.KobeBryantEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class KobeBryant<T extends KobeBryantEntity> extends SinglePartEntityModel<T> {
	private final ModelPart kobebryant;

	private final ModelPart Head;

	public KobeBryant(ModelPart root) {
		this.kobebryant = root.getChild("kobebryant");
        this.Head = kobebryant.getChild("Head");
    }
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData kobebryant = modelPartData.addChild("kobebryant", ModelPartBuilder.create(),
		ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData LeftLeg = kobebryant.addChild("LeftLeg", ModelPartBuilder.create()
		.uv(16, 48).cuboid(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)),
		ModelTransform.pivot(1.9F, -12.0F, 0.0F));

		ModelPartData RightLeg = kobebryant.addChild("RightLeg", ModelPartBuilder.create()
		.uv(0, 16).cuboid(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)),
		ModelTransform.pivot(-1.9F, -12.0F, 0.0F));

		ModelPartData LeftArm = kobebryant.addChild("LeftArm", ModelPartBuilder.create(),
		ModelTransform.pivot(5.0F, -22.0F, 0.0F));

		ModelPartData south = LeftArm.addChild("south", ModelPartBuilder.create()
		.uv(32, 48).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)),
		ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData north = LeftArm.addChild("north", ModelPartBuilder.create()
		.uv(32, 38).cuboid(-1.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)),
		ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData RightArm = kobebryant.addChild("RightArm", ModelPartBuilder.create()
		.uv(40, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)),
		ModelTransform.pivot(-5.0F, -22.0F, 0.0F));

		ModelPartData Body = kobebryant.addChild("Body", ModelPartBuilder.create()
		.uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)),
		ModelTransform.pivot(0.0F, -24.0F, 0.0F));

		ModelPartData Head = kobebryant.addChild("Head", ModelPartBuilder.create()
		.uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)),
		ModelTransform.pivot(0.0F, -24.0F, 0.0F));

		ModelPartData plane = kobebryant.addChild("plane", ModelPartBuilder.create().uv(0, 32)
		.cuboid(-0.5F, -8.0F, -0.5F, 1.0F, 8.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 41).cuboid(-4.5F, -8.0F, -0.5F, 9.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 33).cuboid(-0.5F, -8.0F, -4.5F, 1.0F, 1.0F, 9.0F, new Dilation(0.0F)),
		ModelTransform.pivot(0.0F, -32.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(KobeBryantEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(KobeBryantAnimation.RUN, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, KobeBryantAnimation.IDLE, 1.0f);
		this.updateAnimation(entity.attackAnimationState, KobeBryantAnimation.ATTACK, ageInTicks, 1.0f);
	}

	private void setHeadAngles(float headAngles, float headPitch) {
		headAngles = MathHelper.clamp(headAngles,-30.0F,30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);
		this.Head.yaw = headAngles * 0.017453292F;
		this.Head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		kobebryant.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return this.kobebryant;
	}
}