package io.github.Tjonesy222.entity.custom;

import io.github.Tjonesy222.ModEntities;
import io.github.Tjonesy222.custom.SpamProjItem;
import io.github.Tjonesy222.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.neoforged.neoforge.event.EventHooks;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

import javax.xml.transform.Result;

public class SpamProjEntity extends AbstractArrow implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public SpamProjEntity(EntityType<? extends SpamProjEntity> entityType, Level level, ItemStack itemStack) {
        super(entityType, level);
    }
    public SpamProjEntity(Level level, double x, double y, double z, ItemStack itemStack) {
        super(ModEntities.SPAMPROJENTITY.get(), x, y, z, level, itemStack, (ItemStack)null);
    }

    public SpamProjEntity(EntityType<SpamProjEntity> entityType, Level level) {
        this(entityType, level, new ItemStack(Items.ARROW));
    }

    public void tick() {
        super.tick();
//200 should be enough to hit somthing
        if (this.tickCount > 0) {
            this.setNoGravity(false);
            if(inGround) kill();




        }
    }


    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(Items.ARROW);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(!this.level().isClientSide()){
            this.level().broadcastEntityEvent(this,((byte) 3));
            result.getEntity().hurt(this.damageSources().magic(),10f);
            boolean flag = !EventHooks.canEntityGrief(this.level(), this.getOwner());
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, flag, Level.ExplosionInteraction.MOB);
            this.discard();

        }



        super.onHitEntity(result);
    }
    private int explosionPower = 2;

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if(!this.level().isClientSide()){
            this.level().broadcastEntityEvent(this,((byte) 3));
            boolean flag = !EventHooks.canEntityGrief(this.level(), this.getOwner());
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, flag, Level.ExplosionInteraction.MOB);
            this.discard();





        super.onHitBlock(result);
    }
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

