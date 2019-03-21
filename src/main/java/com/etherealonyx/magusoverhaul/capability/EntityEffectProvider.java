package com.etherealonyx.magusoverhaul.capability;

import com.etherealonyx.magusoverhaul.capability.effects.interfaces.IEntityEffect;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;


public class EntityEffectProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IEntityEffect.class)
    public static final Capability<IEntityEffect> ENTITY_EFFECT_CAP = null;

    private IEntityEffect instance = ENTITY_EFFECT_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        return capability == ENTITY_EFFECT_CAP;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        return capability == ENTITY_EFFECT_CAP ?
                ENTITY_EFFECT_CAP.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT()
    {
        return ENTITY_EFFECT_CAP.getStorage().writeNBT(ENTITY_EFFECT_CAP, this.instance,
                null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
        ENTITY_EFFECT_CAP.getStorage().readNBT(ENTITY_EFFECT_CAP, this.instance, null,
                nbt);
    }

}
