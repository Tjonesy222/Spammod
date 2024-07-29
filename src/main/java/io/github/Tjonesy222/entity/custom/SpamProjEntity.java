package io.github.Tjonesy222.entity.custom;

import io.github.Tjonesy222.ModEntities;
import io.github.Tjonesy222.custom.SpamProjItem;
import io.github.Tjonesy222.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

import javax.xml.transform.Result;

public class SpamProjEntity extends ThrowableItemProjectile implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public SpamProjEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemInit.SPAMBALL.get();
    }


    public SpamProjEntity(Level level) {
        super(ModEntities.SPAMPROJENTITY.get(), level);
    }

    public SpamProjEntity(Level level, LivingEntity livingEntity) {
            super(ModEntities.SPAMPROJENTITY.get(), livingEntity, level);
        }







    @Override
    protected void onHitBlock(BlockHitResult result) {
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this,((byte) 3));
            this.clearFire();



        }


         super.onHitBlock(result);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));


    }

    private PlayState predicate(AnimationState<SpamProjEntity> spamProjEntityAnimationState) {
        spamProjEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.model.spin", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}

