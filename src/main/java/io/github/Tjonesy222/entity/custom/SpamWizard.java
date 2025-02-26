package io.github.Tjonesy222.entity.custom;

import io.github.Tjonesy222.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.animation.AnimationState;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

import static org.openjdk.nashorn.internal.objects.NativeSet.add;

public class SpamWizard extends AbstractSkeleton implements RangedAttackMob, GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private static final int HARD_ATTACK_INTERVAL = 20;
    private static final int NORMAL_ATTACK_INTERVAL = 40;
    private final RangedBowAttackGoal<AbstractSkeleton> bowGoal = new RangedBowAttackGoal(this, .3f, 1000, 25.0F);
    private final MeleeAttackGoal meleeGoal = new MeleeAttackGoal(this, .3f, false) {
        public void stop() {
            super.stop();
            SpamWizard.this.setAggressive(false);
        }

        public void start() {
            super.start();
            SpamWizard.this.setAggressive(true);
        }
    };








    public SpamWizard(EntityType<? extends AbstractSkeleton> entityType, Level level) {
        super(entityType, level);
        this.reassessWeaponGoal();
    }


    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this,.4f));
        this.goalSelector.addGoal(3, new AvoidEntityGoal(this, Wolf.class, 6.0F, .3f, .3f));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, true));
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

    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH,24)
                .add(Attributes.SCALE,1)
                .add(Attributes.SAFE_FALL_DISTANCE,6).build();





    }

    public void playStepSound(BlockPos pos, BlockState block) {
        this.playSound(this.getStepSound(), 0.4F, -2.0F);
    }


    protected SoundEvent getStepSound() {
        return SoundEvents.SALMON_HURT;
    }






    protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(random, difficulty);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack((ItemLike) ItemInit.SPAMSTAFF));
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        spawnGroupData = super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        RandomSource randomsource = level.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, difficulty);
        this.populateDefaultEquipmentEnchantments(level, randomsource, difficulty);
        this.reassessWeaponGoal();
        this.setCanPickUpLoot(randomsource.nextFloat() < 0.55F * difficulty.getSpecialMultiplier());
        if (this.getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
            LocalDate localdate = LocalDate.now();
            int i = localdate.get(ChronoField.DAY_OF_MONTH);
            int j = localdate.get(ChronoField.MONTH_OF_YEAR);
            if (j == 10 && i == 31 && randomsource.nextFloat() < 0.25F) {
                this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(randomsource.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
                this.armorDropChances[EquipmentSlot.HEAD.getIndex()] = 0.0F;
            }
        }

        return spawnGroupData;
    }

    public void reassessWeaponGoal() {
        if (this.level() != null && !this.level().isClientSide) {
            this.goalSelector.removeGoal(this.meleeGoal);
            this.goalSelector.removeGoal(this.bowGoal);
            ItemStack itemstack = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, (item) -> item instanceof BowItem));
            if (itemstack.is(ItemInit.SPAMSTAFF)) {
                int i = this.getHardAttackInterval();
                if (this.level().getDifficulty() != Difficulty.HARD) {
                    i = this.getAttackInterval();
                }

                this.bowGoal.setMinAttackInterval(i);
                this.goalSelector.addGoal(4, this.bowGoal);
            }


        }

    }

    protected int getHardAttackInterval() {
        return 110;
    }

    protected int getAttackInterval() {
        return 120;
    }

    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        ItemStack weapon = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, (item) -> {
            return item instanceof BowItem;
        }));
        ItemStack itemstack1 = this.getProjectile(weapon);
        AbstractArrow abstractarrow = this.getArrow(itemstack1, distanceFactor, weapon);
        Item var7 = weapon.getItem();
        if (var7 instanceof ProjectileWeaponItem weaponItem) {
            abstractarrow = weaponItem.customArrow(abstractarrow, itemstack1, weapon);
        }

        double d0 = target.getX() - this.getX();
        double d1 = target.getY(0.3333333333333333) - abstractarrow.getY();
        double d2 = target.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        abstractarrow.shoot(d0, d1 + d3 * 0.20000000298023224, d2, 1.6F, (float)(14 - this.level().getDifficulty().getId() * 4));
        this.playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(abstractarrow);
    }

    public AbstractArrow customArrow(AbstractArrow arrow, ItemStack projectileStack, ItemStack weaponStack) {
        return ProjectileUtil.getMobArrow(this, projectileStack,  .3f, weaponStack);
    }

    public boolean canFireProjectileWeapon(ProjectileWeaponItem projectileWeapon) {
        return projectileWeapon == ItemInit.SPAMSTAFF.value();
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.reassessWeaponGoal();
    }

    public void setItemSlot(EquipmentSlot slot, ItemStack stack) {
        super.setItemSlot(slot, stack);
        if (!this.level().isClientSide) {
            this.reassessWeaponGoal();
        }

    }

    @Override
    protected boolean isSunBurnTick() {
        return false;
    }

    //animations//
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));

    }


    private PlayState predicate(AnimationState<SpamWizard> SpamwizardAnimationState) {
        if(SpamwizardAnimationState.isMoving()) {
            SpamwizardAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.model.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        SpamwizardAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.model.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }




    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
