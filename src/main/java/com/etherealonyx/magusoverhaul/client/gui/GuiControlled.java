package com.etherealonyx.magusoverhaul.client.gui;

import com.etherealonyx.magusoverhaul.capability.CombatStanceProvider;
import com.etherealonyx.magusoverhaul.utilities.MOHelper;
import com.etherealonyx.magusoverhaul.utilities.MOKeys;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class GuiControlled extends GuiScreen {

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void initGui() {
        MOHelper.sF = true;
        MOHelper.mc.setIngameFocus();
        MOHelper.sF = false;
    }

    /**
     * Fired when a key is typed (except F11 which toggles full screen). This is the equivalent of
     * KeyListener.keyTyped(KeyEvent e). Args : character (character on the key), keyCode (lwjgl Keyboard key code)
     */
    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        if (MOKeys.keyCode(MOKeys.COMBAT_STANCE) == keyCode)
            MOHelper.mc.player.getCapability(CombatStanceProvider.COMBAT_STANCE_CAP, null).toggle();
    }

}
