package io.github.Tjonesy222.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class SpambabyEntity extends Monster {
    protected SpambabyEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }
@Override
    protected void registerGoals() {
this.goalSelector.addGoal(1,new FloatGoal(this));
    this.goalSelector.addGoal(2, new MeleeAttackGoal(this,1.2D,false));

}
    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH,12).build();
    }

}







