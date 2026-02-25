package net.db0505.biomancybeyondcomprehension.network;

import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModNetworking {

    private static int id = 0;

    public static final SimpleChannel CHANNEL =
            NetworkRegistry.newSimpleChannel(
                    ResourceLocation.fromNamespaceAndPath(BiomancyBeyondComprehension.MOD_ID, "main"),
                    () -> "1",
                    s -> true,
                    s -> true
            );

    public static void register() {

        CHANNEL.registerMessage(
                id++,
                ViewEyePacket.class,
                ViewEyePacket::encode,
                ViewEyePacket::decode,
                ViewEyePacket::handle
        );
    }
}
