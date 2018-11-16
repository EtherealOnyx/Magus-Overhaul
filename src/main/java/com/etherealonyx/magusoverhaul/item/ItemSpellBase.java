package com.etherealonyx.magusoverhaul.item;

import com.etherealonyx.magusoverhaul.capability.EntityEffectProvider;
import com.etherealonyx.magusoverhaul.capability.IEntityEffect;
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

        IEntityEffect effect = playerIn.getCapability(
                EntityEffectProvider.ENTITY_EFFECT_CAP, null);
        if (effect.getEffectType() == 0) effect.setEffectType(1).setDuration(15).setPhase(0);

        return new ActionResult<ItemStack>(EnumActionResult.PASS,
                playerIn.getHeldItem(handIn));
    }
}
