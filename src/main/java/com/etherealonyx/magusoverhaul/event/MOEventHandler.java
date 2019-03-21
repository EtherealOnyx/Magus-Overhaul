package com.etherealonyx.magusoverhaul.event;

import com.etherealonyx.magusoverhaul.capability.EntityEffectProvider;
import com.etherealonyx.magusoverhaul.capability.effects.interfaces.IEntityEffect;
import com.etherealonyx.magusoverhaul.client.gui.GuiControlled;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



public class MOEventHandler {

    @SideOnly(Side.CLIENT)
    public static Minecraft mc = Minecraft.getMinecraft();

    @SideOnly(Side.CLIENT)
    public static boolean settingFocus = false;

    @SubscribeEvent
    public void onEntityLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        IEntityEffect cap = event.getEntityLiving().getCapability(
                EntityEffectProvider.ENTITY_EFFECT_CAP, null);

        cap.update(event.getEntityLiving());
       /* switch (cap.getEffectType()) {
            case 1:
                //Aerial
                //Not sure if i have to check whether this is server or client...apparently I have to do motions
                // both client and server sides!?
                //if (!event.getEntityLiving().getEntityWorld().isRemote) {
                doAerial(event.getEntityLiving(),
                        cap);
                //}
                break;
        } */

    }

   /* public void doAerial(EntityLivingBase entity, IControllableEntityEffect cap) {
        switch (cap.getPhase()) {
            case 0:
                entity.motionY = 1F * cap.getEffectStrength();
                entity.motionX = 0F;
                entity.motionZ = 0F;
                entity.isAirBorne = true;
                cap.changeStatus();
                disableMovement(true);
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
                if (entity.onGround || entity.isInWater()) {
                    cap.reset();
                    disableMovement(false);
                }
                break;
        }
    } */

   /* public void doKnockback(EntityLivingBase entity, IControllableEntityEffect cap) {
        switch (cap.getPhase()) {
            case 0:
                entity.motionY = 0F;
                if (entity.onGround) {
                    entity.setNoGravity(true);
                    entity.posY += .01F; //This causes them to float.
                }
                entity.motionZ = cap.getEffectSource().getMotionZ(cap.getEffectStrength());
                entity.motionX = cap.getEffectSource().getMotionX(cap.getEffectStrength());
                cap.changeStatus();
                disableMovement(true);
                break;
            case 1:
                if (cap.doDurationTick() <= 0) {
                    System.out.println("T");
                    entity.setNoGravity(false);
                    cap.changeStatus();
                }
                break;
            case 2:
                    cap.reset();
                    disableMovement(false);
                break;
        }
    }*/

    @SideOnly(Side.CLIENT)
    public static void disableMovement(boolean disable) {
        if (disable) {
            Minecraft.getMinecraft().displayGuiScreen(new GuiControlled());
        } else {
            KeyBinding.updateKeyBindState();
            MOEventHandler.settingFocus = false;
            Minecraft.getMinecraft().displayGuiScreen(null);
        }
    }

    @SubscribeEvent
    public void guiOpening(GuiOpenEvent event) {
        if (settingFocus)
            event.setCanceled(true);
    }


}
