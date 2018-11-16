package com.etherealonyx.magusoverhaul.event;

import com.etherealonyx.magusoverhaul.capability.EntityEffectProvider;
import com.etherealonyx.magusoverhaul.capability.IEntityEffect;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MOEventHandler {

    @SubscribeEvent
    public void onEntityLivingUpdate(LivingEvent.LivingUpdateEvent event) {
            switch(event.getEntityLiving().getCapability(
                    EntityEffectProvider.ENTITY_EFFECT_CAP, null).getEffectType()) {
                case 1:
                    //Aerial
                    if (!event.getEntityLiving().getEntityWorld().isRemote) {
                        doAerial(event.getEntityLiving(),
                                event.getEntityLiving().getCapability(
                                        EntityEffectProvider.ENTITY_EFFECT_CAP,
                                        null));
                    }
                    break;
                case 2:
                    //Knockback
                    break;
                case 3:
                    //Stun
                    break;
                case 4:
                    //Knockdown
                    break;
                default:
            }

    }

    public void doAerial(EntityLivingBase entity, IEntityEffect cap) {
        switch(cap.getPhase()) {
            case 0:
                entity.motionY = .9F;
                cap.changeStatus();
                changeMovementStatus(true);
                break;
            case 1:
                if (entity.motionY < 0) {
                    entity.setNoGravity(true);
                    cap.changeStatus();
                    entity.motionY = 0;
                }
                break;
            case 2:
                if (cap.doDurationTick() <= 0) {
                    entity.setNoGravity(false);
                    cap.changeStatus();
                }
                break;
            case 3:
                if (entity.onGround) {
                    cap.reset();
                    changeMovementStatus(false);
                }
                break;
        }
    }

    public void changeMovementStatus(boolean disable) {
        for (int i = 0; i < Minecraft.getMinecraft().gameSettings.keyBindings.length; i++) {
            ((MOKeyBinding) Minecraft.getMinecraft().gameSettings.keyBindings[i]).changeInputStatus(disable);
        }
    }



}
