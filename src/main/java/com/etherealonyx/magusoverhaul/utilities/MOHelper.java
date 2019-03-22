package com.etherealonyx.magusoverhaul.utilities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

public class MOHelper {

    @SideOnly(Side.CLIENT)
    public static Minecraft mc = Minecraft.getMinecraft();

    @SideOnly(Side.CLIENT)
    public static boolean sF = false;

}
