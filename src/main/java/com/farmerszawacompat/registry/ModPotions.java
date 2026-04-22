package com.farmerszawacompat.registry;

import com.farmerszawacompat.FarmersZawaCompatMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModPotions {
    public static final String POTION_BOTTLE_TEXTURE_PLACEHOLDER_FILE = "assets/fdzawacompat/textures/item/potent_skin_potion.txt";

    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, FarmersZawaCompatMod.MOD_ID);

    public static final RegistryObject<Potion> POTENT_SKIN = POTIONS.register(
            "potent_skin",
            () -> new Potion(new MobEffectInstance(ModMobEffects.POTENT_SKIN.get(), 20 * 60))
    );

    public static final RegistryObject<Potion> POTENT_SKIN_EXTENDED = POTIONS.register(
            "potent_skin_extended",
            () -> new Potion(new MobEffectInstance(ModMobEffects.POTENT_SKIN.get(), 20 * 120))
    );

    public static final RegistryObject<Potion> POTENT_SKIN_GLOWING = POTIONS.register(
            "potent_skin_glowing",
            () -> new Potion(new MobEffectInstance(ModMobEffects.POTENT_SKIN.get(), 20 * 180, 1))
    );

    private ModPotions() {
    }
}
