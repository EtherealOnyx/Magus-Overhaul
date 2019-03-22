package com.etherealonyx.magusoverhaul.capability;

import com.etherealonyx.magusoverhaul.MagusOverhaul;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
    public static final ResourceLocation ENTITY_EFFECT_CAP =
            new ResourceLocation(MagusOverhaul.MODID, "entityeffect");
    public static final ResourceLocation COMBAT_STANCE_CAP =
            new ResourceLocation(MagusOverhaul.MODID, "combatstance");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if ((event.getObject() instanceof EntityLivingBase)) {
            event.addCapability(ENTITY_EFFECT_CAP, new EntityEffectProvider());
            if (event.getObject() instanceof EntityPlayer)
                event.addCapability(COMBAT_STANCE_CAP, new CombatStanceProvider());
        }



    }
}
