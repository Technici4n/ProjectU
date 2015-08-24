package com.technici4n.projectu.handler;

import cpw.mods.fml.common.event.FMLInterModComms;

public class IMCHandlerProjectU
{
    public static void onIMC(FMLInterModComms.IMCEvent event)
    {
        for(final FMLInterModComms.IMCMessage msg : event.getMessages())
        {
            if(msg.key.equals("addODBlacklisted"))
            {
                String str = msg.getStringValue();

            }
        }
    }
}
