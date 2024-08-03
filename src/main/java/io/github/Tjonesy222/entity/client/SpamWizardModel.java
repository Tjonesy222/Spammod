package io.github.Tjonesy222.entity.client;

import io.github.Tjonesy222.SpamMod;
import io.github.Tjonesy222.entity.custom.JellyBabyEntity;
import io.github.Tjonesy222.entity.custom.SpamWizard;
import io.github.Tjonesy222.entity.custom.SpambabyEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SpamWizardModel extends GeoModel<SpamWizard> {

    @Override
    public ResourceLocation getModelResource(SpamWizard animatable) {
        return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "geo/spamwizard.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpamWizard animatable) {
        return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "textures/entity/spamwizard.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpamWizard animatable) {
        return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "animations/spamwizard.animation.json");
    }

@Override
public void setCustomAnimations(SpamWizard animatible, long instanceId, AnimationState<SpamWizard> animationState) {
    GeoBone head = getAnimationProcessor().getBone("head");

    if (head != null) {
        EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

        head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
        head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
    }
    super.setCustomAnimations(animatible, instanceId, animationState);
}
}


