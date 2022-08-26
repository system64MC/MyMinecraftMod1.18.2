package com.system64.sys64.block;

import com.system64.sys64.System64;
import com.system64.sys64.item.SysCreativeTab;
import com.system64.sys64.item.SysItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IRegistryDelegate;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

import com.system64.sys64.item.SysItems;

import static com.system64.sys64.item.SysItems.ITEMS;

public class SysBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, System64.MOD_ID);

    public static final RegistryObject<Block> XRAY_BLOCK = registerBlock("xray_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.0f, 2.0f).requiresCorrectToolForDrops()), SysCreativeTab.SYS_TAB);
    public static final RegistryObject<Block> COMPRESSED_COBBLE = registerBlock("compressed_cobble", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 6.0F).requiresCorrectToolForDrops()), SysCreativeTab.SYS_TAB, "tooltip.sys64.block.compressed_cobble");
    public static final RegistryObject<Block> DOUBLE_COBBLE = registerBlock("double_cobble", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4.0F, 12.0F).requiresCorrectToolForDrops()), SysCreativeTab.SYS_TAB, "tooltip.sys64.block.double_cobble");
    public static final RegistryObject<Block> TRIPLE_COBBLE = registerBlock("triple_cobble", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(8.0F, 24.0F).requiresCorrectToolForDrops()), SysCreativeTab.SYS_TAB, "tooltip.sys64.block.triple_cobble");
    public static final RegistryObject<Block> QUADRUPLE_COBBLE = registerBlock("quadruple_cobble", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(16.0F, 48.0F).requiresCorrectToolForDrops()), SysCreativeTab.SYS_TAB, "tooltip.sys64.block.quadruple_cobble");
    public static final RegistryObject<Block> QUINTUPLE_COBBLE = registerBlock("quintuple_cobble", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(32.0F, 96.0F).requiresCorrectToolForDrops()), SysCreativeTab.SYS_TAB, "tooltip.sys64.block.quintuple_cobble");
    public static final RegistryObject<Block> SEXTUPLE_COBBLE = registerBlock("sextuple_cobble", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(64.0F, 192.0F).requiresCorrectToolForDrops()), SysCreativeTab.SYS_TAB, "tooltip.sys64.block.sextuple_cobble");
    public static final RegistryObject<Block> SEPTUPLE_COBBLE = registerBlock("septuple_cobble", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(128.0F, 384.0F).requiresCorrectToolForDrops()), SysCreativeTab.SYS_TAB, "tooltip.sys64.block.septuple_cobble");
    public static final RegistryObject<Block> OCTUPLE_COBBLE = registerBlock("octuple_cobble", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(256.0F, 768.0F).requiresCorrectToolForDrops()), SysCreativeTab.SYS_TAB, "tooltip.sys64.block.octuple_cobble");

    // public static final RegistryObject<Block> SERAPH_BLOCK = new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1f));
    public static final RegistryObject<Block> SERAPH_BLOCK = BLOCKS.register("seraph_block", () -> new SeraphBlock(BlockBehaviour.Properties.of(Material.STONE).strength(0f)));

    // public static final Block SERAPH_BLOCK = new Block(Prop)


    public static void init()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
    }

    //public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block)
    //{
    //    return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
    //}

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab, String tooltipkey)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipkey);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T>block, CreativeModeTab tab, String tooltipkey)
    {
        return ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(new TranslatableComponent(tooltipkey));
            }
        });
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T>block, CreativeModeTab tab)
    {
        return ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }

    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block, Item.Properties properties)
    {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
    }

}
