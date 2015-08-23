package com.technici4n.projectu.handler;

import com.technici4n.projectu.utility.LogProjectU;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class ServerTickEventHandler
{
    private int tickCount = 0;
    private final int TICK_DELAY = 200;


    @SubscribeEvent
    public void onServerTickEvent(TickEvent.ServerTickEvent event)
    {
        if(event.phase == TickEvent.Phase.END)
        {
            return;
        }

        tickCount++;
        LogProjectU.info("Ticks: " + tickCount);

        if(tickCount >= TICK_DELAY)
        {
            InventoryPlayerUnificationHandler.unifyAll();
            tickCount = 0;
        }
    }
}
