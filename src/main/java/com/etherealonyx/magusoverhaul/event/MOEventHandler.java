package com.etherealonyx.magusoverhaul.event;

import com.etherealonyx.magusoverhaul.capability.CombatStanceProvider;
import com.etherealonyx.magusoverhaul.capability.EntityEffectProvider;
import com.etherealonyx.magusoverhaul.client.gui.GuiControlled;
import com.etherealonyx.magusoverhaul.utilities.MOHelper;
import com.etherealonyx.magusoverhaul.utilities.MOKeys;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.etherealonyx.magusoverhaul.utilities.MOKeys.keyBindings;


public class MOEventHandler {


    @SubscribeEvent
    public void onEntityLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        event.getEntityLiving().getCapability(
                EntityEffectProvider.ENTITY_EFFECT_CAP, null).update(event.getEntityLiving());
    }


    @SideOnly(Side.CLIENT)
    public static void disableMovement(boolean disable) {
        if (disable) {
            System.out.println("++++++++++++++++++++DISABLING MOVEMENT++++++++++++++++++++");
            MOHelper.mc.displayGuiScreen(new GuiControlled());
            MOHelper.mc.player.getCapability(CombatStanceProvider.COMBAT_STANCE_CAP, null).setActive(true);
        } else {
            System.out.println("++++++++++++++++++++ENABLING  MOVEMENT++++++++++++++++++++");
            KeyBinding.updateKeyBindState();
            MOHelper.mc.player.getCapability(CombatStanceProvider.COMBAT_STANCE_CAP, null).setActive(false);
            MOHelper.mc.displayGuiScreen(null);
        }
    }

    @SubscribeEvent
    public void guiOpening(GuiOpenEvent event) {
        if (MOHelper.sF) {
            System.out.println("Setting focus for GuiControlled.");
            event.setCanceled(true);
            return;
        }
        if (!(event.getGui() instanceof GuiControlled)) {
            System.out.println("Our GUI isn't from GuiControlled");
            if (MOHelper.mc.player != null)
                if (MOHelper.mc.player.getCapability(CombatStanceProvider.COMBAT_STANCE_CAP, null).isActive()) {
                    System.out.println("Combat Stance IS active.");
                        if (event.getGui() == null) {
                            System.out.println("There are no active GUIs at this time.");
                            event.setGui(new GuiControlled());
                            MOHelper.mc.player.getCapability(CombatStanceProvider.COMBAT_STANCE_CAP, null).setActiveGUI(true);
                        } else {
                            System.out.println("GUI is active, so...uh...");
                            MOHelper.mc.player.getCapability(CombatStanceProvider.COMBAT_STANCE_CAP, null).setActiveGUI(false);
                        }
                } else {
                    System.out.println("Combat stance isn't active...");
                    //This call shouldn't be needed...
                    /*if (mc.player.getCapability(CombatStanceProvider.COMBAT_STANCE_CAP, null).isActiveGUI()) {
                        System.out.println("...but our GUI still wants to be active! Disabling...");
                        mc.player.getCapability(CombatStanceProvider.COMBAT_STANCE_CAP, null).setActiveGUI(false);
                    }*/
                }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    @SideOnly(Side.CLIENT )
    public void onEvent(InputEvent.KeyInputEvent event) {
        if (MOKeys.isKeyPressed(keyBindings[0]))
            toggleCombat();
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT )
    public void renderHud(RenderGameOverlayEvent event) {
        if (isInCombatGUI())
            event.setCanceled(true);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onClientUpdate(TickEvent.ClientTickEvent event) {
        if (MOHelper.mc.player != null) {
            MOHelper.mc.player.getCapability(CombatStanceProvider.COMBAT_STANCE_CAP, null).update();
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean isInCombatGUI() {
        return MOHelper.mc.player.getCapability(CombatStanceProvider.COMBAT_STANCE_CAP, null).isActiveGUI();
    }

    @SideOnly(Side.CLIENT)
    public void toggleCombat() {
        MOHelper.mc.player.getCapability(CombatStanceProvider.COMBAT_STANCE_CAP, null).toggle();
    }

}
