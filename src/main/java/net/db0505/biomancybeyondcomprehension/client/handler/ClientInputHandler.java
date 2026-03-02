package net.db0505.biomancybeyondcomprehension.client.handler;

import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.db0505.biomancybeyondcomprehension.client.ModKeyBindings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BiomancyBeyondComprehension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientInputHandler {
    @SubscribeEvent
    public static void registerkeys(RegisterKeyMappingsEvent event) {
        event.register(ModKeyBindings.INSTANCE.FlyUp);
        event.register(ModKeyBindings.INSTANCE.FlyDown);
    }
}
