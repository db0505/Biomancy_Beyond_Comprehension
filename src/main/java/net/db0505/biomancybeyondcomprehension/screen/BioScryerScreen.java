package net.db0505.biomancybeyondcomprehension.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.db0505.biomancybeyondcomprehension.client.screen.EyeCameraScreen;
import net.db0505.biomancybeyondcomprehension.network.ModNetworking;
import net.db0505.biomancybeyondcomprehension.network.ViewEyePacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.ArrayList;
import java.util.List;

public class BioScryerScreen extends AbstractContainerScreen<BioScryerMenu> {

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(
                    BiomancyBeyondComprehension.MOD_ID,
                    "textures/gui/bio_scryer_gui.png");

    private final List<Button> eyeButtons = new ArrayList<>();

    public BioScryerScreen(BioScryerMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        imageHeight = 219;
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;

        createEyeButtons();
    }

    private void createEyeButtons() {
        eyeButtons.clear();

        int startX = leftPos + 40;
        int startY = topPos + 50;

        // Always create 10 buttons
        for (int i = 0; i < 10; i++) {
            int x = startX + (i % 5) * 20;
            int y = startY + (i / 5) * 20;
            final int index = i;

            Button button = Button.builder(Component.literal(""),
                    b -> {
                        List<BlockPos> eyes = menu.getEyePositions();
                        if (index < eyes.size()) {
                            // Open the camera feed for this eye
                            BlockPos eyePos = eyes.get(index);
                            Minecraft.getInstance().setScreen(new EyeCameraScreen(eyePos));
                        };
                    }).bounds(x, y, 16, 16).build();

            eyeButtons.add(button);
            addRenderableWidget(button);
        }
    }

    @Override
    public void containerTick() {
        super.containerTick();

        List<BlockPos> eyes = menu.getEyePositions();

        // Update button state & appearance
        for (int i = 0; i < eyeButtons.size(); i++) {
            Button button = eyeButtons.get(i);

            // Active only if there is a connected eye
            button.active = i < eyes.size();

            // Optional: could add color highlighting here if desired
        }
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, TEXTURE);
        guiGraphics.blit(TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}