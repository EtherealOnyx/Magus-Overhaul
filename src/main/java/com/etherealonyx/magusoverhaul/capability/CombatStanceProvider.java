package com.etherealonyx.magusoverhaul.capability;

import com.etherealonyx.magusoverhaul.capability.effects.interfaces.ICombatStance;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CombatStanceProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(ICombatStance.class)
    public static final Capability<ICombatStance> COMBAT_STANCE_CAP = null;

    private ICombatStance instance = COMBAT_STANCE_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        return capability == COMBAT_STANCE_CAP;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        return capability == COMBAT_STANCE_CAP ?
                COMBAT_STANCE_CAP.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT()
    {
        return COMBAT_STANCE_CAP.getStorage().writeNBT(COMBAT_STANCE_CAP, this.instance,
                null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
        COMBAT_STANCE_CAP.getStorage().readNBT(COMBAT_STANCE_CAP, this.instance, null,
                nbt);
    }
}
