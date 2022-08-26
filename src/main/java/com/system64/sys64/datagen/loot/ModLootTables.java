package com.system64.sys64.datagen.loot;

import com.system64.sys64.block.SysBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModLootTables extends BaseLootTableProvider {

    public ModLootTables(DataGenerator pGenerator)
    {
        super(pGenerator);
    }
    @Override
    protected void addTables() {
        // this.dropSelf(SysBlocks.XRAY_BLOCK.get());
        // this.dropSelf(SysBlocks.COMPRESSED_COBBLE.get());
        // this.dropSelf(SysBlocks.DOUBLE_COBBLE.get());
        // this.dropSelf(SysBlocks.TRIPLE_COBBLE.get());
        // this.dropSelf(SysBlocks.QUADRUPLE_COBBLE.get());
        // this.dropSelf(SysBlocks.QUINTUPLE_COBBLE.get());
        // this.dropSelf(SysBlocks.SEXTUPLE_COBBLE.get());
        // this.dropSelf(SysBlocks.OCTUPLE_COBBLE.get());

        lootTables.put(SysBlocks.XRAY_BLOCK.get(), createSimpleTable("xray_block", SysBlocks.XRAY_BLOCK.get()));
        lootTables.put(SysBlocks.COMPRESSED_COBBLE.get(), createSimpleTable("compressed_cobble", SysBlocks.COMPRESSED_COBBLE.get()));
        lootTables.put(SysBlocks.DOUBLE_COBBLE.get(), createSimpleTable("double_cobble", SysBlocks.DOUBLE_COBBLE.get()));
        lootTables.put(SysBlocks.TRIPLE_COBBLE.get(), createSimpleTable("triple_cobble", SysBlocks.TRIPLE_COBBLE.get()));
        lootTables.put(SysBlocks.QUADRUPLE_COBBLE.get(), createSimpleTable("quadruple_cobble", SysBlocks.QUADRUPLE_COBBLE.get()));
        lootTables.put(SysBlocks.QUINTUPLE_COBBLE.get(), createSimpleTable("quintuple_cobble", SysBlocks.QUINTUPLE_COBBLE.get()));
        lootTables.put(SysBlocks.SEXTUPLE_COBBLE.get(), createSimpleTable("sextuple_cobble", SysBlocks.SEXTUPLE_COBBLE.get()));
        lootTables.put(SysBlocks.SEPTUPLE_COBBLE.get(), createSimpleTable("septuple_cobble", SysBlocks.SEPTUPLE_COBBLE.get()));
        lootTables.put(SysBlocks.OCTUPLE_COBBLE.get(), createSimpleTable("octuple_cobble", SysBlocks.OCTUPLE_COBBLE.get()));

    }


}
