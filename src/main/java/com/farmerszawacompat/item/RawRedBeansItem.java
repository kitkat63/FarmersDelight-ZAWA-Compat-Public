package com.farmerszawacompat.item;

import com.farmerszawacompat.block.BeanPlantBlock;
import com.farmerszawacompat.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class RawRedBeansItem extends Item {
    public RawRedBeansItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPlaceContext placeContext = new BlockPlaceContext(context);
        BlockPos clickedPos = context.getClickedPos();
        BlockState clickedState = level.getBlockState(clickedPos);
        BlockPos placePos = clickedState.canBeReplaced(placeContext)
                ? clickedPos
                : clickedPos.relative(context.getClickedFace());

        BlockState beanPlantState = ModBlocks.BEAN_PLANT.get().defaultBlockState();
        BlockState soilState = level.getBlockState(placePos.below());
        boolean isPlantableSoil = BeanPlantBlock.isValidBeanSoil(soilState);

        if (!isPlantableSoil || !level.getBlockState(placePos).canBeReplaced(placeContext) || !beanPlantState.canSurvive(level, placePos)) {
            return super.useOn(context);
        }

        ItemStack stack = context.getItemInHand();
        Player player = context.getPlayer();

        if (!level.isClientSide) {
            level.setBlock(placePos, beanPlantState, 11);
            if (player == null || !player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
