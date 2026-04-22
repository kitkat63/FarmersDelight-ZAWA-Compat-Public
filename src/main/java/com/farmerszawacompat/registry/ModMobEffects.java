package com.farmerszawacompat.registry;

import com.farmerszawacompat.FarmersZawaCompatMod;
import com.farmerszawacompat.effect.PotentSkinMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModMobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, FarmersZawaCompatMod.MOD_ID);

    public static final RegistryObject<MobEffect> POTENT_SKIN = MOB_EFFECTS.register(
            "potent_skin",
            PotentSkinMobEffect::new
    );

    private ModMobEffects() {
    }
}
