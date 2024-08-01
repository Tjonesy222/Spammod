package io.github.Tjonesy222.effect;

import io.github.Tjonesy222.SpamMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

import static net.neoforged.neoforge.common.damagesource.DamageContainer.Reduction.MOB_EFFECTS;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOBEFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, SpamMod.MODID);

    //MOB_EFFECTS is a DeferredRegister<MobEffect>
    public static final Supplier<BabyMultiEffect> BabyMultiEffect = MOBEFFECTS.register("babymulieffect", () -> new BabyMultiEffect(
            //Can be either BENEFICIAL, NEUTRAL or HARMFUL. Used to determine the potion tooltip color of this effect.
            MobEffectCategory.BENEFICIAL,
            //The color of the effect particles.
            0xffffff
    ));



}