package io.github.Tjonesy222.entity.client;

import io.github.Tjonesy222.SpamMod;
import io.github.Tjonesy222.entity.custom.SpamProjEntity;
import io.github.Tjonesy222.entity.custom.SpambabyEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SpamProjModel extends GeoModel<SpamProjEntity> {


    @Override
    public ResourceLocation getModelResource(SpamProjEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "geo/spamproj.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpamProjEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "textures/entity/spamproj.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpamProjEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "animations/spamproj.animation.json");
    }
}