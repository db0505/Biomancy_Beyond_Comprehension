package net.db0505.biomancybeyondcomprehension.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

public class BioScryerScreen extends AbstractContainerScreen<BioScryerMenu> {

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(
                    BiomancyBeyondComprehension.MOD_ID,
                    "textures/gui/bio_scryer_gui.png");

    private final List<Button> eyeButtons = new ArrayList<>();

    public BioScryerScreen(
            BioScryerMenu menu,
            Inventory inv,
            Component title) {

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

        int connectedEyes = menu.getConnectedEyeCount();

        for (int i = 0; i < 10; i++) {

            int x = startX + (i % 5) * 20;
            int y = startY + (i / 5) * 20;

            final int index = i;

            Button button = Button.builder(
                            Component.literal(""),
                            b -> {

                                System.out.println("Eye button clicked: " + index);

                            })
                    .bounds(x, y, 16, 16)
                    .build();

            button.active = index < connectedEyes;

            eyeButtons.add(button);

            addRenderableWidget(button);
        }
    }

    /*
     Updates buttons live if brain changes
     */
    @Override
    public void containerTick() {

        super.containerTick();

        int connectedEyes = menu.getConnectedEyeCount();

        for (int i = 0; i < eyeButtons.size(); i++) {

            eyeButtons.get(i).active = i < connectedEyes;
        }
    }

    @Override
    protected void renderBg(
            GuiGraphics guiGraphics,
            float partialTick,
            int mouseX,
            int mouseY) {

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1,1,1,1);
        RenderSystem.setShaderTexture(0, TEXTURE);

        guiGraphics.blit(
                TEXTURE,
                leftPos,
                topPos,
                0,
                0,
                imageWidth,
                imageHeight
        );
    }

    @Override
    public void render(
            GuiGraphics guiGraphics,
            int mouseX,
            int mouseY,
            float delta) {

        renderBackground(guiGraphics);

        super.render(guiGraphics, mouseX, mouseY, delta);

        renderTooltip(guiGraphics, mouseX, mouseY);
    }

}