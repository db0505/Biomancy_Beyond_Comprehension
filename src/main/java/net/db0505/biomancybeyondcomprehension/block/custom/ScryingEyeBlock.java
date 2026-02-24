package net.db0505.biomancybeyondcomprehension.block.custom;

import net.db0505.biomancybeyondcomprehension.block.entity.ModBlockEntities;
import net.db0505.biomancybeyondcomprehension.block.entity.ScryingEyeBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class ScryingEyeBlock extends BaseEntityBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    private static final VoxelShape SHAPE_NORTH = Block.box(3, 3, 0, 13, 13, 2);
    private static final VoxelShape SHAPE_SOUTH = Block.box(3, 3, 14, 13, 13, 16);
    private static final VoxelShape SHAPE_WEST  = Block.box(0, 3, 3, 2, 13, 13);
    private static final VoxelShape SHAPE_EAST  = Block.box(14, 3, 3, 16, 13, 13);

    public ScryingEyeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH));
    }

    // shape
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        return switch (facing) {
            case NORTH -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case WEST  -> SHAPE_WEST;
            case EAST  -> SHAPE_EAST;
            default -> SHAPE_NORTH;
        };
    }

    // use model json
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    // placement logic (ONLY walls)
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {

        Direction face = context.getClickedFace().getOpposite();

        // prevent floor or ceiling placement
        if (face.getAxis().isVertical()) {
            return null;
        }

        return this.defaultBlockState()
                .setValue(FACING, face);
    }

    // break if supporting block is removed
    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        Direction facing = state.getValue(FACING).getOpposite();

        if (direction == facing.getOpposite()) {
            if (!neighborState.isFaceSturdy(level, neighborPos, facing)) {
                return Blocks.AIR.defaultBlockState();
            }
        }

        return state;
    }

    // register property
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<
            net.minecraft.world.level.block.Block, BlockState> builder) {

        builder.add(FACING);
    }

    // block entity creation
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ScryingEyeBlockEntity(pos, state);
    }

    // ticker
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (level.isClientSide) {
            return null;
        }

        return createTickerHelper(type, ModBlockEntities.SCRYING_EYE_BE.get(),
                (lvl, pos, st, be) ->
                        ((ScryingEyeBlockEntity) be).tick(lvl, pos, st)
        );
    }

}