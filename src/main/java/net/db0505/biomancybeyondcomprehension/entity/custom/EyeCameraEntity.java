package net.db0505.biomancybeyondcomprehension.entity.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class EyeCameraEntity extends Entity {

    public EyeCameraEntity(ClientLevel level) {
        super(EntityType.MARKER, level);
        noPhysics = true;
    }

    @Override
    protected void defineSynchedData() {}

    @Override
    protected void readAdditionalSaveData(net.minecraft.nbt.CompoundTag tag) {}

    @Override
    protected void addAdditionalSaveData(net.minecraft.nbt.CompoundTag tag) {}

    @Override
    public void tick() {}
}
