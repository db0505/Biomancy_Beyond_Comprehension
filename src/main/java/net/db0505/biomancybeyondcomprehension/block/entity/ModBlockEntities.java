package net.db0505.biomancybeyondcomprehension.block.entity;

import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.db0505.biomancybeyondcomprehension.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BiomancyBeyondComprehension.MOD_ID);

    public static final RegistryObject<BlockEntityType<BioScryerBlockEntity>> BIO_SCRYER_BE =
            BLOCK_ENTITIES.register("bio_scryer_be", () ->
                    BlockEntityType.Builder.of(BioScryerBlockEntity::new,
                            ModBlocks.BIO_SCRYER.get()).build(null));

    public static final RegistryObject<BlockEntityType<ScryingEyeBlockEntity>> SCRYING_EYE_BE =
            BLOCK_ENTITIES.register("scrying_eye_be", () ->
                    BlockEntityType.Builder.of(ScryingEyeBlockEntity::new,
                            ModBlocks.SCRYING_EYE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
