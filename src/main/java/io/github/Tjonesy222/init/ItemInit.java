package io.github.Tjonesy222.init;

import io.github.Tjonesy222.ModEntities;
import io.github.Tjonesy222.SpamMod;
import io.github.Tjonesy222.block.ModBlocks;
import io.github.Tjonesy222.custom.AnimatedItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(SpamMod.MODID);
    //ITEMS
    public static final DeferredItem<Item> SPAM_FRIES = ITEMS.register("spam_fries", () -> new Item(new Item.Properties().stacksTo(64).food(ItemFoods.SPAM_FRIES)));
    public static final DeferredItem<Item> SPAM = ITEMS.register("spam", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> SPAMCAN = ITEMS.register("spamcan", () -> new Item(new Item.Properties().stacksTo(64)));

    public static final DeferredItem<Item> SPAMSTAFF = ITEMS.register("spamstaff", () -> new AnimatedItem(new Item.Properties().stacksTo(1)));
    //BLOCKS
    public static final DeferredItem<BlockItem> SPAMBLOCK = ITEMS.registerSimpleBlockItem("spamblock", ModBlocks.SPAMBLOCK);
    public static final DeferredItem<BlockItem> SPAMORE = ITEMS.registerSimpleBlockItem("spamore", ModBlocks.SPAMORE);
    public static final DeferredItem<BlockItem> SPAMDEEP = ITEMS.registerSimpleBlockItem("spamdeep", ModBlocks.SPAMDEEP);
    public static final DeferredItem<BlockItem> SPAMFOOD = ITEMS.registerSimpleBlockItem("spamfood", ModBlocks.SPAMFOOD);





}
