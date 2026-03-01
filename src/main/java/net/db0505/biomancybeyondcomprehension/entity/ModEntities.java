package net.db0505.biomancybeyondcomprehension.entity;


import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.db0505.biomancybeyondcomprehension.entity.custom.FleshDragonEntity;
import net.db0505.biomancybeyondcomprehension.entity.custom.FleshWeaverEntity;
import net.db0505.biomancybeyondcomprehension.entity.custom.MalformedFleshBlobEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BiomancyBeyondComprehension.MOD_ID);

    public static final RegistryObject<EntityType<MalformedFleshBlobEntity>> MalformedFleshBlob =
            ENTITY_TYPES.register("malformedfleshblob", () -> EntityType.Builder.of(MalformedFleshBlobEntity::new, MobCategory.CREATURE)
                    .sized(1f,0.5f).build("malformedfleshblob"));

    public static final RegistryObject<EntityType<FleshWeaverEntity>> FleshWeaver =
            ENTITY_TYPES.register("fleshweaver", () -> EntityType.Builder.of(FleshWeaverEntity::new, MobCategory.CREATURE)
                    .sized(2.5f,3f).build("fleshweaver"));

    public static final RegistryObject<EntityType<FleshDragonEntity>> FleshDragon =
            ENTITY_TYPES.register("fleshdragon", () -> EntityType.Builder.of(FleshDragonEntity::new, MobCategory.CREATURE)
                    .sized(2.5f,3f).build("fleshdragon"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
