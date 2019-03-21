package com.etherealonyx.magusoverhaul.event;

import com.etherealonyx.magusoverhaul.capability.EntityEffectProvider;
import com.etherealonyx.magusoverhaul.client.gui.GuiControlled;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
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
        event.getEntityLiving().getCapability(
                EntityEffectProvider.ENTITY_EFFECT_CAP, null).update(event.getEntityLiving());
    }


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
