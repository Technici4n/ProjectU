package com.technici4n.projectu.handler;

import cpw.mods.fml.common.event.FMLInterModComms;

// IMC Format: FMLInterModComms.sendMessage("projectu", "addODBlacklisted", new ItemStack( ... ));
public class IMCHandlerProjectU
{
    public static void onIMC(FMLInterModComms.IMCEvent event)
    {
        for(final FMLInterModComms.IMCMessage msg : event.getMessages())
        {
            if(msg.key.equals("addODBlacklisted"))
            {
                OreDictHandler.addBlacklisted( msg.getItemStackValue( ) );
            }
        }
    }
}
