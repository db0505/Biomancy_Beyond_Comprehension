package net.db0505.biomancybeyondcomprehension.item;

import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.db0505.biomancybeyondcomprehension.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import javax.swing.*;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BiomancyBeyondComprehension.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BEYOND_COMPREHENSION_TAB = CREATIVE_MODE_TAB.register("beyond_comprehension_tab" ,
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BRAIN.get()))
                    .title(Component.translatable("creativetab.beyond_comprehension"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BRAIN.get());
                        pOutput.accept(ModItems.EYE.get());

                        pOutput.accept(ModBlocks.MALIGNANT_OPTIC_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
