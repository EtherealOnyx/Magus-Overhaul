package com.etherealonyx.magusoverhaul.proxy;

import com.etherealonyx.magusoverhaul.capability.CombatStanceStorage;
import com.etherealonyx.magusoverhaul.capability.EntityEffectStorage;
import com.etherealonyx.magusoverhaul.capability.effects.CombatStanceEffect;
import com.etherealonyx.magusoverhaul.capability.effects.LivingEntityEffect;
import com.etherealonyx.magusoverhaul.capability.effects.interfaces.ICombatStance;
import com.etherealonyx.magusoverhaul.capability.effects.interfaces.IEntityEffect;
import net.minecraft.item.Item;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CommonProxy {
    public void registerItemRenderer(Item item, int meta, String id) {
        //Do nothing, because this is server side as well.
    }

    public void initKeyBindings() {

    }

    public void registerCapabilities() {
        CapabilityManager.INSTANCE.register(IEntityEffect.class,
                new EntityEffectStorage(), LivingEntityEffect::new);
        CapabilityManager.INSTANCE.register(ICombatStance.class,
                new CombatStanceStorage(), CombatStanceEffect::new);
    }



}
