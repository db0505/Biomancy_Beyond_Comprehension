package net.db0505.biomancybeyondcomprehension.entity.Client;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class MalformedFleshBlobModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("modid", "malformed_flesh_blob"), "main");
	private final ModelPart Body;
	private final ModelPart bone;
	private final ModelPart Ribs;
	private final ModelPart Tumors;
	private final ModelPart bb_main;

	public MalformedFleshBlobModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.bone = this.Body.getChild("bone");
		this.Ribs = this.Body.getChild("Ribs");
		this.Tumors = this.Body.getChild("Tumors");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(44, 42).addBox(-4.0F, -5.0F, -5.0F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-5.0F, -6.0F, -2.0F, 10.0F, 6.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(44, 32).addBox(-4.0F, -5.0F, 10.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 50).addBox(-3.0F, -4.0F, 15.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(38, 50).addBox(-2.0F, -3.0F, 19.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(38, 56).addBox(-1.0F, -2.0F, 22.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(39, 61).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -2.0F));

		PartDefinition bone = Body.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 18.0F));

		PartDefinition Ribs = Body.addOrReplaceChild("Ribs", CubeListBuilder.create().texOffs(48, 56).addBox(-6.0F, -7.0F, -2.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 58).addBox(-6.0F, -8.0F, -1.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(10, 58).addBox(-7.0F, -8.0F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(58, 56).addBox(-7.0F, -9.0F, 1.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition Tumors = Body.addOrReplaceChild("Tumors", CubeListBuilder.create().texOffs(20, 50).addBox(2.0F, -7.0F, -2.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(28, 59).addBox(3.0F, -3.0F, 14.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(52, 50).addBox(-5.0F, -6.0F, 9.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(20, 59).addBox(-6.0F, -4.0F, 3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return bb_main;
	}
}