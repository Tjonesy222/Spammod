package io.github.Tjonesy222.datagen;

import io.github.Tjonesy222.SpamMod;
import io.github.Tjonesy222.worldgen.ModBiomeModifiers;
import io.github.Tjonesy222.worldgen.ModConfiguredFeatures;
import io.github.Tjonesy222.worldgen.ModPlacedFeatures;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<RegistrySetBuilder.PatchedRegistries> registries, Set<String> modIds) {
        super(output, registries, Set.of(SpamMod.MODID));
    }
}
