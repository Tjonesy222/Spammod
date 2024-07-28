package io.github.Tjonesy222.entity.client;

import io.github.Tjonesy222.SpamMod;
import io.github.Tjonesy222.entity.custom.SpambabyEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SpambabyModel extends GeoModel<SpambabyEntity> {

    @Override
    public ResourceLocation getModelResource(SpambabyEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "geo/spambaby.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpambabyEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "textures/entity/spambaby.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpambabyEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "animations/spambaby.animation.json");
    }
    @Override
    public void setCustomAnimations(SpambabyEntity animatible, long instanceId, AnimationState<SpambabyEntity> animationState) {
        GeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
        super.setCustomAnimations(animatible,instanceId,animationState);
    }
}