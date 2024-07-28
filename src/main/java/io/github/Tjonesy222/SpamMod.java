package io.github.Tjonesy222;

import io.github.Tjonesy222.block.ModBlocks;
import io.github.Tjonesy222.init.ItemInit;
import io.github.Tjonesy222.ui.ModTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
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

}
