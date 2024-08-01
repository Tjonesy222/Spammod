package io.github.Tjonesy222.effect;

import com.google.common.annotations.VisibleForTesting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;


public class BabyMultiEffect extends MobEffect {
    private static final int RADIUS_TO_CHECK_SLIMES = 2;
    public static final int SLIME_SIZE = 2;
        public BabyMultiEffect(MobEffectCategory category, int color) {
            super(category, color);

        }

        @Override
        public boolean applyEffectTick(LivingEntity entity, int amplifier) {




            // Apply your effect logic here.








            // If this returns false when shouldApplyEffectTickThisTick returns true, the effect will immediately be removed
            return true;
        }

        // Whether the effect should apply this tick. Used e.g. by the Regeneration effect that only applies
        // once every x ticks, depending on the tick count and amplifier.
        @Override
        public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
            return tickCount % 2 == 0; // replace this with whatever check you want
        }

        // Utility method that is called when the effect is first added to the entity.
        // This does not get called again until all instances of this effect have been removed from the entity.
        @Override
        public void onEffectAdded(LivingEntity entity, int amplifier) {
            super.onEffectAdded(entity, amplifier);
        }

        // Utility method that is called when the effect is added to the entity.
        // This gets called every time this effect is added to the entity.
        @Override
        public void onEffectStarted(LivingEntity entity, int amplifier){
                    }}