package net.db0505.biomancybeyondcomprehension.entity.Client;// Made with Blockbench 5.0.7

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.db0505.biomancybeyondcomprehension.entity.Animations.ModAnimationsDefinitions;
import net.db0505.biomancybeyondcomprehension.entity.custom.MalformedFleshBlobEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class MalformedFleshBlobModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("modid", "malformed_flesh_blob"), "main");
	private final ModelPart MalformedFleshBlob;
	private final ModelPart Body;
	private final ModelPart Ribs;
	private final ModelPart Tumors;
	private final ModelPart Eye;

	public MalformedFleshBlobModel(ModelPart root) {
		this.MalformedFleshBlob = root.getChild("MalformedFleshBlob");
		this.Body = this.MalformedFleshBlob.getChild("Body");
		this.Ribs = this.MalformedFleshBlob.getChild("Ribs");
		this.Tumors = this.MalformedFleshBlob.getChild("Tumors");
		this.Eye = this.MalformedFleshBlob.getChild("Eye");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition MalformedFleshBlob = partdefinition.addOrReplaceChild("MalformedFleshBlob", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -0.1F, -14.0F, 16.0F, 0.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 6.0F));

		PartDefinition Body = MalformedFleshBlob.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(44, 42).addBox(-4.0F, -5.0F, -7.0F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 32).addBox(-5.0F, -6.0F, -4.0F, 10.0F, 6.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(44, 32).addBox(-4.0F, -5.0F, 8.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 50).addBox(-3.0F, -4.0F, 13.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(38, 50).addBox(-2.0F, -3.0F, 17.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(38, 56).addBox(-1.0F, -2.0F, 20.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition Ribs = MalformedFleshBlob.addOrReplaceChild("Ribs", CubeListBuilder.create().texOffs(48, 56).addBox(-6.0F, -7.0F, -2.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 58).addBox(-6.0F, -8.0F, -1.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(10, 58).addBox(-7.0F, -8.0F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(58, 56).addBox(-7.0F, -9.0F, 1.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition Tumors = MalformedFleshBlob.addOrReplaceChild("Tumors", CubeListBuilder.create().texOffs(20, 50).addBox(2.0F, -7.0F, -2.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(28, 59).addBox(3.0F, -3.0F, 14.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(52, 50).addBox(-5.0F, -6.0F, 9.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(20, 59).addBox(-6.0F, -4.0F, 3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition Eye = MalformedFleshBlob.addOrReplaceChild("Eye", CubeListBuilder.create().texOffs(35, 61).addBox(-4.0F, -6.0F, -8.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 2.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationsDefinitions.Move_Anim, limbSwing, limbSwingAmount, 2f , 2.5f);
		this.animate(((MalformedFleshBlobEntity) entity).idleAnimationState, ModAnimationsDefinitions.Idle_Anim, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -25.0F, 25.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 25.0F);

		this.Eye.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.Eye.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		MalformedFleshBlob.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return MalformedFleshBlob;
	}

}