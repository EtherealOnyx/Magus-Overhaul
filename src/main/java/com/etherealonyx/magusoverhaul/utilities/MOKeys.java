package com.etherealonyx.magusoverhaul.utilities;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

public class MOKeys {
    public static KeyBinding[] keyBindings;
    public static final int COMBAT_STANCE = 0;

    @SideOnly(Side.CLIENT)
    public static boolean isKeyPressed(KeyBinding key) {
        return Keyboard.isKeyDown(key.getKeyCode());
    }

    @SideOnly(Side.CLIENT)
    public static boolean isKeyPressed(int keyCode) {
        return Keyboard.isKeyDown(keyCode);
    }

    @SideOnly(Side.CLIENT)
    public static boolean isKeyPressed(int keyType, int keyCode) {
        //keyBindings[keyType].getKeyCode()
        return true;
    }

    public static KeyBinding key(int keyType) {
        return keyBindings[keyType];
    }
    public static int keyCode(int keyType) {
        return keyBindings[keyType].getKeyCode();
    }
}
