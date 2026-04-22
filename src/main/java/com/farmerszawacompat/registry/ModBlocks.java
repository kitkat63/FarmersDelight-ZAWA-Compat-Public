package com.farmerszawacompat.registry;

import com.farmerszawacompat.FarmersZawaCompatMod;
import com.farmerszawacompat.block.BeanPlantBlock;
import com.farmerszawacompat.block.LegumePlantBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FarmersZawaCompatMod.MOD_ID);

    public static final RegistryObject<Block> BEAN_PLANT = BLOCKS.register(
            "bean_plant",
            () -> new BeanPlantBlock(Block.Properties.copy(Blocks.WHEAT))
    );

    public static final RegistryObject<Block> LEGUME_BUSH = BLOCKS.register(
            "legume_bush",
            () -> new LegumePlantBlock(Block.Properties.copy(Blocks.SWEET_BERRY_BUSH).randomTicks().noOcclusion())
    );

    private ModBlocks() {
    }
}
