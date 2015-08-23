package com.technici4n.projectu.handler;


import com.technici4n.projectu.item.ItemUniversalItem;
import com.technici4n.projectu.reference.Reference;
import com.technici4n.projectu.utils.LogProjectU;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This class is the core of the unification system
 */
public class OreDictHandler
{
    // OreDictionary names to be processed later (postInit)
    private static List<String> regODNames = new ArrayList<String>();

    // Blacklisted items
    private static List<ItemStack> blacklist = new ArrayList<ItemStack>();

    // Stores all the conversions : <ConvertFrom, ConvertTo>
    private static Map<ItemStack, ItemStack> conversionTable = new HashMap<ItemStack, ItemStack>();

    private static boolean allowNewODNamesAfterPostInit = true;

    /*
     * Check for two similar itemStacks (Item and metadata)
     * NOTE: is1 == is2 wont work because of pointers but it works with the Item (shared instance, obviously not the case for ItemStack) and int (pointers are only used for Objects)
     */
    private static boolean customEquals(ItemStack is1, ItemStack is2)
    {
        if(is1.getItem() == is2.getItem() && is1.getItemDamage() == is2.getItemDamage())
            return true;
        return false;
    }

    // Register a new universal item
    // Cant be called after post-init
    public static void addODName(String entry)
    {
        if(!allowNewODNamesAfterPostInit)
        {
            return;
        }
        regODNames.add(entry);
        LogProjectU.info("Added ODName entry: " + entry);
    }

    // Could be used later to register a replacement where the two items are not OreDicted
    // Can (should NOT) be called after post-init
    public static void addItemReplacement(ItemStack replacedBy, ItemStack is)
    {
        conversionTable.put(replacedBy, is);
    }

    // Add blacklist entry TODO: Add entries with IMC
    public void addBlacklisted(ItemStack is)
    {
        is.stackSize = 1;
        blacklist.add(is);
    }

    /*
     * Called during post-init
     * Find all the matching OreDictionary names and register them as replaced by the mod's items
     */
    public static void finishODLoading()
    {
        LogProjectU.info("Finishing loading of the OreDictionary Unifier");

        allowNewODNamesAfterPostInit = false;
        for(String str : regODNames)
        {
            Item item = GameRegistry.findItem(Reference.MOD_ID, str);
            for(ItemStack is : OreDictionary.getOres(str))
            {
                if(!(is.getItem() instanceof ItemUniversalItem)) // Don't want to convert the mod's items into... themselves ! (it would probably have no effect)
                {
                    conversionTable.put(is, new ItemStack(item));
                }
            }
        }
    }

    /*
     * Called every X server ticks
     * Unifies an ItemStack
     */
    public static ItemStack unify(ItemStack is)
    {
        if(is == null) // Avoid NullPointerException if the slot is empty
        {
            return null;
        }
        for(ItemStack blackListed : blacklist) // Avoid blacklisted items to be converted
        {
            if(customEquals(is, blackListed))
            {
                return is;
            }
        }
        for(Map.Entry<ItemStack, ItemStack> entry : conversionTable.entrySet())
        {
            if(customEquals(is, entry.getKey()))
            {
                return new ItemStack(entry.getValue().getItem(), is.stackSize, entry.getValue().getItemDamage());
            }
        }
        return is;
    }
}
