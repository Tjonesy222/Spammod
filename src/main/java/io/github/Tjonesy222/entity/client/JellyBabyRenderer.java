package io.github.Tjonesy222.entity.client;

import io.github.Tjonesy222.SpamMod;
import io.github.Tjonesy222.entity.custom.JellyBabyEntity;
import io.github.Tjonesy222.entity.custom.SpambabyEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class JellyBabyRenderer extends GeoEntityRenderer<JellyBabyEntity> {

    public JellyBabyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new JellyBabyModel());

    }

    public ResourceLocation getTextureResource(SpambabyEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "textures/entity/jellybaby.png");
    }

}