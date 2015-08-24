package com.technici4n.projectu.item;

import com.technici4n.projectu.reference.Names;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemStaffInertOne extends ItemBaseProjectU
{
    public ItemStaffInertOne()
    {
        super();
        setUnlocalizedName(Names.Items.STAFF_INERT_ONE);
        setMaxStackSize(1);
        setFull3D();
    }

    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.uncommon;
    }
}
