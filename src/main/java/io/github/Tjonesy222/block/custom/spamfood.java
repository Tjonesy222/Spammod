package io.github.Tjonesy222.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;

public class spamfood extends Block {
    public static final MapCodec<spamfood> CODEC = simpleCodec(spamfood::new);

    public MapCodec<spamfood> codec() {
        return CODEC;
    }
    public spamfood(Properties properties) {
        super(properties);
    }
}
