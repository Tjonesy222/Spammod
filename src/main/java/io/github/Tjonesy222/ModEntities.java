package io.github.Tjonesy222;

import io.github.Tjonesy222.entity.custom.SpamProjEntity;
import io.github.Tjonesy222.entity.custom.SpambabyEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, SpamMod.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<SpambabyEntity>> SPAMBABY =
    ENTITY_TYPES.register("spambaby", () ->
            EntityType.Builder.of(SpambabyEntity::new, MobCategory.CREATURE)
                    .sized(1,1.5f)
                    .build( ResourceLocation.fromNamespaceAndPath(SpamMod.MODID,"spambaby").toString()));

    public static final DeferredHolder<EntityType<?>, EntityType<SpamProjEntity>> SPAMPROJENTITY =
            ENTITY_TYPES.register("spamprojentity", () ->
                    EntityType.Builder.<SpamProjEntity>of(SpamProjEntity::new, MobCategory.MISC)
                            .sized(.5f,.5f)
                            .build( ResourceLocation.fromNamespaceAndPath(SpamMod.MODID,"spamprojentity").toString()));






    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

