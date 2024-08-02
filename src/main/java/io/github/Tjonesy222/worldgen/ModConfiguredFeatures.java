package io.github.Tjonesy222.worldgen;

import io.github.Tjonesy222.SpamMod;
import io.github.Tjonesy222.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.neoforged.fml.common.Mod;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLDSPAMOREKEY = registryKey("spamore.json");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context){
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldSpamOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.SPAMORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.SPAMDEEP.get().defaultBlockState()));

        register(context, OVERWORLDSPAMOREKEY, Feature.ORE, new OreConfiguration(overworldSpamOres, 12));



    }



    public static ResourceKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(SpamMod.MODID, name));
    }
private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                      ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
}

}
