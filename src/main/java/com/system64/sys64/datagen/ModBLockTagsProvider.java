package com.system64.sys64.datagen;

import com.system64.sys64.System64;
import com.system64.sys64.block.SysBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBLockTagsProvider extends BlockTagsProvider {
    public ModBLockTagsProvider(DataGenerator pGenerator, ExistingFileHelper helper)
    {
        super(pGenerator, System64.MOD_ID, helper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(SysBlocks.COMPRESSED_COBBLE.get())
                .add(SysBlocks.DOUBLE_COBBLE.get())
                .add(SysBlocks.TRIPLE_COBBLE.get())
                .add(SysBlocks.QUADRUPLE_COBBLE.get())
                .add(SysBlocks.QUINTUPLE_COBBLE.get())
                .add(SysBlocks.SEXTUPLE_COBBLE.get())
                .add(SysBlocks.SEPTUPLE_COBBLE.get())
                .add(SysBlocks.OCTUPLE_COBBLE.get())
                .add(SysBlocks.XRAY_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(SysBlocks.COMPRESSED_COBBLE.get())
                .add(SysBlocks.DOUBLE_COBBLE.get())
                .add(SysBlocks.TRIPLE_COBBLE.get())
                .add(SysBlocks.QUADRUPLE_COBBLE.get())
                .add(SysBlocks.QUINTUPLE_COBBLE.get())
                .add(SysBlocks.SEXTUPLE_COBBLE.get())
                .add(SysBlocks.SEPTUPLE_COBBLE.get())
                .add(SysBlocks.OCTUPLE_COBBLE.get())
                .add(SysBlocks.XRAY_BLOCK.get());
    }

    @Override
    public String getName() {
        return "System64 tags";
    }
}
