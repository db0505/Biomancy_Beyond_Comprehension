package net.db0505.biomancybeyondcomprehension.entity.Client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.db0505.biomancybeyondcomprehension.entity.custom.FleshDragonEntity;
import net.db0505.biomancybeyondcomprehension.entity.custom.FleshWeaverEntity;
import net.db0505.biomancybeyondcomprehension.entity.custom.MalformedFleshBlobEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FleshDragonRenderer extends MobRenderer<FleshDragonEntity, FleshDragonModel<FleshDragonEntity>> {

    public FleshDragonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FleshDragonModel<>(pContext.bakeLayer(ModModelLayers.FLESH_DRAGON_LAYER)), 3f);
    }

    @Override
    public ResourceLocation getTextureLocation(FleshDragonEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(BiomancyBeyondComprehension.MOD_ID, "textures/entity/fleshdragontexture.png");
    }

    @Override
    public void render(FleshDragonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f,0.5f,0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
