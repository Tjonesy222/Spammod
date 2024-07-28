package io.github.Tjonesy222;

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
                    .sized(1.5f,1.75f)
                    .build( ResourceLocation.fromNamespaceAndPath(SpamMod.MODID,"spambaby").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

