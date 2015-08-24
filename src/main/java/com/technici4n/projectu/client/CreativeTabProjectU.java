package com.technici4n.projectu.client;

import com.technici4n.projectu.init.ModItems;
import com.technici4n.projectu.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

// The mod's creative tab
public class CreativeTabProjectU
{
    public static final CreativeTabs TAB_PROJECTU = new CreativeTabs(Reference.MOD_ID)
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.staffInertOne;
        }

        @Override
        public String getTabLabel()
        {
            return "ProjectU";
        }
    };
}
