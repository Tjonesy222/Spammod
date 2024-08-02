package io.github.Tjonesy222.entity.custom;

import io.github.Tjonesy222.ModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component.Serializer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.world.BossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;

import software.bernie.geckolib.animation.*;

import javax.annotation.Nullable;

public class JellyBabyEntity extends Monster implements GeoEntity {
    private final ServerBossEvent bossEvent = (ServerBossEvent)new ServerBossEvent(
            this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS
    )
            .setDarkenScreen(true);

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);


    public JellyBabyEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.setHealth(this.getMaxHealth());

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
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }


    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide()) {
            this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        }
    }


    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);

    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }

    @Override
    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.bossEvent.setName(this.getDisplayName());
    }


//Spawn Spambabys on death//
    @Override
    public void die(DamageSource cause) {
        super.die(cause);

        if (!this.level().isClientSide) {
            ServerLevel serverLevel = (ServerLevel) this.level();
            int numberOfBabys = 3;

            for (int i = 0; i < numberOfBabys; i++) {
                SpambabyEntity spambaby = ModEntities.SPAMBABY.get().create(serverLevel);
                if (spambaby != null) {
                    spambaby.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot() + 0.5f, this.getXRot());
                    serverLevel.addFreshEntity(spambaby);
                }
            }
        }
    }
    //Spawn Spambabys on death//

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