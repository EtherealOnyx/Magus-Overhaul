package com.etherealonyx.magusoverhaul.proxy;

import com.etherealonyx.magusoverhaul.capability.EntityEffectStorage;
import com.etherealonyx.magusoverhaul.capability.effects.LivingEntityEffect;
import com.etherealonyx.magusoverhaul.capability.effects.interfaces.IEntityEffect;
import net.minecraft.item.Item;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CommonProxy {
    public void registerItemRenderer(Item item, int meta, String id) {
        //Do nothing, because this is server side as well.
    }

    public void registerCapabilities() {
        CapabilityManager.INSTANCE.register(IEntityEffect.class,
                new EntityEffectStorage(), LivingEntityEffect.class);
    }



}
