package com.technici4n.projectu;

import com.technici4n.projectu.handler.OreDictHandler;
import com.technici4n.projectu.handler.ServerTickEventHandler;
import com.technici4n.projectu.init.ModItems;
import com.technici4n.projectu.init.ModRecipes;
import com.technici4n.projectu.reference.Reference;
import com.technici4n.projectu.utils.LogProjectU;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class ProjectU
{
    // Instance
    @Mod.Instance(value = Reference.MOD_ID)
    public static ProjectU INSTANCE;


    // Entry points
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // Register items
        ModItems.registerModItems();

        LogProjectU.info("Pre-Initialization complete");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        // Register the tick handler
        FMLCommonHandler.instance().bus().register(new ServerTickEventHandler());

        // Register recipes
        ModRecipes.init();

        LogProjectU.info("Initialization complete");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        OreDictHandler.finishODLoading();

        LogProjectU.info("Post-Initialization complete");
    }
}
