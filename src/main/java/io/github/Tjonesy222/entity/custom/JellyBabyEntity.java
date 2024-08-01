package io.github.Tjonesy222.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

public class JellyBabyEntity extends Monster implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public JellyBabyEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }



    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1,new FloatGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this,0.4f,false));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.5f));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this,0.4));
        this.goalSelector.addGoal(6, new JumpGoal() {
            @Override
            public boolean canUse() {
                return true;
            }

        });

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class,true));

    }
    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH,24)
                .add(Attributes.SCALE,.75f)
                .add(Attributes.SAFE_FALL_DISTANCE,6)
                .add(Attributes.ATTACK_DAMAGE,4).build();



    }











    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));



    }

    private PlayState predicate(AnimationState<JellyBabyEntity> JellyBabyAnimationState) {
        if(JellyBabyAnimationState.isMoving()) {
            JellyBabyAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.model.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        JellyBabyAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.model.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}