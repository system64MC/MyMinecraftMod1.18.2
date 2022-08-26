package com.system64.sys64.datagen;

import com.system64.sys64.System64;
import com.system64.sys64.datagen.loot.ModLootTables;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = System64.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(new ModRecipeProvider(generator));
        generator.addProvider(new ModLootTables(generator));
        ModBLockTagsProvider blockTags = new ModBLockTagsProvider(generator, event.getExistingFileHelper());
        generator.addProvider(blockTags);
    }
}
