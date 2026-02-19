package net.db0505.biomancybeyondcomprehension.entity.Client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.db0505.biomancybeyondcomprehension.entity.custom.MalformedFleshBlobEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MalformedFleshBlobRenderer extends MobRenderer<MalformedFleshBlobEntity, MalformedFleshBlobModel<MalformedFleshBlobEntity>> {

    public MalformedFleshBlobRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MalformedFleshBlobModel<>(pContext.bakeLayer(ModModelLayers.MALFORMED_FLESH_BLOB_LAYER)), .5f);
    }

    @Override
    public ResourceLocation getTextureLocation(MalformedFleshBlobEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(BiomancyBeyondComprehension.MOD_ID, "textures/entity/malformedfleshblobtexture.png");
    }

    @Override
    public void render(MalformedFleshBlobEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f,0.5f,0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
