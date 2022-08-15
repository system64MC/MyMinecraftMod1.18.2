package com.system64.sys64.item;

import com.system64.sys64.System64;
import com.system64.sys64.block.SysBlocks;
import com.system64.sys64.block.SeraphBlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SysItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, System64.MOD_ID);

    public static final RegistryObject<Item> TEST = ITEMS.register("test",
            () -> new Item(new Item.Properties().tab(SysCreativeTab.SYS_TAB)));

    public static final RegistryObject<Item> SERAPH = ITEMS.register("seraph", () -> new SeraphBlockItem(SysBlocks.SERAPH_BLOCK.get(), new Item.Properties().tab(SysCreativeTab.SYS_TAB)));

    // public static final RegistryObject<Item>

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
