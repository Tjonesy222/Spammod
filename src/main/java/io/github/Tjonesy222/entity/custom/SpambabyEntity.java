package io.github.Tjonesy222.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

import javax.annotation.Nullable;

public class SpambabyEntity extends Monster implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public SpambabyEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }
@Override
    protected void registerGoals() {
this.goalSelector.addGoal(1,new FloatGoal(this));
    this.goalSelector.addGoal(2, new MeleeAttackGoal(this,0.5f,false));
    this.goalSelector.addGoal(3, new LeapAtTargetGoal(this,-1));
    this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

    this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class,true));
    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class,true));

}
    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH,20)
                .add(Attributes.ATTACK_DAMAGE,4).build();


    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));



    }

    private PlayState predicate(AnimationState<SpambabyEntity> spambabyEntityAnimationState) {
        if(spambabyEntityAnimationState.isMoving()) {
            spambabyEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.model.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        spambabyEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.model.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}







