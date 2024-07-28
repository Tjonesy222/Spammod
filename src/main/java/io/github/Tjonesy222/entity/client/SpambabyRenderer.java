package io.github.Tjonesy222.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.Tjonesy222.SpamMod;
import io.github.Tjonesy222.custom.AnimatedItem;
import io.github.Tjonesy222.entity.custom.SpambabyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpambabyRenderer extends GeoEntityRenderer<SpambabyEntity> {

    public SpambabyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SpambabyModel());

    }

    public ResourceLocation getTextureResource(SpambabyEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "textures/entity/spambaby.png");
    }

}
