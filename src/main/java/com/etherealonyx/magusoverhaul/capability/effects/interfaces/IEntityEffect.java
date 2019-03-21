package com.etherealonyx.magusoverhaul.capability.effects.interfaces;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.Vec3d;

public interface IEntityEffect {

    boolean isInEffect();

    double getStrength();
    IEntityEffect setStrength(double effectStrength);

    IEntityEffect reset();

    int getPhase();
    IEntityEffect setPhase(int effectPhase);
    void changeStatus();

    IEntityEffect setDuration(int effectDuration);
    int getDuration();
    int doDurationTick();

    IEntityEffect setMovement(Vec3d pos);
    Vec3d getMovement();

    int getType();
    IEntityEffect setType(int effectType);

    double getOrigin();
    IEntityEffect setOrigin(double origin);

    void update(EntityLivingBase target);

}