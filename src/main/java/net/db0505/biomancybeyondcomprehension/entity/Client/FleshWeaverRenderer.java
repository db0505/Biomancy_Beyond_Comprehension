package net.db0505.biomancybeyondcomprehension.entity.Client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.db0505.biomancybeyondcomprehension.entity.custom.FleshWeaverEntity;
import net.db0505.biomancybeyondcomprehension.entity.custom.MalformedFleshBlobEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FleshWeaverRenderer extends MobRenderer<FleshWeaverEntity, FleshWeaverModel<FleshWeaverEntity>> {

    public FleshWeaverRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FleshWeaverModel<>(pContext.bakeLayer(ModModelLayers.FLESH_WEAVER_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(FleshWeaverEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(BiomancyBeyondComprehension.MOD_ID, "textures/entity/fleshweavertexture.png");
    }

    @Override
    public void render(FleshWeaverEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f,0.5f,0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
