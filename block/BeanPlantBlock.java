package com.farmerszawacompat.block;

import com.farmerszawacompat.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.registries.ForgeRegistries;

public class BeanPlantBlock extends CropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;

    public BeanPlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.RAW_RED_BEANS.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 6;
    }

    @Override
    protected int getBonemealAgeIncrease(net.minecraft.world.level.Level level) {
        return 1;
    }

    @Override
    public boolean isBonemealSuccess(net.minecraft.world.level.Level level, RandomSource random, BlockPos pos, BlockState state) {
        return random.nextFloat() < 0.9F;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return isValidBeanSoil(state);
    }

    public static boolean isValidBeanSoil(BlockState state) {
        if (state.is(Blocks.FARMLAND)) {
            return true;
        }

        ResourceLocation blockId = ForgeRegistries.BLOCKS.getKey(state.getBlock());
        if (blockId == null || !"farmersdelight".equals(blockId.getNamespace())) {
            return false;
        }

        String path = blockId.getPath();
        return path.contains("rich_soil") && (path.contains("farmland") || path.contains("tilled"));
    }
}
