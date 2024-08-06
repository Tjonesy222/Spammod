package io.github.Tjonesy222.entity.custom;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.VariantHolder;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
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
    this.goalSelector.addGoal(3, new MeleeAttackGoal(this,0.7f,false));
    this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.5f));
    this.goalSelector.addGoal(4, new RandomStrollGoal(this,0.7));
    this.goalSelector.addGoal(6, new JumpGoal() {
        @Override
        public boolean canUse() {
            return true;
        }

    });


    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, IronGolem.class, true));
    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Skeleton.class, true));
    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Spider.class, true));
    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Creeper.class, true));
    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Zombie.class, true));
    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Slime.class, true));
    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Witch.class, true));
    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Villager.class, true));
    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Cow.class, true));
    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Sheep.class, true));
    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Pig.class, true));
    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Chicken.class, true));
    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Wolf.class, true));

    this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class,true));

}



    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH,12)
                .add(Attributes.SCALE,.5f)
                .add(Attributes.SAFE_FALL_DISTANCE,6)
                .add(Attributes.ATTACK_DAMAGE,6).build();



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













