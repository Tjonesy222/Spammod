package io.github.Tjonesy222;

import io.github.Tjonesy222.block.ModBlocks;
import io.github.Tjonesy222.entity.client.JellyBabyRenderer;
import io.github.Tjonesy222.entity.client.SpamProjRenderer;
import io.github.Tjonesy222.entity.client.SpambabyRenderer;
import io.github.Tjonesy222.init.ItemInit;
import io.github.Tjonesy222.ui.ModTabs;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Mod(SpamMod.MODID)
public class SpamMod {
    public static final String MODID = "tjmod";
    public static final Logger logger = LoggerFactory.getLogger(SpamMod.class);

    public SpamMod(@NotNull IEventBus bus) {
        ItemInit.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModTabs.CREATIVE_TABS.register(bus);
        ModEntities.ENTITY_TYPES.register(bus);
    }
@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value =  Dist.CLIENT)
public static class ClientModEvents{
@SubscribeEvent
public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.SPAMBABY.get(), SpambabyRenderer::new);

    EntityRenderers.register(ModEntities.JELLYBABY.get(), JellyBabyRenderer::new);

    EntityRenderers.register(ModEntities.SPAMPROJENTITY.get(), SpamProjRenderer::new);


        }


        


    }}


