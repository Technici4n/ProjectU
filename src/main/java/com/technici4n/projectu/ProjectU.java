package com.technici4n.projectu;

import com.technici4n.projectu.handler.ServerTickEventHandler;
import com.technici4n.projectu.handler.OreDictHandler;
import com.technici4n.projectu.init.ModItems;
import com.technici4n.projectu.reference.Reference;
import com.technici4n.projectu.utility.LogProjectU;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.init.Blocks;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class ProjectU
{
    @Mod.Instance(value = Reference.MOD_ID)
    public static ProjectU INSTANCE;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModItems.registerModItems();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(new ServerTickEventHandler());
        LogProjectU.info("Initialization complete");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        OreDictionary.registerOre("ingotCopper", Blocks.wool);
        OreDictHandler.finishODLoading();
    }
}
