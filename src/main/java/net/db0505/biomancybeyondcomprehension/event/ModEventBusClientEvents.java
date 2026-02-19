package net.db0505.biomancybeyondcomprehension.event;

import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.db0505.biomancybeyondcomprehension.entity.Client.FleshWeaverModel;
import net.db0505.biomancybeyondcomprehension.entity.Client.MalformedFleshBlobModel;
import net.db0505.biomancybeyondcomprehension.entity.Client.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BiomancyBeyondComprehension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.MALFORMED_FLESH_BLOB_LAYER, MalformedFleshBlobModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.FLESH_WEAVER_LAYER, FleshWeaverModel::createBodyLayer);

    }
}

