package net.db0505.biomancybeyondcomprehension;

import com.mojang.logging.LogUtils;
import net.db0505.biomancybeyondcomprehension.block.ModBlocks;
import net.db0505.biomancybeyondcomprehension.block.entity.ModBlockEntities;
import net.db0505.biomancybeyondcomprehension.entity.Client.FleshWeaverRenderer;
import net.db0505.biomancybeyondcomprehension.entity.Client.MalformedFleshBlobRenderer;
import net.db0505.biomancybeyondcomprehension.entity.ModEntities;
import net.db0505.biomancybeyondcomprehension.item.ModCreativeModeTabs;
import net.db0505.biomancybeyondcomprehension.item.BeyondModItems;
import net.db0505.biomancybeyondcomprehension.network.ModNetworking;
import net.db0505.biomancybeyondcomprehension.screen.BioScryerScreen;
import net.db0505.biomancybeyondcomprehension.screen.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BiomancyBeyondComprehension.MOD_ID)
public class BiomancyBeyondComprehension
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "biomancybeyondcomprehension";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public BiomancyBeyondComprehension(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        BeyondModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        ModNetworking.register();
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(BeyondModItems.BRAIN);
            event.accept(BeyondModItems.EYE);
            event.accept(BeyondModItems.SCRYER_BRAIN);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.MalformedFleshBlob.get(), MalformedFleshBlobRenderer::new);
            EntityRenderers.register(ModEntities.FleshWeaver.get(), FleshWeaverRenderer::new);

            MenuScreens.register(ModMenuTypes.BIO_SCRYER_MENU.get(), BioScryerScreen::new);
        }
    }
}
