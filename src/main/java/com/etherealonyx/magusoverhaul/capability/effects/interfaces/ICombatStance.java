package com.etherealonyx.magusoverhaul.capability.effects.interfaces;

public interface ICombatStance {
    boolean isActive();
    boolean isActiveGUI();
    ICombatStance setActiveGUI(boolean isActiveGUI);
    ICombatStance setActive(boolean isActive);
    void update();
    void toggle();
}
