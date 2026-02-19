package net.db0505.biomancybeyondcomprehension.entity.Client;// Made with Blockbench 5.0.7

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class FleshWeaverModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("modid", "flesh_weaver"), "main");
	private final ModelPart Body;
	private final ModelPart Torso;
	private final ModelPart Head;
	private final ModelPart Leg_Left_1;
	private final ModelPart Leg_Left_2;
	private final ModelPart Leg_Left_3;
	private final ModelPart Leg_Right_3;
	private final ModelPart Leg_Right_1;
	private final ModelPart Leg_Right_2;

	public FleshWeaverModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Torso = this.Body.getChild("Torso");
		this.Head = this.Body.getChild("Head");
		this.Leg_Left_1 = this.Body.getChild("Leg_Left_1");
		this.Leg_Left_2 = this.Body.getChild("Leg_Left_2");
		this.Leg_Left_3 = this.Body.getChild("Leg_Left_3");
		this.Leg_Right_3 = this.Body.getChild("Leg_Right_3");
		this.Leg_Right_1 = this.Body.getChild("Leg_Right_1");
		this.Leg_Right_2 = this.Body.getChild("Leg_Right_2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition Torso = Body.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(-12, -7).addBox(-6.0F, -0.5209F, -15.9544F, 12.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -36.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Torso.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(-8, -6).addBox(-3.0F, 2.0F, 2.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(-9, -4).addBox(-6.0F, 1.0F, -4.0F, 12.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 19.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Torso.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(-15, -7).addBox(-9.0F, -2.0F, 4.0F, 18.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Torso.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-18, -12).addBox(-7.0F, -1.0F, -7.0F, 14.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -34.0F, 16.0F));

		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(-10, -8).addBox(-3.0F, 0.0F, -20.0F, 3.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(-3, -5).addBox(1.0F, 1.0F, -17.0F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(-10, -7).addBox(-4.0F, -1.0F, -10.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(-11, -7).addBox(-5.0F, -2.0F, -1.0F, 10.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 14.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Leg_Left_1 = Body.addOrReplaceChild("Leg_Left_1", CubeListBuilder.create(), PartPose.offsetAndRotation(14.0F, -32.0F, 13.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition cube_r4 = Leg_Left_1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(-22, -1).mirror().addBox(-6.5259F, 4.0613F, -0.9087F, 9.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 31.0F, 5.0F, -3.1416F, 0.0F, 1.5708F));

		PartDefinition cube_r5 = Leg_Left_1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(-18, -1).mirror().addBox(-12.2265F, 3.4626F, -0.9087F, 8.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 26.0F, 5.0F, -3.1416F, 0.0F, 2.0071F));

		PartDefinition cube_r6 = Leg_Left_1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(-22, -1).mirror().addBox(-3.5259F, -8.7189F, -0.0913F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.0F, 31.0F, 3.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r7 = Leg_Left_1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(-22, -1).mirror().addBox(-0.8254F, -8.1202F, -0.0913F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.0F, 26.0F, 3.0F, 0.0F, 0.0F, 1.1345F));

		PartDefinition cube_r8 = Leg_Left_1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(-20, -5).mirror().addBox(-9.0229F, -9.2322F, -3.0913F, 22.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 2.0F, 4.0F, 0.0F, 0.0F, 1.2217F));

		PartDefinition cube_r9 = Leg_Left_1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(-17, -2).mirror().addBox(-0.9297F, -8.6115F, -1.5913F, 12.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 13.0F, 4.0F, 0.0F, 0.0F, 1.5272F));

		PartDefinition cube_r10 = Leg_Left_1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(-19, -6).mirror().addBox(-7.2346F, -2.8478F, 0.0F, 22.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -3.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Leg_Left_2 = Body.addOrReplaceChild("Leg_Left_2", CubeListBuilder.create(), PartPose.offset(13.0F, -32.0F, -3.0F));

		PartDefinition cube_r11 = Leg_Left_2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(-22, -1).mirror().addBox(-6.5259F, -2.3288F, -0.5F, 9.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 31.0F, 5.0F, -3.1416F, 0.0F, 1.5708F));

		PartDefinition cube_r12 = Leg_Left_2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(-18, -1).mirror().addBox(-9.5259F, -2.3288F, -0.5F, 8.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 26.0F, 5.0F, -3.1416F, 0.0F, 2.0071F));

		PartDefinition cube_r13 = Leg_Left_2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(-22, -1).mirror().addBox(-3.5259F, -2.3288F, -0.5F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(16.0F, 31.0F, 3.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r14 = Leg_Left_2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(-22, -1).mirror().addBox(-3.5259F, -2.3288F, -0.5F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(15.0F, 26.0F, 3.0F, 0.0F, 0.0F, 1.1345F));

		PartDefinition cube_r15 = Leg_Left_2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(-23, -3).mirror().addBox(-9.2085F, -3.2275F, -2.5F, 20.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 2.0F, 4.0F, 0.0F, 0.0F, 1.2217F));

		PartDefinition cube_r16 = Leg_Left_2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(-17, -2).mirror().addBox(-1.2085F, -2.2275F, -2.0F, 12.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 13.0F, 4.0F, 0.0F, 0.0F, 1.5272F));

		PartDefinition cube_r17 = Leg_Left_2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(-9, -4).mirror().addBox(-8.0F, 1.0F, 1.0F, 16.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -7.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Leg_Left_3 = Body.addOrReplaceChild("Leg_Left_3", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, -32.0F, -18.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r18 = Leg_Left_3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(-22, -1).mirror().addBox(-6.5259F, -0.2075F, 1.6213F, 9.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 31.0F, 5.0F, -3.1416F, 0.0F, 1.5708F));

		PartDefinition cube_r19 = Leg_Left_3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(-18, -1).mirror().addBox(-10.4224F, -0.4062F, 1.6213F, 8.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 26.0F, 5.0F, -3.1416F, 0.0F, 2.0071F));

		PartDefinition cube_r20 = Leg_Left_3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(-22, -1).mirror().addBox(-3.5259F, -4.4501F, -2.6213F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.0F, 31.0F, 3.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r21 = Leg_Left_3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(-22, -1).mirror().addBox(-2.6294F, -4.2514F, -2.6213F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.0F, 26.0F, 3.0F, 0.0F, 0.0F, 1.1345F));

		PartDefinition cube_r22 = Leg_Left_3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(-20, -3).mirror().addBox(1.9313F, -5.0166F, -4.6213F, 12.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 4.0F, 4.0F, 0.0F, 0.0F, 1.0036F));

		PartDefinition cube_r23 = Leg_Left_3.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(-17, -2).mirror().addBox(0.8841F, -4.3468F, -4.1213F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 13.0F, 4.0F, 0.0F, 0.0F, 1.5272F));

		PartDefinition cube_r24 = Leg_Left_3.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(-7, -4).mirror().addBox(-5.9769F, 0.3621F, -1.1213F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition Leg_Right_3 = Body.addOrReplaceChild("Leg_Right_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, -32.0F, -18.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r25 = Leg_Right_3.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(-22, -1).addBox(-2.4741F, -0.2075F, 1.6213F, 9.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 31.0F, 5.0F, -3.1416F, 0.0F, -1.5708F));

		PartDefinition cube_r26 = Leg_Right_3.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(-18, -1).addBox(2.4224F, -0.4062F, 1.6213F, 8.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 26.0F, 5.0F, -3.1416F, 0.0F, -2.0071F));

		PartDefinition cube_r27 = Leg_Right_3.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(-22, -1).addBox(-2.4741F, -4.4501F, -2.6213F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 31.0F, 3.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r28 = Leg_Right_3.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(-22, -1).addBox(-3.3706F, -4.2514F, -2.6213F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, 26.0F, 3.0F, 0.0F, 0.0F, -1.1345F));

		PartDefinition cube_r29 = Leg_Right_3.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(-20, -3).addBox(-13.9313F, -5.0166F, -4.6213F, 12.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 4.0F, 4.0F, 0.0F, 0.0F, -1.0036F));

		PartDefinition cube_r30 = Leg_Right_3.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(-17, -2).addBox(-10.8841F, -4.3468F, -4.1213F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 13.0F, 4.0F, 0.0F, 0.0F, -1.5272F));

		PartDefinition cube_r31 = Leg_Right_3.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(-7, -4).addBox(-6.0231F, 0.3621F, -1.1213F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Leg_Right_1 = Body.addOrReplaceChild("Leg_Right_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.0F, -32.0F, 13.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition cube_r32 = Leg_Right_1.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(-22, -1).addBox(-2.4741F, 4.0613F, -0.9087F, 9.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 31.0F, 5.0F, -3.1416F, 0.0F, -1.5708F));

		PartDefinition cube_r33 = Leg_Right_1.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(-18, -1).addBox(4.2265F, 3.4626F, -0.9087F, 8.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 26.0F, 5.0F, -3.1416F, 0.0F, -2.0071F));

		PartDefinition cube_r34 = Leg_Right_1.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(-22, -1).addBox(-2.4741F, -8.7189F, -0.0913F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 31.0F, 3.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r35 = Leg_Right_1.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(-22, -1).addBox(-5.1746F, -8.1202F, -0.0913F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, 26.0F, 3.0F, 0.0F, 0.0F, -1.1345F));

		PartDefinition cube_r36 = Leg_Right_1.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(-20, -5).addBox(-12.9771F, -9.2322F, -3.0913F, 22.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 2.0F, 4.0F, 0.0F, 0.0F, -1.2217F));

		PartDefinition cube_r37 = Leg_Right_1.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(-17, -2).addBox(-11.0703F, -8.6115F, -1.5913F, 12.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 13.0F, 4.0F, 0.0F, 0.0F, -1.5272F));

		PartDefinition cube_r38 = Leg_Right_1.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(-19, -6).addBox(-14.7654F, -2.8478F, 0.0F, 22.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Leg_Right_2 = Body.addOrReplaceChild("Leg_Right_2", CubeListBuilder.create(), PartPose.offset(-13.0F, -32.0F, -3.0F));

		PartDefinition cube_r39 = Leg_Right_2.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(-22, -1).addBox(-2.4741F, -2.3288F, -0.5F, 9.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 31.0F, 5.0F, -3.1416F, 0.0F, -1.5708F));

		PartDefinition cube_r40 = Leg_Right_2.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(-18, -1).addBox(1.5259F, -2.3288F, -0.5F, 8.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 26.0F, 5.0F, -3.1416F, 0.0F, -2.0071F));

		PartDefinition cube_r41 = Leg_Right_2.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(-22, -1).addBox(-2.4741F, -2.3288F, -0.5F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 31.0F, 3.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r42 = Leg_Right_2.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(-22, -1).addBox(-2.4741F, -2.3288F, -0.5F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 26.0F, 3.0F, 0.0F, 0.0F, -1.1345F));

		PartDefinition cube_r43 = Leg_Right_2.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(-18, -3).addBox(-10.7915F, -3.2275F, -2.5F, 20.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 2.0F, 4.0F, 0.0F, 0.0F, -1.2217F));

		PartDefinition cube_r44 = Leg_Right_2.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(-17, -2).addBox(-10.7915F, -2.2275F, -2.0F, 12.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 13.0F, 4.0F, 0.0F, 0.0F, -1.5272F));

		PartDefinition cube_r45 = Leg_Right_2.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(-9, -4).addBox(-8.0F, 1.0F, 1.0F, 16.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -7.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		return LayerDefinition.create(meshdefinition, 16, 16);
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