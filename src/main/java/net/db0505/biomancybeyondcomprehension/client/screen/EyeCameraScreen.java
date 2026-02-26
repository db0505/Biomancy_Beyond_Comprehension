package net.db0505.biomancybeyondcomprehension.client.screen;

import com.mojang.blaze3d.pipeline.RenderTarget;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class EyeCameraScreen extends Screen {

    private final BlockPos eyePos;
    private Button exitButton;

    private static final ResourceLocation CAMERA_TEXTURE =
            ResourceLocation.fromNamespaceAndPath("biomancybeyondcomprehension",
                    "textures/gui/camera_feed_placeholder.png");

    public EyeCameraScreen(BlockPos eyePos) {
        super(Component.literal("Camera Feed"));
        this.eyePos = eyePos;
    }

    @Override
    protected void init() {
        super.init();

        exitButton = Button.builder(Component.literal("Exit"), b -> {
            this.minecraft.setScreen(null); // close screen
        }).bounds(this.width / 2 - 50, this.height - 30, 100, 20).build();

        addRenderableWidget(exitButton);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(guiGraphics);

        // Draw placeholder camera feed
        int feedWidth = 360;
        int feedHeight = 200;
        int x = this.width / 2 - feedWidth / 2;
        int y = this.height / 2 - feedHeight / 2 - 20;

        guiGraphics.blit(CAMERA_TEXTURE, x, y, 0, 0, feedWidth, feedHeight, feedWidth, feedHeight);

        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}