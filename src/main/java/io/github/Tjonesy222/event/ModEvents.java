package io.github.Tjonesy222.event;

import io.github.Tjonesy222.ModEntities;
import io.github.Tjonesy222.SpamMod;
import io.github.Tjonesy222.entity.custom.JellyBabyEntity;
import io.github.Tjonesy222.entity.custom.SpamWizard;
import io.github.Tjonesy222.entity.custom.SpambabyEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;


@EventBusSubscriber(modid = SpamMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SPAMBABY.get(), SpambabyEntity.setAttributes());
        event.put(ModEntities.JELLYBABY.get(), JellyBabyEntity.setAttributes());
        event.put(ModEntities.SPAMWIZARD.get(), SpamWizard.setAttributes());

    }


}
