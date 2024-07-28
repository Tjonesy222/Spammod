package io.github.Tjonesy222.init.client;

import io.github.Tjonesy222.custom.AnimatedItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

import java.util.function.Consumer;

public class AnimatedItemRenderer extends GeoItemRenderer<AnimatedItem> {
    public AnimatedItemRenderer() {
        super(new AnimatedItemModel());

    }
}

