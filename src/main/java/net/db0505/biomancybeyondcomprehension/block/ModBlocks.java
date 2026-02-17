package net.db0505.biomancybeyondcomprehension.block;

import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.db0505.biomancybeyondcomprehension.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BiomancyBeyondComprehension.MOD_ID);

    // For using block behaviour from biomancy
    public static final RegistryObject<Block> MALIGNANT_OPTIC_BLOCK =
            registryBlock("malignant_optic_block",
                    () -> {
                        Block malignant_flesh = ForgeRegistries.BLOCKS.getValue(
                                ResourceLocation.fromNamespaceAndPath("biomancy", "malignant_flesh")
                        );

                        return new Block(BlockBehaviour.Properties.copy(malignant_flesh));
                    });

    public static final RegistryObject<Block> BIO_SCRYER =
            registryBlock("bio_scryer",
                    () -> {
                        Block bio_forge = ForgeRegistries.BLOCKS.getValue(
                                ResourceLocation.fromNamespaceAndPath("biomancy", "bio_forge")
                        );

                        return new Block(BlockBehaviour.Properties.copy(bio_forge));
                    });

    /*
    public static final RegistryObject<Block> BIO_SCRYER = registryBlock("bio_scryer",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)));
     */

    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends  Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
