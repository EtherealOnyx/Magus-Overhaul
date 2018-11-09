package com.etherealonyx.magusoverhaul.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemBase spellBase =
            new ItemSpellBase("stuff").setCreativeTab(CreativeTabs.COMBAT);








    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll (
                spellBase
        );
    }


    public static void registerModels() {
        spellBase.registerItemModel();
    }
}
