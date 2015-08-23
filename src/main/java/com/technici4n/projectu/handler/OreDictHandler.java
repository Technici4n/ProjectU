package com.technici4n.projectu.handler;

import com.technici4n.projectu.reference.Reference;
import com.technici4n.projectu.utility.LogProjectU;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

public class OreDictHandler
{
    // Registered OreDictionary Names by ModItems.registerAndOreDictItem
    private static List<String> regODNames = new ArrayList<String>();
    //private static List<Item> blacklist = new ArrayList<Item>();
    // Items of the mod corresponding to the items to be converted
    private static Map<Item, Item> conversionTable = new HashMap<Item, Item>();
    private static boolean allowNewODEntries = true;

    public static void addODName(String entry)
    {
        if(!allowNewODEntries)
            return;

        regODNames.add(entry);
        LogProjectU.info("Added ODName entry: " + entry);
    }

    public static void finishODLoading()
    {
        LogProjectU.info("Finishing ODLoading");
        allowNewODEntries = false;

        Iterator<String> i = regODNames.iterator();
        while(i.hasNext())
        {
            String str = i.next();
            Item item = GameRegistry.findItem(Reference.MOD_ID, str);
            Iterator<ItemStack> j = OreDictionary.getOres(str).iterator();
            while (j.hasNext())
            {
                Item item2 = j.next().getItem();
                conversionTable.put(item2, item);
                LogProjectU.info("Now " + item2.getUnlocalizedName() + " will be unified into: " + item.getUnlocalizedName());
            }
        }
    }

    public static boolean isConvertable(Item i)
    {
        if(i == null)
        {
            return false;
        }
        return conversionTable.containsKey(i);
    }

    public static boolean isConvertable(ItemStack is)
    {
        if(is == null)
        {
            return false;
        }
        return isConvertable(is.getItem());
    }

    public static ItemStack convert(ItemStack is)
    {
        if(!isConvertable(is))
        {
            return is;
        }
        LogProjectU.info("Entry started converting");
        return new ItemStack(conversionTable.get(is.getItem()), is.stackSize);
    }

    public static List<ItemStack> convert(List<ItemStack> list)
    {
        Iterator<ItemStack> i = list.iterator();
        List<ItemStack> newList = new ArrayList<ItemStack>();

        while(i.hasNext())
        {
            newList.add(convert(i.next()));
        }

        return newList;
    }
}
