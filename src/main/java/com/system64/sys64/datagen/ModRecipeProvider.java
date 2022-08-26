package com.system64.sys64.datagen;

import com.system64.sys64.block.SysBlocks;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer)
    {
        ShapedRecipeBuilder.shaped(SysBlocks.COMPRESSED_COBBLE.get())
                .define('a', Items.COBBLESTONE)
                .pattern("aaa")
                .pattern("aaa")
                .pattern("aaa")
                .unlockedBy("has_cobble", inventoryTrigger(ItemPredicate.ANY))
                .save(finishedRecipeConsumer);
    }
}
