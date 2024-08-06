package io.github.Tjonesy222.event;

import io.github.Tjonesy222.ModEntities;
import io.github.Tjonesy222.SpamMod;
import io.github.Tjonesy222.custom.util.entity.ModTags;
import io.github.Tjonesy222.entity.custom.JellyBabyEntity;
import io.github.Tjonesy222.entity.custom.SpamWizard;
import io.github.Tjonesy222.entity.custom.SpambabyEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;

import static net.minecraft.advancements.critereon.TagPredicate.is;


@EventBusSubscriber(modid = SpamMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SPAMBABY.get(), SpambabyEntity.setAttributes());
        event.put(ModEntities.JELLYBABY.get(), JellyBabyEntity.setAttributes());
        event.put(ModEntities.SPAMWIZARD.get(), SpamWizard.setAttributes());

    }

    private static final TagKey<EntityType<?>> SPAMMOBS = TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, "spammobs"));

    public class EventHandler {
        @SubscribeEvent
        public static void onLivingDeath(LivingDeathEvent event) {


            Entity entity = event.getEntity();
            DamageSource source = event.getSource();
            Entity killer = source.getEntity();

            if (killer != null && killer.getType().is(SPAMMOBS)) {


                // Do something if the entity matches the tag
                System.out.println("Entity matches the tagggggggggggggggggggggggggggggggggg!");
            }
            }
        }}




