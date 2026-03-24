package net.db0505.biomancybeyondcomprehension.entity.Client;// Made with Blockbench 5.0.7

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.db0505.biomancybeyondcomprehension.entity.Animations.ModAnimationsDefinitions;
import net.db0505.biomancybeyondcomprehension.entity.custom.FleshDragonEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class FleshDragonModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("modid", "flesh_dragon"), "main");
	private final ModelPart Body;
	private final ModelPart upper_chest;
	private final ModelPart neck_1;
	private final ModelPart neck_2;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart lower_torso;
	private final ModelPart tail_segment_1;
	private final ModelPart tail_segment_2;
	private final ModelPart tail_2;
	private final ModelPart tail_3;
	private final ModelPart back_left_leg;
	private final ModelPart back_left_shin;
	private final ModelPart back_left_foot;
	private final ModelPart back_right_leg;
	private final ModelPart back_right_shin;
	private final ModelPart back_right_foot;
	private final ModelPart front_left_leg;
	private final ModelPart front_left_shin;
	private final ModelPart front_left_foot;
	private final ModelPart front_right_leg;
	private final ModelPart front_right_shin;
	private final ModelPart front_right_foot;
	private final ModelPart left_wing;
	private final ModelPart wing_segment_1;
	private final ModelPart wing_segment_2;
	private final ModelPart right_wing;
	private final ModelPart wing_segment_3;
	private final ModelPart wing_segment_4;

	public FleshDragonModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.upper_chest = this.Body.getChild("upper_chest");
		this.neck_1 = this.upper_chest.getChild("neck_1");
		this.neck_2 = this.neck_1.getChild("neck_2");
		this.head = this.neck_2.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.lower_torso = this.upper_chest.getChild("lower_torso");
		this.tail_segment_1 = this.lower_torso.getChild("tail_segment_1");
		this.tail_segment_2 = this.tail_segment_1.getChild("tail_segment_2");
		this.tail_2 = this.tail_segment_2.getChild("tail_2");
		this.tail_3 = this.tail_2.getChild("tail_3");
		this.back_left_leg = this.lower_torso.getChild("back_left_leg");
		this.back_left_shin = this.back_left_leg.getChild("back_left_shin");
		this.back_left_foot = this.back_left_shin.getChild("back_left_foot");
		this.back_right_leg = this.lower_torso.getChild("back_right_leg");
		this.back_right_shin = this.back_right_leg.getChild("back_right_shin");
		this.back_right_foot = this.back_right_shin.getChild("back_right_foot");
		this.front_left_leg = this.upper_chest.getChild("front_left_leg");
		this.front_left_shin = this.front_left_leg.getChild("front_left_shin");
		this.front_left_foot = this.front_left_shin.getChild("front_left_foot");
		this.front_right_leg = this.upper_chest.getChild("front_right_leg");
		this.front_right_shin = this.front_right_leg.getChild("front_right_shin");
		this.front_right_foot = this.front_right_shin.getChild("front_right_foot");
		this.left_wing = this.upper_chest.getChild("left_wing");
		this.wing_segment_1 = this.left_wing.getChild("wing_segment_1");
		this.wing_segment_2 = this.wing_segment_1.getChild("wing_segment_2");
		this.right_wing = this.upper_chest.getChild("right_wing");
		this.wing_segment_3 = this.right_wing.getChild("wing_segment_3");
		this.wing_segment_4 = this.wing_segment_3.getChild("wing_segment_4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, -23.0F, -18.0F));

		PartDefinition upper_chest = Body.addOrReplaceChild("upper_chest", CubeListBuilder.create().texOffs(0, 235).addBox(-14.0F, 2.0F, -15.0F, 28.0F, 10.0F, 30.0F, new CubeDeformation(0.0F))
				.texOffs(126, 185).addBox(-16.0F, -16.0F, -15.0F, 32.0F, 18.0F, 30.0F, new CubeDeformation(0.0F))
				.texOffs(246, 357).addBox(-3.0F, -20.0F, -6.0F, 6.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 1.0F));

		PartDefinition neck_1 = upper_chest.addOrReplaceChild("neck_1", CubeListBuilder.create().texOffs(38, 345).addBox(-2.0F, -12.3333F, -14.0F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(244, 257).addBox(-11.0F, -8.3333F, -18.0F, 22.0F, 20.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.6667F, -15.0F));

		PartDefinition neck_2 = neck_1.addOrReplaceChild("neck_2", CubeListBuilder.create().texOffs(218, 278).addBox(-2.0F, -9.8333F, -12.0F, 4.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(144, 314).addBox(-8.0F, -6.8333F, -15.0F, 16.0F, 16.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -18.0F));

		PartDefinition head = neck_2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(350, 40).addBox(-4.0F, 0.0F, -27.0F, 8.0F, 4.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(282, 350).addBox(-8.0F, -6.0F, -4.0F, 16.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(324, 289).addBox(-8.0F, -6.0F, -14.0F, 16.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.1667F, -15.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(350, 57).addBox(-4.0F, 0.0F, -22.0F, 8.0F, 4.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(332, 205).addBox(-8.0F, 0.0F, -9.0F, 16.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -5.0F));

		PartDefinition lower_torso = upper_chest.addOrReplaceChild("lower_torso", CubeListBuilder.create().texOffs(126, 233).addBox(-12.0F, 5.0F, 0.0F, 24.0F, 10.0F, 35.0F, new CubeDeformation(0.0F))
				.texOffs(0, 185).addBox(-14.0F, -10.0F, 0.0F, 28.0F, 15.0F, 35.0F, new CubeDeformation(0.0F))
				.texOffs(322, 357).addBox(-3.0F, -14.0F, 21.0F, 6.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(210, 357).addBox(-3.0F, -15.0F, 2.0F, 6.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 15.0F));

		PartDefinition tail_segment_1 = lower_torso.addOrReplaceChild("tail_segment_1", CubeListBuilder.create().texOffs(0, 275).addBox(-10.0F, -9.8333F, -1.3333F, 20.0F, 18.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(358, 357).addBox(-2.0F, -13.8333F, 3.6667F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.8333F, 35.3333F));

		PartDefinition tail_segment_2 = tail_segment_1.addOrReplaceChild("tail_segment_2", CubeListBuilder.create().texOffs(250, 185).addBox(-8.0F, -6.3333F, 0.3333F, 16.0F, 14.0F, 25.0F, new CubeDeformation(0.0F))
				.texOffs(114, 324).addBox(-2.0F, -9.3333F, 6.3333F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 18.3333F));

		PartDefinition tail_2 = tail_segment_2.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(144, 278).addBox(-6.0F, -5.5F, 0.0F, 12.0F, 11.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.1667F, 25.3333F));

		PartDefinition tail_3 = tail_2.addOrReplaceChild("tail_3", CubeListBuilder.create().texOffs(0, 313).addBox(-4.0F, -3.5F, -0.5F, 8.0F, 7.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 25.5F));

		PartDefinition back_left_leg = lower_torso.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(80, 278).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 30.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, 4.0F, 20.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition back_left_shin = back_left_leg.addOrReplaceChild("back_left_shin", CubeListBuilder.create().texOffs(324, 112).addBox(-6.0F, -5.0F, -6.0F, 12.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.8457F, -0.2242F, 1.0472F, 0.0F, 0.0F));

		PartDefinition back_left_foot = back_left_shin.addOrReplaceChild("back_left_foot", CubeListBuilder.create().texOffs(282, 327).addBox(-5.0F, 5.0F, -13.0F, 10.0F, 5.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.2846F, -1.3227F, -0.6545F, 0.0F, 0.0F));

		PartDefinition back_left_foot_r1 = back_left_foot.addOrReplaceChild("back_left_foot_r1", CubeListBuilder.create().texOffs(350, 0).addBox(-5.0F, -14.6071F, -7.4906F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, 2.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition back_right_leg = lower_torso.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(218, 311).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 30.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 4.0F, 20.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition back_right_shin = back_right_leg.addOrReplaceChild("back_right_shin", CubeListBuilder.create().texOffs(324, 257).addBox(-6.0F, -5.0F, -6.0F, 12.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.8457F, -0.2242F, 1.0472F, 0.0F, 0.0F));

		PartDefinition back_right_foot = back_right_shin.addOrReplaceChild("back_right_foot", CubeListBuilder.create().texOffs(332, 182).addBox(-5.0F, 5.0F, -13.0F, 10.0F, 5.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.2846F, -1.3227F, -0.6545F, 0.0F, 0.0F));

		PartDefinition back_right_foot_r1 = back_right_foot.addOrReplaceChild("back_right_foot_r1", CubeListBuilder.create().texOffs(350, 20).addBox(-5.0F, -14.6071F, -7.4906F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, 2.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition front_left_leg = upper_chest.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(66, 324).addBox(-2.0F, -4.0F, -4.0F, 12.0F, 25.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 4.0F, -5.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition front_left_shin = front_left_leg.addOrReplaceChild("front_left_shin", CubeListBuilder.create().texOffs(338, 327).addBox(-5.0F, -1.0F, -3.0F, 10.0F, 21.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 19.0681F, 0.5176F, -0.4363F, 0.0F, 0.0F));

		PartDefinition front_left_foot = front_left_shin.addOrReplaceChild("front_left_foot", CubeListBuilder.create().texOffs(114, 345).addBox(-4.0F, 0.0F, -10.0F, 10.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 19.6983F, 1.4487F, 0.1745F, 0.0F, 0.0F));

		PartDefinition front_right_leg = upper_chest.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(324, 75).addBox(-10.0F, -4.0F, -4.0F, 12.0F, 25.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 4.0F, -5.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition front_right_shin = front_right_leg.addOrReplaceChild("front_right_shin", CubeListBuilder.create().texOffs(0, 345).addBox(-5.0F, -1.0F, -3.0F, 10.0F, 21.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 19.0681F, 0.5176F, -0.4363F, 0.0F, 0.0F));

		PartDefinition front_right_foot = front_right_shin.addOrReplaceChild("front_right_foot", CubeListBuilder.create().texOffs(162, 345).addBox(-6.0F, 0.0F, -10.0F, 10.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 19.6983F, 1.4487F, 0.1745F, 0.0F, 0.0F));

		PartDefinition left_wing = upper_chest.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(16.0F, -11.0F, -5.0F));

		PartDefinition wing_segment_1 = left_wing.addOrReplaceChild("wing_segment_1", CubeListBuilder.create().texOffs(300, 166).addBox(0.0F, -4.0F, -4.0F, 38.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition second_segment_r1 = wing_segment_1.addOrReplaceChild("second_segment_r1", CubeListBuilder.create().texOffs(218, 295).addBox(-25.0F, -4.0F, -25.0F, 39.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(55.0F, 0.0F, -29.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition first_wing_r1 = wing_segment_1.addOrReplaceChild("first_wing_r1", CubeListBuilder.create().texOffs(0, 150).addBox(-60.5169F, 0.0F, -63.8218F, 40.0F, 0.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.0F, 0.0F, -25.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition wing_segment_2 = wing_segment_1.addOrReplaceChild("wing_segment_2", CubeListBuilder.create(), PartPose.offset(38.0F, 0.0F, 0.0F));

		PartDefinition second_wing_r1 = wing_segment_2.addOrReplaceChild("second_wing_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-73.5169F, 0.0F, -63.8218F, 100.0F, 0.0F, 75.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, 0.0F, -25.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition third_segment_r1 = wing_segment_2.addOrReplaceChild("third_segment_r1", CubeListBuilder.create().texOffs(244, 233).addBox(-35.5168F, -3.0F, 5.1782F, 62.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, 0.0F, -31.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition right_wing = upper_chest.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(-16.0F, -11.0F, -5.0F));

		PartDefinition wing_segment_3 = right_wing.addOrReplaceChild("wing_segment_3", CubeListBuilder.create().texOffs(282, 311).addBox(-38.0F, -4.0F, -4.0F, 38.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition first_wing_r2 = wing_segment_3.addOrReplaceChild("first_wing_r2", CubeListBuilder.create().texOffs(150, 150).addBox(20.5169F, 0.0F, -63.8218F, 40.0F, 0.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.0F, 0.0F, -25.0F, -3.1416F, 0.0F, -3.1416F));

		PartDefinition wing_segment_4 = wing_segment_3.addOrReplaceChild("wing_segment_4", CubeListBuilder.create(), PartPose.offset(-38.0F, 0.0F, 0.0F));

		PartDefinition second_wing_r2 = wing_segment_4.addOrReplaceChild("second_wing_r2", CubeListBuilder.create().texOffs(0, 75).addBox(-26.4831F, 0.0F, -63.8218F, 87.0F, 0.0F, 75.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, 0.0F, -25.0F, -3.1416F, 0.0F, -3.1416F));

		PartDefinition third_segment_r2 = wing_segment_4.addOrReplaceChild("third_segment_r2", CubeListBuilder.create().texOffs(244, 245).addBox(-26.4831F, -3.0F, 5.1782F, 62.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, 0.0F, -31.0F, -3.1416F, 0.0F, -3.1416F));

		PartDefinition second_segment_r2 = wing_segment_4.addOrReplaceChild("second_segment_r2", CubeListBuilder.create().texOffs(300, 150).addBox(-14.0F, -4.0F, -25.0F, 39.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, 0.0F, -29.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		//this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		//this.animateWalk(ModAnimationsDefinitions.Malformed_Flesh_Blob_Move_Anim, limbSwing, limbSwingAmount, 2f , 2.5f);
		this.animate(((FleshDragonEntity) entity).idleGroundAnimationState, ModAnimationsDefinitions.Flesh_Dragon_Ground_Idle_Anim, ageInTicks, 1f);
		this.animate(((FleshDragonEntity) entity).hoveringAnimationState, ModAnimationsDefinitions.Flesh_Dragon_Hovering_Anim, ageInTicks, 1f);
		this.animate(((FleshDragonEntity) entity).flyingAnimationState, ModAnimationsDefinitions.Flesh_Dragon_Flying_Anim, ageInTicks, 1f);
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