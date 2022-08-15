package com.system64.sys64.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class SysCreativeTab {
    public static final CreativeModeTab SYS_TAB = new CreativeModeTab("system64tab") {
        @Override
        public ItemStack makeIcon() {
            System.out.println("TESTAAAAAAAA");
            return new ItemStack(SysItems.TEST.get());
        }
    };
}
