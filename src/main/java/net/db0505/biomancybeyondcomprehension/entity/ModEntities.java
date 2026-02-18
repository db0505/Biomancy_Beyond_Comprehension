package net.db0505.biomancybeyondcomprehension.entity;


import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
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
                    .sized(1.5f,0.5f).build("malformedfleshblob"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
