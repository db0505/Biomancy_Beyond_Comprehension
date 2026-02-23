package net.db0505.biomancybeyondcomprehension.item.custom;

import com.github.elenterius.biomancy.init.ModSoundEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.LongTag;
import net.minecraft.nbt.Tag;
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

    private static final String EYES_TAG = "ConnectedEyes";
    private static final int MAX_EYES = 10;

    public ScryerBrainItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();

        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        ItemStack stack = context.getItemInHand();
        BlockPos clickedPos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState state = level.getBlockState(clickedPos);

        if (!state.is(Tags.Blocks.ORES_IRON)) {
            return InteractionResult.PASS;
        }

        List<BlockPos> eyes = getEyes(stack);

        if (eyes.contains(clickedPos)) {
            removeEye(stack, clickedPos);
            player.sendSystemMessage(Component.literal("Scrying eye removed"));
        } else {
            if (eyes.size() >= MAX_EYES) {
                player.sendSystemMessage(Component.literal("Neural capacity reached"));
                return InteractionResult.FAIL;
            }

            addEye(stack, clickedPos);

            level.playSound(null,
                    clickedPos,
                    ModSoundEvents.BIO_LAB_CRAFTING.get(),
                    SoundSource.BLOCKS,
                    1f,
                    1f);

            player.sendSystemMessage(Component.literal("Scrying eye added"));
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {

        tooltip.add(Component.literal("Right click scrying eyes to add to the neural network"));

        if (Screen.hasShiftDown()) {

            tooltip.add(Component.literal("Used to connect up to 10 Scrying Eyes")
                    .withStyle(ChatFormatting.GRAY));

            List<BlockPos> eyes = getEyes(stack);

            if (!eyes.isEmpty()) {
                for (BlockPos pos : eyes) {
                    tooltip.add(Component.literal(
                                    "Eye: " + pos.getX() + " "
                                            + pos.getY() + " "
                                            + pos.getZ())
                            .withStyle(ChatFormatting.GRAY));
                }
            } else {
                tooltip.add(Component.literal("No neural pathways")
                        .withStyle(ChatFormatting.GRAY));
            }

        } else {
            tooltip.add(Component.literal("Hold SHIFT for connected eyes")
                    .withStyle(ChatFormatting.YELLOW));
        }

        super.appendHoverText(stack, level, tooltip, flag);
    }

    public static void addEye(ItemStack stack, BlockPos pos) {
        CompoundTag tag = stack.getOrCreateTag();
        ListTag list = tag.getList(EYES_TAG, Tag.TAG_LONG);

        list.add(LongTag.valueOf(pos.asLong()));
        tag.put(EYES_TAG, list);
    }

    public static void removeEye(ItemStack stack, BlockPos pos) {
        CompoundTag tag = stack.getOrCreateTag();
        ListTag list = tag.getList(EYES_TAG, Tag.TAG_LONG);

        ListTag newList = new ListTag();

        for (Tag t : list) {
            long value = ((LongTag) t).getAsLong();
            if (value != pos.asLong()) {
                newList.add(LongTag.valueOf(value));
            }
        }

        tag.put(EYES_TAG, newList);
    }

    public static List<BlockPos> getEyes(ItemStack stack) {
        List<BlockPos> result = new ArrayList<>();

        if (!stack.hasTag()) return result;

        ListTag list = stack.getTag().getList(EYES_TAG, Tag.TAG_LONG);

        for (Tag t : list) {
            result.add(BlockPos.of(((LongTag) t).getAsLong()));
        }

        return result;
    }

    public static int getEyeCount(ItemStack stack) {
        return getEyes(stack).size();
    }
}

