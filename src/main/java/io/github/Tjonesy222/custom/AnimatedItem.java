package io.github.Tjonesy222.custom;

import io.github.Tjonesy222.entity.custom.SpamProjEntity;
import io.github.Tjonesy222.init.client.AnimatedItemRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.RenderUtil;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static net.minecraft.world.item.BowItem.getPowerForTime;

public class AnimatedItem extends BowItem implements GeoItem {
//item proporties


    public void adjustAttributes(ItemAttributeModifierEvent event) {
        ItemStack stack = event.getItemStack();
        event.addModifier(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, getDamage(stack) - 1, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);

    }

    public void onUseTick(@Nonnull Level world, @Nonnull LivingEntity player, @Nonnull ItemStack stack, int timeLeft) {
      {
            player.stopUsingItem();
            stack.releaseUsing(world, player, 1200);
            player.startUsingItem(player.getUsedItemHand());
        }
    }

    public float getUseTick(@Nonnull ItemStack stack) {
        float useTick = 200.0F;

        {
            useTick -= 200.0f;
        }
        return useTick;
    }


    protected void shoot(@NotNull ServerLevel world, @NotNull LivingEntity entity, @NotNull InteractionHand hand, @NotNull ItemStack bow, @NotNull List<ItemStack> potentialAmmo, float velocity, float inaccuracy, boolean critical, @Nullable LivingEntity target) {
        super.shoot(world, entity, hand, bow, potentialAmmo, velocity, inaccuracy, critical, target);
    }



    @Override
    public AbstractArrow customArrow(AbstractArrow arrow, ItemStack projectileStack, ItemStack weaponStack) {
        return new SpamProjEntity(arrow.level(), arrow.getX(), arrow.getY(), arrow.getZ(), projectileStack);
    }







//item proporties


    //animation stuff
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public AnimatedItem(Properties properties) {
        super(properties);
    }



    private PlayState predicate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("animation.model.spin", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private AnimatedItemRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new AnimatedItemRenderer();

                return this.renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object itemStack) {
        return RenderUtil.getCurrentTick();
    }
}




