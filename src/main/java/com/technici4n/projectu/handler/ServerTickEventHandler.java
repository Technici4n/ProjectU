package com.technici4n.projectu.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class ServerTickEventHandler
{
    private int tickCount = 0;
    // Unify inventories every X/20 seconds
    private final static int TICK_DELAY = 100;

    // Every server tick... (called twice a tick)
    @SubscribeEvent
    public void onEvent(TickEvent.ServerTickEvent event)
    {
        // Only need once a tick
        if(event.phase == TickEvent.Phase.START)
        {
            return;
        }

        // This is useless :p
        if(tickCount < TICK_DELAY)
        {
            tickCount++;
        }

        if(tickCount == TICK_DELAY)
        {
            InventoryPlayerUnificationHandler.unifyAll();
            tickCount = 0;
        }
    }
}
