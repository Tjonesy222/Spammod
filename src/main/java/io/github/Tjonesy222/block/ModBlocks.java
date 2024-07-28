package io.github.Tjonesy222.block;

import io.github.Tjonesy222.block.custom.spamfood;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static io.github.Tjonesy222.SpamMod.MODID;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredBlock<Block> SPAMBLOCK = BLOCKS.register("spamblock",
            ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).sound(SoundType.SLIME_BLOCK)));

    public static final DeferredBlock<Block> SPAMORE = BLOCKS.register("spamore",
            ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    public static final DeferredBlock<Block> SPAMDEEP = BLOCKS.register("spamdeep",
            ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    public static final DeferredBlock<Block> SPAMFOOD = BLOCKS.register("spamfood",
            ()-> new spamfood(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));



}
