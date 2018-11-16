package com.etherealonyx.magusoverhaul.event;


import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MOKeyBinding extends KeyBinding {
    boolean enableInput = true;


    public MOKeyBinding(KeyBinding key) {
        super(key.getKeyDescription(), key.getKeyConflictContext(),
                key.getKeyModifier(), key.getKeyCode(), key.getKeyCategory());

        System.out.println("Changed Keybinding...");
    }

    public void changeInputStatus(boolean disabled) {
        enableInput = !(disabled);
    }


    @Override
    public boolean isPressed() {
        boolean isPressed = false;

        if (enableInput) isPressed = super.isPressed();
        System.out.println(isPressed);
        return isPressed;
    }

}
