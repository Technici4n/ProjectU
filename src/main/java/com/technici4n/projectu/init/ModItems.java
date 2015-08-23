package com.technici4n.projectu.init;

import com.technici4n.projectu.handler.OreDictHandler;
import com.technici4n.projectu.item.ItemUniversalItem;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems
{
    public static final ItemUniversalItem dustIron = new ItemUniversalItem("dustIron");
    public static final ItemUniversalItem dustCopper = new ItemUniversalItem("dustCopper");
    public static final ItemUniversalItem dustTin = new ItemUniversalItem("dustTin");
    public static final ItemUniversalItem dustBronze = new ItemUniversalItem("dustBronze");
    public static final ItemUniversalItem dustSilver = new ItemUniversalItem("dustSilver");
    public static final ItemUniversalItem dustLead = new ItemUniversalItem("dustLead");
    public static final ItemUniversalItem dustSteel = new ItemUniversalItem("dustSteel");

    public static final ItemUniversalItem ingotCopper = new ItemUniversalItem("ingotCopper");
    public static final ItemUniversalItem ingotTin = new ItemUniversalItem("ingotTin");
    public static final ItemUniversalItem ingotBronze = new ItemUniversalItem("ingotBronze");
    public static final ItemUniversalItem ingotSilver = new ItemUniversalItem("ingotSilver");
    public static final ItemUniversalItem ingotLead = new ItemUniversalItem("ingotLead");
    public static final ItemUniversalItem ingotSteel = new ItemUniversalItem("ingotSteel");

    private static void registerAndOreDictItem(Item item)
    {
        String unlocName = item.getUnlocalizedName().substring(item.getUnlocalizedName().indexOf(":") + 1);
        GameRegistry.registerItem(item, unlocName);
        OreDictionary.registerOre(unlocName, item);
        OreDictHandler.addODName(unlocName);
    }

    public static void registerModItems()
    {
        registerAndOreDictItem(dustIron);
        registerAndOreDictItem(dustCopper);
        registerAndOreDictItem(dustTin);
        registerAndOreDictItem(dustBronze);
        registerAndOreDictItem(dustSilver);
        registerAndOreDictItem(dustLead);
        registerAndOreDictItem(dustSteel);

        registerAndOreDictItem(ingotCopper);
        registerAndOreDictItem(ingotTin);
        registerAndOreDictItem(ingotBronze);
        registerAndOreDictItem(ingotSilver);
        registerAndOreDictItem(ingotLead);
        registerAndOreDictItem(ingotSteel);
    }
}
