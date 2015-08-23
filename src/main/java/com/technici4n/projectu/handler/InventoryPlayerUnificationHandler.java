package com.technici4n.projectu.handler;

import com.technici4n.projectu.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

// Bridge between the ServerTickEvent and the unifying system
public class InventoryPlayerUnificationHandler
{

    public static final int PLAYER_HOTBAR_SIZE = 9;
    // If one day Mojang changes the number of slots in players' inventory...
    public static final int PLAYER_MAININVENTORY_SIZE = PLAYER_HOTBAR_SIZE + 27;

    // Unify all the players' inventory
    public static void unifyAll()
    {
        //LogProjectU.info("Unifying all player inventories");
        for(WorldServer ws : MinecraftServer.getServer().worldServers)
        {
            for (Object objP  : ws.playerEntities)
            {
                if(objP instanceof EntityPlayer)
                {
                    EntityPlayer p = (EntityPlayer) objP;
                    p.inventory = unifyInventory(p.inventory);
                }
            }
        }
    }

    // Unify one player's inventory TODO: Support the left hand slot {1.9}
    public static InventoryPlayer unifyInventory(InventoryPlayer inv)
    {
        for(int i = 0; i < PLAYER_HOTBAR_SIZE; i++)
        {
            if(inv.getStackInSlot(i) == null)
            {
                continue;
            }
            if(inv.getStackInSlot(i).getItem() == ModItems.staffInertOne)
            {
                return inv;
            }
        }
        for(int j = 0; j < PLAYER_MAININVENTORY_SIZE; j++)
        {
            inv.setInventorySlotContents(j, OreDictHandler.unify(inv.getStackInSlot(j)));
        }
        return inv;
    }
}
