package com.etherealonyx.magusoverhaul.capability;

import com.etherealonyx.magusoverhaul.capability.effects.interfaces.IEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.capabilities.Capability;


public class EntityEffectStorage implements Capability.IStorage<IEntityEffect> {

    @Override
    public NBTBase writeNBT(Capability<IEntityEffect> capability, IEntityEffect instance, EnumFacing side) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("EntityEffectPhase", instance.getPhase());
        nbt.setInteger("EntityEffectDuration", instance.getDuration());
        nbt.setDouble("EntityEffectStrength", instance.getStrength());
        nbt.setInteger("EntityEffectType", instance.getType());
        if (instance.getMovement() != null) {
            nbt.setDouble("EntityEffectMovementX", instance.getMovement().x);
            nbt.setDouble("EntityEffectMovementY", instance.getMovement().y);
            nbt.setDouble("EntityEffectMovementZ", instance.getMovement().z);
        } else {
            nbt.setDouble("EntityEffectMovementX", 0);
            nbt.setDouble("EntityEffectMovementY", 0);
            nbt.setDouble("EntityEffectMovementZ", 0);
        }
        nbt.setDouble("EntityEffectOrigin", instance.getOrigin());
        return nbt;

    }

    @Override
    public void readNBT(Capability<IEntityEffect> capability, IEntityEffect instance, EnumFacing side, NBTBase nbt) {
        instance.setPhase(((NBTTagCompound) nbt).getInteger("EntityEffectPhase"))
                .setDuration(((NBTTagCompound) nbt).getInteger("EntityEffectDuration"))
                .setStrength(((NBTTagCompound) nbt).getDouble("EntityEffectDuration"))
                .setType(((NBTTagCompound) nbt).getInteger("EntityEffectType"))
                .setMovement(new Vec3d(((NBTTagCompound) nbt).getDouble(
                "EntityEffectMovementX"),((NBTTagCompound) nbt).getDouble(
                "EntityEffectMovementY"),((NBTTagCompound) nbt).getDouble(
                "EntityEffectMovementZ")))
                .setOrigin(((NBTTagCompound) nbt).getDouble("EntityEffectOrigin"));
    }
}
