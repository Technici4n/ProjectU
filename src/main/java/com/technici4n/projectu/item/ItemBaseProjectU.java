package com.technici4n.projectu.item;

import com.technici4n.projectu.client.CreativeTabProjectU;
import com.technici4n.projectu.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.lang.Override;

public class ItemBaseProjectU extends Item
{
    public ItemBaseProjectU()
    {
        super();
        setMaxStackSize(64);
        setCreativeTab(CreativeTabProjectU.TAB_PROJECTU);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iIR)
    {
        itemIcon = iIR.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s:%s", Reference.MOD_ID.toLowerCase(), super.getUnlocalizedName().substring(super.getUnlocalizedName().indexOf(".") + 1));
    }

    @Override
    public String getUnlocalizedName(ItemStack is)
    {
        return getUnlocalizedName();
    }
}
