package com.technici4n.projectu.init;

import com.technici4n.projectu.handler.OreDictHandler;
import com.technici4n.projectu.item.ItemStaffInertOne;
import com.technici4n.projectu.item.ItemUniversalItem;
import com.technici4n.projectu.reference.Names;
import com.technici4n.projectu.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemUniversalItem dustIron = new ItemUniversalItem(Names.Items.DUST_IRON);
    public static final ItemUniversalItem dustGold = new ItemUniversalItem(Names.Items.DUST_GOLD);
    public static final ItemUniversalItem dustCopper = new ItemUniversalItem(Names.Items.DUST_COPPER);
    public static final ItemUniversalItem dustTin = new ItemUniversalItem(Names.Items.DUST_TIN);
    public static final ItemUniversalItem dustBronze = new ItemUniversalItem(Names.Items.DUST_BRONZE);
    public static final ItemUniversalItem dustSilver = new ItemUniversalItem(Names.Items.DUST_SILVER);
    public static final ItemUniversalItem dustLead = new ItemUniversalItem(Names.Items.DUST_LEAD);
    public static final ItemUniversalItem dustSteel = new ItemUniversalItem(Names.Items.DUST_STEEL);

    public static final ItemUniversalItem ingotCopper = new ItemUniversalItem(Names.Items.INGOT_COPPER);
    public static final ItemUniversalItem ingotTin = new ItemUniversalItem(Names.Items.INGOT_TIN);
    public static final ItemUniversalItem ingotBronze = new ItemUniversalItem(Names.Items.INGOT_BRONZE);
    public static final ItemUniversalItem ingotSilver = new ItemUniversalItem(Names.Items.INGOT_SILVER);
    public static final ItemUniversalItem ingotLead = new ItemUniversalItem(Names.Items.INGOT_LEAD);
    public static final ItemUniversalItem ingotSteel = new ItemUniversalItem(Names.Items.INGOT_STEEL);

    public static final ItemStaffInertOne staffInertOne = new ItemStaffInertOne();

    private static void registerAndOreDictItem(Item item)
    {
        String unlocName = item.getUnlocalizedName().substring(item.getUnlocalizedName().indexOf(":") + 1);
        // 1. Register item in the GameRegistry
        GameRegistry.registerItem(item, unlocName);
        // 2. Register item in the OreDictionary
        OreDictionary.registerOre(unlocName, item);
        // 3. Register item to be unified
        OreDictHandler.addODName(unlocName);
    }

    public static void registerModItems()
    {
        registerAndOreDictItem(dustIron);
        registerAndOreDictItem(dustGold);
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

        GameRegistry.registerItem(staffInertOne, Reference.MOD_ID);
    }
}
