package com.etherealonyx.magusoverhaul.client.gui;

import com.etherealonyx.magusoverhaul.event.MOEventHandler;
import net.minecraft.client.gui.GuiScreen;

public class GuiControlled extends GuiScreen {

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void initGui() {
        MOEventHandler.settingFocus = true;
        MOEventHandler.mc.setIngameFocus();
    }

}
