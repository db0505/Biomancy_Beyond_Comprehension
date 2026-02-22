package net.db0505.biomancybeyondcomprehension.item.custom;

import com.github.elenterius.biomancy.init.ModSoundEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;
import org.stringtemplate.v4.misc.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class ScryerBrainItem extends Item {
    public ScryerBrainItem(Properties pProperties) {
        super(pProperties);
    }

    ArrayList<Integer> scryingEyeCoords = new ArrayList<Integer>();

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        //float scryingEyeCoords;

        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();

            BlockState state = pContext.getLevel().getBlockState(positionClicked);

            if (state.is(Tags.Blocks.ORES_IRON)) {
                pContext.getLevel().playSeededSound(null, positionClicked.getX(), positionClicked.getY(), positionClicked.getZ(),
                        ModSoundEvents.BIO_LAB_CRAFTING.get(), SoundSource.BLOCKS, 1f, 1f, 0);
                player.sendSystemMessage(Component.literal("Scrying eye added"));
                scryingEyeCoords.add(positionClicked.getX());
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.literal("Right click scrying eyes to add to the neural network"));
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.literal("Used to connect up to 8 Scrying Eyes" )
                    .withStyle(ChatFormatting.GRAY));
            if (scryingEyeCoords.toArray().length >= 1) {
                for (int i = 0; i < scryingEyeCoords.size(); i++) {
                    pTooltipComponents.add(Component.literal("Eye: " + scryingEyeCoords.get(i))
                            .withStyle(ChatFormatting.GRAY));
                }
            }
            else {
                pTooltipComponents.add(Component.literal("No neural pathways")
                        .withStyle(ChatFormatting.GRAY));
            }
        }
        else {
            pTooltipComponents.add(Component.literal("Hold SHIFT for connected eyes")
                    .withStyle(ChatFormatting.YELLOW));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}

