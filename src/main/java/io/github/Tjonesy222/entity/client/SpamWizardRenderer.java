package io.github.Tjonesy222.entity.client;

import io.github.Tjonesy222.SpamMod;
import io.github.Tjonesy222.entity.custom.JellyBabyEntity;
import io.github.Tjonesy222.entity.custom.SpamWizard;
import io.github.Tjonesy222.entity.custom.SpambabyEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpamWizardRenderer extends GeoEntityRenderer<SpamWizard> {
    public SpamWizardRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SpamWizardModel());

    }

public ResourceLocation getTextureResource(SpambabyEntity animatable) {
    return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "textures/entity/spamwizard.png");
}

}