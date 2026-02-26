package net.db0505.biomancybeyondcomprehension.client.camera;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Marker;
import net.minecraft.world.phys.Vec3;

public class CameraEntity extends Marker {

    public CameraEntity(ClientLevel level, Vec3 pos, float yaw, float pitch) {
        super(EntityType.MARKER, level);

        this.setPos(pos);
        this.setYRot(yaw);
        this.setXRot(pitch);
    }

    @Override
    public boolean isInvisible() {
        return true;
    }
}
