package com.etherealonyx.magusoverhaul.proxy;

import com.etherealonyx.magusoverhaul.MagusOverhaul;
import com.etherealonyx.magusoverhaul.key.MOKeyBinding;
import com.etherealonyx.magusoverhaul.utilities.MOHelper;
import com.etherealonyx.magusoverhaul.utilities.MOKeys;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta,
                new ModelResourceLocation(MagusOverhaul.MODID + ":" + id,
                        "inventory"));

    }

    @Override
    public void initKeyBindings() {
        MOKeys.keyBindings = new MOKeyBinding[2];
        MOKeys.keyBindings[0] = new MOKeyBinding("toggleStance", Keyboard.KEY_TAB);
        MOKeys.keyBindings[1] = new MOKeyBinding("skillSlot1", Keyboard.KEY_1);

        for (int i = 0; i < MOKeys.keyBindings.length; i++)
            ClientRegistry.registerKeyBinding(MOKeys.keyBindings[i]);
    }

}
