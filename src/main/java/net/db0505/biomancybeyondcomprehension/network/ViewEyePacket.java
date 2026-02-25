package net.db0505.biomancybeyondcomprehension.network;


import net.db0505.biomancybeyondcomprehension.client.screen.EyeCameraScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ViewEyePacket {

    private final BlockPos pos;

    public ViewEyePacket(BlockPos pos) {
        this.pos = pos;
    }

    public static void encode(ViewEyePacket pkt, FriendlyByteBuf buf) {
        buf.writeBlockPos(pkt.pos);
    }

    public static ViewEyePacket decode(FriendlyByteBuf buf) {
        return new ViewEyePacket(buf.readBlockPos());
    }

    public static void handle(ViewEyePacket msg, Supplier<NetworkEvent.Context> ctx) {

        ctx.get().enqueueWork(() -> {
            // Only run client-side
            if (ctx.get().getDirection().getReceptionSide().isClient()) {
                DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                    Minecraft mc = Minecraft.getInstance();
                    if (mc != null) {
                        mc.setScreen(new EyeCameraScreen(msg.pos));
                    }
                });
            }
        });

        ctx.get().setPacketHandled(true);
    }

    public BlockPos getPos() {
        return pos;
    }
}
