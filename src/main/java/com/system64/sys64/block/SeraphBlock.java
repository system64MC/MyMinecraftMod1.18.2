package com.system64.sys64.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SeraphBlock extends Block {
    public SeraphBlock(Properties properties)
    {
        super(properties);
    }


    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        super.playerDestroy(pLevel, pPlayer, pPos, pState, pBlockEntity, pTool);
        if(!pPlayer.getInventory().add(new ItemStack(this)))
        {
            pPlayer.drop(new ItemStack(this), false);
        }
    }
}
