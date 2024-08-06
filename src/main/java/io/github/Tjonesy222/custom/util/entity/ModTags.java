package io.github.Tjonesy222.custom.util.entity;

import io.github.Tjonesy222.SpamMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;


public class ModTags {
    public static class SpamEntitys {
        public TagKey<EntityType<?>> SPAMMOBS = tag("spammobs");

        public TagKey<EntityType<?>> tag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, name));
        }
    }
}
