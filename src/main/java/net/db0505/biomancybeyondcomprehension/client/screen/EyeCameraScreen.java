package net.db0505.biomancybeyondcomprehension.client.screen;

import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.blaze3d.systems.RenderSystem;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

@OnlyIn(Dist.CLIENT)
public class EyeCameraScreen extends Screen {

    private static final ResourceLocation CAMERA_PLACEHOLDER =
            ResourceLocation.fromNamespaceAndPath("biomancybeyondcomprehension", "textures/gui/camera_feed_placeholder.png");

    private final BlockPos eyePos;
    private Button exitButton;
    private final int feedSizeWidth = 360;
    private final int feedSizeHeight = 200;

    private final Minecraft mc = Minecraft.getInstance();

    public EyeCameraScreen(BlockPos eyePos) {
        super(net.minecraft.network.chat.Component.literal("Camera Feed"));
        this.eyePos = eyePos;
    }

    @Override
    protected void init() {
        super.init();

        // Exit button
        exitButton = Button.builder(net.minecraft.network.chat.Component.literal("Exit"), b -> mc.setScreen(null))
                .bounds(this.width / 2 - 50, this.height - 30, 100, 20)
                .build();
        addRenderableWidget(exitButton);
    }

    @Override
    public void render(GuiGraphics gui, int mouseX, int mouseY, float partialTick) {
        renderBackground(gui);

        // Draw placeholder feed
        int x = this.width / 2 - feedSizeWidth / 2;
        int y = this.height / 2 - feedSizeHeight / 2;
        gui.blit(CAMERA_PLACEHOLDER, x, y, feedSizeWidth, feedSizeHeight, 0, 0, feedSizeWidth, feedSizeHeight, feedSizeWidth, feedSizeHeight);

        super.render(gui, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}