package com.farmerszawacompat.registry;

import com.farmerszawacompat.FarmersZawaCompatMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FarmersZawaCompatMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAIN = CREATIVE_MODE_TABS.register(
            "main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.fdzawacompat"))
                    .icon(() -> new ItemStack(ModItems.LOGO.get()))
                    .displayItems((parameters, output) -> ModItems.ITEMS.getEntries().stream()
                            .filter(item -> item != ModItems.LOGO)
                            .forEach(item -> output.accept(item.get())))
                    .build()
    );

    private ModCreativeModeTabs() {
    }
}
