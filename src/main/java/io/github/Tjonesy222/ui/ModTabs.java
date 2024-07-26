package io.github.Tjonesy222.ui;

import io.github.Tjonesy222.block.ModBlocks;
import io.github.Tjonesy222.init.ItemInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static io.github.Tjonesy222.SpamMod.MODID;

public class ModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SPAM_MOD =
            CREATIVE_TABS.register("spammod", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.spammod"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(()-> ItemInit.SPAM_FRIES.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ItemInit.SPAM.get());
                        output.accept(ItemInit.SPAM_FRIES.get());
                        output.accept(ItemInit.SPAMCAN.get());
                        output.accept(ModBlocks.SPAMBLOCK.get());
                        output.accept(ModBlocks.SPAMORE.get());
                        output.accept(ModBlocks.SPAMDEEP.get());
                        output.accept(ModBlocks.SPAMFOOD.get());


            }).build());
}
