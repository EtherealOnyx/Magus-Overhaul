package com.etherealonyx.magusoverhaul.capability;

import com.etherealonyx.magusoverhaul.MagusOverhaul;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
    public static final ResourceLocation ENTITY_EFFECT_CAP =
            new ResourceLocation(MagusOverhaul.MODID, "entityeffect");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof EntityLivingBase)) return;

        event.addCapability(ENTITY_EFFECT_CAP, new EntityEffectProvider());
    }
}
