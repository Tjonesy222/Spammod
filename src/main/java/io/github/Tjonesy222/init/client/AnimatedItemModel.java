package io.github.Tjonesy222.init.client;

import io.github.Tjonesy222.SpamMod;
import io.github.Tjonesy222.custom.AnimatedItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.model.GeoModel;

import java.util.function.Consumer;

public class AnimatedItemModel extends GeoModel<AnimatedItem> {
    @Override
    public ResourceLocation getModelResource(AnimatedItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "geo/spamstaff.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "textures/item/spamstaff.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "animations/spamstaff.animation.json");
    }
}

