package com.system64.sys64.block.entity;

import com.system64.sys64.item.SysItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
    import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class AdvancedCraftingTable extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemStackHandler = new ItemStackHandler(25) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
        {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemStackHandler);
    }

    public AdvancedCraftingTable(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Advanced Crafting Table");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return null;
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemStackHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemStackHandler.deserializeNBT(nbt.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemStackHandler.getSlots());
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            inventory.setItem(i, itemStackHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }


    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, AdvancedCraftingTable pBlockEntity) {
        //if(hasRecipe(pBlockEntity) && hasNotReachedStackLimit(pBlockEntity)) {
        //    craftItem(pBlockEntity);
        //}
    }

    private static void craftItem(AdvancedCraftingTable entity) {

        for(int i = 0; i < entity.itemStackHandler.getSlots(); i++)
            entity.itemStackHandler.extractItem(i, 1, false);
        entity.itemStackHandler.extractItem(1, 1, false);
        entity.itemStackHandler.getStackInSlot(2).hurt(1, new Random(), null);

        //entity.itemStackHandler.setStackInSlot(3, new ItemStack(SysItems.CITRINE.get(),
        //        entity.itemStackHandler.getStackInSlot(3).getCount() + 1));
    }

    //private static boolean hasRecipe(AdvancedCraftingTable entity) {
    //    boolean hasItemInWaterSlot = PotionUtils.getPotion(entity.itemStackHandler.getStackInSlot(0)) == SysItems.WATER;
    //    boolean hasItemInFirstSlot = entity.itemStackHandler.getStackInSlot(1).getItem() == SysItems.RAW_CITRINE.get();
    //    boolean hasItemInSecondSlot = entity.itemStackHandler.getStackInSlot(2).getItem() == SysItems.GEM_CUTTER_TOOL.get();

    //    return hasItemInWaterSlot && hasItemInFirstSlot && hasItemInSecondSlot;
    //}

    private static boolean hasNotReachedStackLimit(AdvancedCraftingTable entity) {
        return entity.itemStackHandler.getStackInSlot(3).getCount() < entity.itemStackHandler.getStackInSlot(3).getMaxStackSize();
    }
}
