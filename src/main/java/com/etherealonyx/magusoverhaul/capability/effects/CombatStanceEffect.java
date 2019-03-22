package com.etherealonyx.magusoverhaul.capability.effects;

import com.etherealonyx.magusoverhaul.capability.effects.interfaces.ICombatStance;
import com.etherealonyx.magusoverhaul.client.gui.GuiControlled;
import com.etherealonyx.magusoverhaul.utilities.MOHelper;

public class CombatStanceEffect implements ICombatStance {

    private boolean isActive = false;
    private boolean isActiveGUI = false;
    private int cooldown = 0;

    @Override
    public ICombatStance setActive(boolean active) {
        if (isActive != active)
            toggle();
        return this;
    }
    @Override
    public ICombatStance setActiveGUI(boolean active) {
        isActiveGUI = active;
        return this;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public boolean isActiveGUI() { return isActiveGUI; }

    @Override
    public void update() {
        if (cooldown > 0)
            cooldown--;
    }

    @Override
    public void toggle() {
        if (cooldown <= 0) {
            cooldown = 40;
            isActive = !isActive;
            isActiveGUI = !isActiveGUI;
            if (isActive)
                MOHelper.mc.displayGuiScreen(new GuiControlled());
            else
                MOHelper.mc.displayGuiScreen(null);
        }
    }
}
