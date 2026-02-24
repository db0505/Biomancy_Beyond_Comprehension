package net.db0505.biomancybeyondcomprehension.item.custom;

import com.github.elenterius.biomancy.init.ModSoundEvents;
import net.db0505.biomancybeyondcomprehension.block.ModBlocks;
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
    private static final String POS_TAG = "Pos";

    private static final int MAX_EYES = 10;

    public ScryerBrainItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();

        if (level.isClientSide())
            return InteractionResult.SUCCESS;

        ItemStack stack = context.getItemInHand();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState state = level.getBlockState(pos);

        // Replace with your Scrying Eye block check
        if (!state.is(ModBlocks.SCRYING_EYE.get()))
            return InteractionResult.PASS;

        List<BlockPos> eyes = getEyes(stack);

        if (eyes.contains(pos)) {

            removeEye(stack, pos);

            player.sendSystemMessage(Component.literal("Scrying eye removed"));

        } else {

            if (eyes.size() >= MAX_EYES) {

                player.sendSystemMessage(Component.literal("Neural capacity reached"));

                return InteractionResult.FAIL;
            }

            addEye(stack, pos);

            level.playSound(
                    null,
                    pos,
                    ModSoundEvents.BIO_LAB_CRAFTING.get(),
                    SoundSource.BLOCKS,
                    1f,
                    1f
            );

            player.sendSystemMessage(Component.literal("Scrying eye added"));
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(
            ItemStack stack,
            @Nullable Level level,
            List<Component> tooltip,
            TooltipFlag flag) {

        tooltip.add(Component.literal(
                "Right click scrying eyes to add to the neural network"));

        if (Screen.hasShiftDown()) {

            tooltip.add(Component.literal(
                            "Used to connect up to 10 Scrying Eyes")
                    .withStyle(ChatFormatting.GRAY));

            List<BlockPos> eyes = getEyes(stack);

            if (eyes.isEmpty()) {

                tooltip.add(Component.literal("No neural pathways")
                        .withStyle(ChatFormatting.GRAY));

            } else {

                for (BlockPos pos : eyes) {

                    tooltip.add(Component.literal(
                                    "Eye: "
                                            + pos.getX() + " "
                                            + pos.getY() + " "
                                            + pos.getZ())
                            .withStyle(ChatFormatting.GRAY));
                }
            }

        } else {

            tooltip.add(Component.literal(
                            "Hold SHIFT for connected eyes")
                    .withStyle(ChatFormatting.YELLOW));
        }

        super.appendHoverText(stack, level, tooltip, flag);
    }

    public static void addEye(ItemStack stack, BlockPos pos) {

        CompoundTag tag = stack.getOrCreateTag();

        ListTag list = tag.getList(EYES_TAG, Tag.TAG_COMPOUND);

        CompoundTag posTag = new CompoundTag();

        posTag.putLong(POS_TAG, pos.asLong());

        list.add(posTag);

        tag.put(EYES_TAG, list);
    }

    public static void removeEye(ItemStack stack, BlockPos pos) {

        CompoundTag tag = stack.getOrCreateTag();

        ListTag list = tag.getList(EYES_TAG, Tag.TAG_COMPOUND);

        ListTag newList = new ListTag();

        for (Tag t : list) {

            CompoundTag posTag = (CompoundTag) t;

            if (posTag.getLong(POS_TAG) != pos.asLong()) {

                newList.add(posTag);
            }
        }

        tag.put(EYES_TAG, newList);
    }

    public static List<BlockPos> getEyes(ItemStack stack) {

        List<BlockPos> result = new ArrayList<>();

        if (!stack.hasTag())
            return result;

        ListTag list = stack.getTag().getList(EYES_TAG, Tag.TAG_COMPOUND);

        for (Tag t : list) {

            CompoundTag posTag = (CompoundTag) t;

            result.add(BlockPos.of(posTag.getLong(POS_TAG)));
        }

        return result;
    }

    public static int getEyeCount(ItemStack stack) {

        if (!stack.hasTag())
            return 0;

        return stack.getTag()
                .getList(EYES_TAG, Tag.TAG_COMPOUND)
                .size();
    }

}

