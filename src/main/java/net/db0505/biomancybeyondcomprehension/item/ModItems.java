package net.db0505.biomancybeyondcomprehension.item;

import com.github.elenterius.biomancy.init.ModRarities;
import com.github.elenterius.biomancy.init.ModTiers;
import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BiomancyBeyondComprehension.MOD_ID);

    public static final RegistryObject<Item> BRAIN = ITEMS.register("brain",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EYE = ITEMS.register("eye",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEMOCLAST_SWORD = ITEMS.register("hemoclast_sword",
            () -> new SwordItem(ModTiers.BIOFLESH, 4, -1.6f, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
