package com.technici4n.projectu.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

import java.util.Iterator;

public class InventoryPlayerUnificationHandler
{
    public static final int PLAYER_MAININVENTORY_SIZE = 36;

    public static void unifyAll()
    {
        for(WorldServer ws : MinecraftServer.getServer().worldServers)
        {
            Iterator<EntityPlayer> i = ws.playerEntities.iterator();
            while (i.hasNext())
            {
                EntityPlayer p = i.next();
                p.inventory = unifyInventory(p.inventory);
            }
        }
    }

    public static InventoryPlayer unifyInventory(InventoryPlayer inv)
    {
        for(int i = 0; i < PLAYER_MAININVENTORY_SIZE; i++)
        {
            inv.setInventorySlotContents(i, OreDictHandler.convert(inv.getStackInSlot(i)));
        }
        return inv;
    }
}
