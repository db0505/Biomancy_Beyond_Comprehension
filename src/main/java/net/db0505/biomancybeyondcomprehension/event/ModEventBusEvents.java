package net.db0505.biomancybeyondcomprehension.event;

import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.db0505.biomancybeyondcomprehension.entity.ModEntities;
import net.db0505.biomancybeyondcomprehension.entity.custom.FleshWeaverEntity;
import net.db0505.biomancybeyondcomprehension.entity.custom.MalformedFleshBlobEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BiomancyBeyondComprehension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MalformedFleshBlob.get(), MalformedFleshBlobEntity.createAttributes().build());
        event.put(ModEntities.FleshWeaver.get(), FleshWeaverEntity.createAttributes().build());
    }
}
