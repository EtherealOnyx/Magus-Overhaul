package com.etherealonyx.magusoverhaul.item;

import com.etherealonyx.magusoverhaul.capability.EntityEffectProvider;
import com.etherealonyx.magusoverhaul.capability.effects.interfaces.IEntityEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemSpellBase extends ItemBase {

    public ItemSpellBase(String name) {
        super(name);
    }

    /**
     * Called when the equipped item is right clicked.
     */
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        System.out.println(playerIn.getPitchYaw().x);
        System.out.println(playerIn.getPitchYaw().y);
        IEntityEffect effect = playerIn.getCapability(
                EntityEffectProvider.ENTITY_EFFECT_CAP, null);
        //TODO: Fix Position Vector for proper knockback.
        if (effect.getType() == 0) effect.setType(1);

        return new ActionResult<ItemStack>(EnumActionResult.PASS,
                playerIn.getHeldItem(handIn));
    }
}
