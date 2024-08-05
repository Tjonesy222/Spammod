package io.github.Tjonesy222.custom.util;

import io.github.Tjonesy222.SpamMod;
import net.minecraft.ResourceLocationException;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;


public class ModTags {
    public static class ModEntitys {
        public TagKey<EntityType<?>> SPAMMOBS = tag("spammobs");

        public TagKey<EntityType<?>> tag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, name));
        }
    }
}
