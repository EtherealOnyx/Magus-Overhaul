package com.etherealonyx.magusoverhaul.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;


public class EntityEffectStorage implements Capability.IStorage<IEntityEffect> {

    @Override
    public NBTBase writeNBT(Capability<IEntityEffect> capability, IEntityEffect instance, EnumFacing side) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("EntityEffectType", instance.getEffectType());
        nbt.setInteger("EntityEffectPhase", instance.getPhase());
        nbt.setInteger("EntityEffectDuration", instance.getDuration());

        return nbt;

    }

    @Override
    public void readNBT(Capability<IEntityEffect> capability, IEntityEffect instance, EnumFacing side, NBTBase nbt) {
        instance.setEffectType(((NBTTagCompound) nbt).getInteger(
                "EntityEffectType"));
        instance.setPhase(((NBTTagCompound) nbt).getInteger(
                "EntityEffectPhase"));
        instance.setDuration(((NBTTagCompound) nbt).getInteger(
                "EntityEffectDuration"));
    }
}
