package net.db0505.biomancybeyondcomprehension.network;


import net.db0505.biomancybeyondcomprehension.block.entity.ScryingEyeBlockEntity;
import net.db0505.biomancybeyondcomprehension.client.screen.EyeCameraScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ViewEyePacket {

    private final BlockPos pos;

    public ViewEyePacket(BlockPos pos) {
        this.pos = pos;
    }

    public static void encode(ViewEyePacket msg, FriendlyByteBuf buf) {
        buf.writeBlockPos(msg.pos);
    }

    public static ViewEyePacket decode(FriendlyByteBuf buf) {
        return new ViewEyePacket(buf.readBlockPos());
    }

    public static void handle(ViewEyePacket msg, Supplier<NetworkEvent.Context> ctx) {

        NetworkEvent.Context context = ctx.get();

        // THIS ensures it only runs client-side
        context.enqueueWork(() -> {

            if (context.getDirection().getReceptionSide().isClient()) {

                Minecraft mc = Minecraft.getInstance();

                if (mc.level == null)
                    return;

                BlockEntity be = mc.level.getBlockEntity(msg.pos);

                if (be instanceof ScryingEyeBlockEntity eye) {

                    mc.setScreen(new EyeCameraScreen(eye.getBlockPos()));
                }
            }
        });

        context.setPacketHandled(true);
    }
}
