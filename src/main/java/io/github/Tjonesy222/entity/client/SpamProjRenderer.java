package io.github.Tjonesy222.entity.client;

import io.github.Tjonesy222.SpamMod;
import io.github.Tjonesy222.entity.custom.SpamProjEntity;
import io.github.Tjonesy222.entity.custom.SpambabyEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpamProjRenderer extends GeoEntityRenderer<SpamProjEntity> {

    public SpamProjRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SpamProjModel());

    }

    public ResourceLocation getTextureResource(SpambabyEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "textures/entity/spamproj.png");
    }

}