package com.system64.sys64.block;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;

public class SeraphBlockItem extends BlockItem {
    //public SeraphBlockItem(Properties pProperties) {
    //    super(pProperties);
    //}

    public SeraphBlockItem(Block block, Properties pproperties)
    {
        super(block, pproperties);
    }

    private static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        double x = player.getX() + 3 * player.getLookAngle().x;
        double y = 1.5 + player.getY() + 3 * player.getLookAngle().y;
        double z = player.getZ() + 3 * player.getLookAngle().z;

        System.out.println(player.getLookAngle().x + " " + player.getLookAngle().y + " " + player.getLookAngle().z);

        BlockPos pos = new BlockPos(x, y, z);
        LOGGER.info("Block placed!");

        if(level.getBlockState(pos).isAir())
        {
            LOGGER.info("Block AIR!");
            level.setBlockAndUpdate(pos, SysBlocks.SERAPH_BLOCK.get().defaultBlockState());
            if(!player.isCreative())
                player.getItemInHand(hand).shrink(1);
        }

        LOGGER.info("Bloc placed at : " + x + ", " + y + ", " + z);

        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
}
