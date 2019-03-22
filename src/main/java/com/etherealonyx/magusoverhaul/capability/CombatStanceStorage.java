package com.etherealonyx.magusoverhaul.capability;

import com.etherealonyx.magusoverhaul.capability.effects.interfaces.ICombatStance;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.capabilities.Capability;

public class CombatStanceStorage implements Capability.IStorage<ICombatStance> {

    @Override
    public NBTBase writeNBT(Capability<ICombatStance> capability, ICombatStance instance, EnumFacing side) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setBoolean("CombatStanceActive", instance.isActive());
        return nbt;

    }

    @Override
    public void readNBT(Capability<ICombatStance> capability, ICombatStance instance, EnumFacing side, NBTBase nbt) {
        instance.setActive(((NBTTagCompound) nbt).getBoolean("CombatStanceActive"));
    }
}
