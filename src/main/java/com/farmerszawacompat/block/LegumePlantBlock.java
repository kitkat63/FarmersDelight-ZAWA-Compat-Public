package com.farmerszawacompat.block;

import com.farmerszawacompat.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import org.jetbrains.annotations.NotNull;

public class LegumePlantBlock extends BushBlock implements BonemealableBlock {
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

    private static final VoxelShape SAPLING_SHAPE = box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    private static final VoxelShape MID_GROWTH_SHAPE = box(1.0D, 0.0D, 1.0D, 15.0D, 13.0D, 15.0D);

    public LegumePlantBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        int age = state.getValue(AGE);
        if (age == 0) {
            return SAPLING_SHAPE;
        }
        return age < MAX_AGE ? MID_GROWTH_SHAPE : super.getShape(state, level, pos, context);
    }

    @Override
    public boolean isRandomlyTicking(@NotNull BlockState state) {
        return state.getValue(AGE) < MAX_AGE;
    }

    @Override
    public void randomTick(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        int age = state.getValue(AGE);
        if (age < MAX_AGE && level.getRawBrightness(pos.above(), 0) >= 9
                && ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt(5) == 0)) {
            BlockState grownState = state.setValue(AGE, age + 1);
            level.setBlock(pos, grownState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(grownState));
            ForgeHooks.onCropsGrowPost(level, pos, state);
        }
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos,
                                          @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (state.getValue(AGE) < MAX_AGE && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        }

        if (state.getValue(AGE) >= MAX_AGE) {
            int dropCount = 1 + level.random.nextInt(3);
            popResource(level, pos, new net.minecraft.world.item.ItemStack(ModItems.RAW_RED_BEANS.get(), dropCount));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F,
                    0.8F + level.random.nextFloat() * 0.4F);

            BlockState resetState = state.setValue(AGE, 0);
            level.setBlock(pos, resetState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, resetState));
            return InteractionResult.sidedSuccess(level.isClientSide());
        }

        return super.use(state, level, pos, player, hand, hit);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient) {
        return state.getValue(AGE) < MAX_AGE;
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, BlockState state) {
        int nextAge = Math.min(MAX_AGE, state.getValue(AGE) + 1);
        level.setBlock(pos, state.setValue(AGE, nextAge), 2);
    }
}
