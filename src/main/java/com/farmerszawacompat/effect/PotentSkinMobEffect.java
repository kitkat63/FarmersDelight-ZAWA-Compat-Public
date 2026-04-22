package com.farmerszawacompat.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class PotentSkinMobEffect extends MobEffect {
    public static final String EFFECT_INFO_FILE = "assets/fdzawacompat/effects/potent_skin.txt";
    public static final String EFFECT_TEXTURE_PLACEHOLDER_FILE = "assets/fdzawacompat/textures/mob_effect/potent_skin.txt";

    public PotentSkinMobEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x5AA343);
    }
}
