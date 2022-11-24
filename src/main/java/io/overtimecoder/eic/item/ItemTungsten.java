package io.overtimecoder.eic.item;

import io.overtimecoder.eic.EIC;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTungsten extends Item {

    public ItemTungsten() {
        super();
        this.setRegistryName(EIC.MODID, "filament");
        this.setCreativeTab(CreativeTabs.MATERIALS);
        this.setUnlocalizedName("filament");
    }
}
