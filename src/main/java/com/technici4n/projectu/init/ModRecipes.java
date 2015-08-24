package com.technici4n.projectu.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes
{
    public static void init()
    {
        GameRegistry.addRecipe(new ItemStack(ModItems.staffInertOne), "ww ", "ww ", "  s", 'w', Blocks.wool, 's', Items.stick);
    }
}
