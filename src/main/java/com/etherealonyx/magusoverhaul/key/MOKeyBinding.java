package com.etherealonyx.magusoverhaul.key;


import net.minecraft.client.settings.KeyBinding;

import static com.etherealonyx.magusoverhaul.MagusOverhaul.MODID;

public class MOKeyBinding extends KeyBinding {

    public MOKeyBinding(String controlType, int keyCode) {
        super("key." + controlType + ".desc", keyCode, "key." + MODID + ".category");

    }

}
