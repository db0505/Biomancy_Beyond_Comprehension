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

public class FleshDragonModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("modid", "flesh_dragon"), "main");
	private final ModelPart Body;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart torso;
	private final ModelPart left_wing;
	private final ModelPart first_segment;
	private final ModelPart bone;
	private final ModelPart front_left_leg;
	private final ModelPart front_left_shin;
	private final ModelPart front_left_foot;
	private final ModelPart back_left_leg;
	private final ModelPart back_left_shin;
	private final ModelPart back_left_foot;
	private final ModelPart right_wing;
	private final ModelPart bone2;
	private final ModelPart first_segment2;
	private final ModelPart front_right_leg;
	private final ModelPart front_right_shin;
	private final ModelPart front_right_foot;
	private final ModelPart back_right_leg;
	private final ModelPart back_right_shin;
	private final ModelPart back_right_foot;

	public FleshDragonModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.head = this.Body.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.torso = this.Body.getChild("torso");
		this.left_wing = this.Body.getChild("left_wing");
		this.first_segment = this.left_wing.getChild("first_segment");
		this.bone = this.left_wing.getChild("bone");
		this.front_left_leg = this.Body.getChild("front_left_leg");
		this.front_left_shin = this.front_left_leg.getChild("front_left_shin");
		this.front_left_foot = this.front_left_shin.getChild("front_left_foot");
		this.back_left_leg = this.Body.getChild("back_left_leg");
		this.back_left_shin = this.back_left_leg.getChild("back_left_shin");
		this.back_left_foot = this.back_left_shin.getChild("back_left_foot");
		this.right_wing = this.Body.getChild("right_wing");
		this.bone2 = this.right_wing.getChild("bone2");
		this.first_segment2 = this.right_wing.getChild("first_segment2");
		this.front_right_leg = this.Body.getChild("front_right_leg");
		this.front_right_shin = this.front_right_leg.getChild("front_right_shin");
		this.front_right_foot = this.front_right_shin.getChild("front_right_foot");
		this.back_right_leg = this.Body.getChild("back_right_leg");
		this.back_right_shin = this.back_right_leg.getChild("back_right_shin");
		this.back_right_foot = this.back_right_shin.getChild("back_right_foot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, -23.0F, -71.0F));

		PartDefinition head = Body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(324, 66).addBox(-4.0F, 0.0F, -24.0F, 8.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(340, 156).addBox(-8.0F, -6.0F, 2.0F, 16.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(324, 46).addBox(-8.0F, -6.0F, -8.0F, 16.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(324, 86).addBox(-4.0F, 0.0F, -25.0F, 8.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(48, 333).addBox(-8.0F, 0.0F, -9.0F, 16.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 1.0F));

		PartDefinition torso = Body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 211).addBox(-16.0F, -4.0F, -16.0F, 32.0F, 18.0F, 30.0F, new CubeDeformation(0.0F))
				.texOffs(2, 150).addBox(-12.0F, 13.0F, 14.0F, 24.0F, 10.0F, 35.0F, new CubeDeformation(0.0F))
				.texOffs(2, 211).addBox(-14.0F, 14.0F, -16.0F, 28.0F, 10.0F, 30.0F, new CubeDeformation(0.0F))
				.texOffs(0, 150).addBox(-14.0F, -2.0F, 14.0F, 28.0F, 15.0F, 35.0F, new CubeDeformation(0.0F))
				.texOffs(206, 260).addBox(-10.0F, 0.0F, 48.0F, 20.0F, 21.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(124, 260).addBox(-8.0F, 2.0F, 68.0F, 16.0F, 17.0F, 25.0F, new CubeDeformation(0.0F))
				.texOffs(276, 196).addBox(-6.0F, 5.0F, 93.0F, 12.0F, 11.0F, 25.0F, new CubeDeformation(0.0F))
				.texOffs(206, 301).addBox(-4.0F, 7.0F, 118.0F, 8.0F, 7.0F, 25.0F, new CubeDeformation(0.0F))
				.texOffs(80, 302).addBox(-8.0F, 3.0F, -49.0F, 16.0F, 16.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(0, 270).addBox(-11.0F, 1.0F, -34.0F, 22.0F, 20.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 55.0F));

		PartDefinition left_wing = Body.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(16.0F, -10.0F, 49.0F));

		PartDefinition first_segment = left_wing.addOrReplaceChild("first_segment", CubeListBuilder.create().texOffs(272, 306).addBox(12.0F, -81.0F, -26.0F, 30.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, 77.0F, 22.0F));

		PartDefinition first_wing_r1 = first_segment.addOrReplaceChild("first_wing_r1", CubeListBuilder.create().texOffs(126, 150).addBox(-60.5169F, 0.0F, -63.8218F, 40.0F, 0.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -77.0F, -47.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone = left_wing.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(55.0F, 0.0F, -29.0F));

		PartDefinition second_wing_r1 = bone.addOrReplaceChild("second_wing_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-60.5169F, 0.0F, -63.8218F, 87.0F, 0.0F, 75.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 4.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition third_segment_r1 = bone.addOrReplaceChild("third_segment_r1", CubeListBuilder.create().texOffs(124, 220).addBox(-35.5168F, -3.0F, 5.1782F, 62.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -2.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition second_segment_r1 = bone.addOrReplaceChild("second_segment_r1", CubeListBuilder.create().texOffs(124, 244).addBox(-33.1835F, -4.0F, -25.336F, 47.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition front_left_leg = Body.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(142, 302).addBox(-2.0F, -4.0F, -4.0F, 12.0F, 25.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 5.0F, 49.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition front_left_shin = front_left_leg.addOrReplaceChild("front_left_shin", CubeListBuilder.create().texOffs(80, 270).addBox(-5.0F, -1.0F, -3.0F, 10.0F, 21.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 19.0682F, 0.5176F, -0.4363F, 0.0F, 0.0F));

		PartDefinition front_left_foot = front_left_shin.addOrReplaceChild("front_left_foot", CubeListBuilder.create().texOffs(190, 333).addBox(-4.0F, -5.0F, -8.0F, 10.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 24.9696F, 0.3473F, 0.1745F, 0.0F, 0.0F));

		PartDefinition back_left_leg = Body.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(276, 150).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 30.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, 1.0F, 89.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition back_left_shin = back_left_leg.addOrReplaceChild("back_left_shin", CubeListBuilder.create().texOffs(320, 322).addBox(-6.0F, -5.0F, -6.0F, 12.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.8457F, -0.2242F, 1.0472F, 0.0F, 0.0F));

		PartDefinition back_left_foot = back_left_shin.addOrReplaceChild("back_left_foot", CubeListBuilder.create().texOffs(324, 0).addBox(-5.0F, -10.0F, -16.0F, 10.0F, 5.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 29.0112F, -8.074F, -0.6545F, 0.0F, 0.0F));

		PartDefinition back_left_foot_r1 = back_left_foot.addOrReplaceChild("back_left_foot_r1", CubeListBuilder.create().texOffs(148, 339).addBox(-5.0F, -14.6071F, -7.4906F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -1.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition right_wing = Body.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(-16.0F, -10.0F, 49.0F));

		PartDefinition bone2 = right_wing.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(-55.0F, 0.0F, -29.0F));

		PartDefinition third_segment_r2 = bone2.addOrReplaceChild("third_segment_r2", CubeListBuilder.create().texOffs(124, 232).addBox(-26.4831F, -3.0F, 5.1782F, 62.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, -2.0F, -3.1416F, 0.0F, -3.1416F));

		PartDefinition second_wing_r2 = bone2.addOrReplaceChild("second_wing_r2", CubeListBuilder.create().texOffs(0, 75).addBox(-26.4831F, 0.0F, -63.8218F, 87.0F, 0.0F, 75.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, 4.0F, -3.1416F, 0.0F, -3.1416F));

		PartDefinition second_segment_r2 = bone2.addOrReplaceChild("second_segment_r2", CubeListBuilder.create().texOffs(234, 244).addBox(-13.8165F, -4.0F, -25.336F, 47.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition first_segment2 = right_wing.addOrReplaceChild("first_segment2", CubeListBuilder.create().texOffs(0, 308).addBox(-42.0F, -81.0F, -26.0F, 30.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, 77.0F, 22.0F));

		PartDefinition first_wing_r2 = first_segment2.addOrReplaceChild("first_wing_r2", CubeListBuilder.create().texOffs(126, 185).addBox(20.5169F, 0.0F, -63.8218F, 40.0F, 0.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -77.0F, -47.0F, -3.1416F, 0.0F, -3.1416F));

		PartDefinition front_right_leg = Body.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(272, 322).addBox(-10.0F, -4.0F, -4.0F, 12.0F, 25.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 5.0F, 49.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition front_right_shin = front_right_leg.addOrReplaceChild("front_right_shin", CubeListBuilder.create().texOffs(324, 106).addBox(-5.0F, -1.0F, -3.0F, 10.0F, 21.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 19.0682F, 0.5176F, -0.4363F, 0.0F, 0.0F));

		PartDefinition front_right_foot = front_right_shin.addOrReplaceChild("front_right_foot", CubeListBuilder.create().texOffs(100, 339).addBox(-6.0F, -5.0F, -8.0F, 10.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 24.9696F, 0.3473F, 0.1745F, 0.0F, 0.0F));

		PartDefinition back_right_leg = Body.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(286, 260).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 30.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 1.0F, 89.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition back_right_shin = back_right_leg.addOrReplaceChild("back_right_shin", CubeListBuilder.create().texOffs(0, 324).addBox(-6.0F, -5.0F, -6.0F, 12.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.8457F, -0.2242F, 1.0472F, 0.0F, 0.0F));

		PartDefinition back_right_foot = back_right_shin.addOrReplaceChild("back_right_foot", CubeListBuilder.create().texOffs(324, 23).addBox(-5.0F, -10.0F, -16.0F, 10.0F, 5.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 29.0112F, -8.074F, -0.6545F, 0.0F, 0.0F));

		PartDefinition back_right_foot_r1 = back_right_foot.addOrReplaceChild("back_right_foot_r1", CubeListBuilder.create().texOffs(340, 136).addBox(-5.0F, -14.6071F, -7.4906F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -1.0F, -0.0873F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Body;
	}
}