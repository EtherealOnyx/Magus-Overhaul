package com.etherealonyx.magusoverhaul.capability.effects;

import com.etherealonyx.magusoverhaul.capability.effects.interfaces.IEntityEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.Vec3d;

import static com.etherealonyx.magusoverhaul.event.MOEventHandler.disableMovement;

public class LivingEntityEffect implements IEntityEffect {

    private int effectType = 0;
    private int effectPhase = 0;
    private int effectDuration = 0;
    private double effectStrength = 1;
    private Vec3d effectMovement = null;
    private double effectOrigin = 0;


    @Override
    public boolean isInEffect() {
        return effectType != 0;
    }

    @Override
    public IEntityEffect setPhase(int effectPhase) {
        this.effectPhase = effectPhase;
        return this;
    }

    @Override
    public IEntityEffect setDuration(int effectDuration) {
        this.effectDuration = effectDuration;
        return this;
    }


    @Override
    public IEntityEffect setStrength(double effectStrength) {
        this.effectStrength = effectStrength;
        return this;
    }

    @Override
    public int getPhase() {
        return effectPhase;
    }

    @Override
    public int getDuration() {
        return effectDuration;
    }

    @Override
    public double getStrength() { return effectStrength; }

    @Override
    public void changeStatus() {
        effectPhase++;
    }

    @Override
    public int doDurationTick() {
        return effectDuration--;
    }

    @Override
    public IEntityEffect reset() {
        effectType = 0;
        effectPhase = 0;
        effectDuration = 0;
        effectStrength = 0;
        effectMovement = null;
        effectOrigin = 0;
        disableMovement(false);
        return this;
    }

    public void doEffect(EntityLivingBase entity) {
        switch (getPhase()) {
            case 0:
                if (!validateEffect(entity)) {
                    System.out.println("An error has occurred applying this effect and has been terminated.");
                    reset();
                }
                switch(effectType) {
                    case 1: //Aerial
                        entity.motionY = 1F * getStrength();
                        entity.motionX = 0F;
                        entity.motionZ = 0F;
                        entity.isAirBorne = true;
                        break;
                    case 2: //Knockback
                        entity.motionY = 0F;
                        entity.posY += .01F;
                        entity.setNoGravity(true);
                        entity.motionZ = effectStrength * effectMovement.z * -1; //negated to reproduce knockback effect./
                        entity.motionX = effectStrength * effectMovement.x * -1;
                    case 3: //Stun
                        entity.motionX = 0F;
                        entity.motionY = 0F;
                        entity.motionZ = 0F;
                }
                changeStatus();
                disableMovement(true);
                break;
            case 1:
                if (effectType == 1) {
                    if (entity.motionY < 0) {
                        entity.setNoGravity(true);
                        changeStatus();
                        entity.motionY = 0;
                    }
                } else {
                    changeStatus();
                }
                break;
            case 2:
                if (doDurationTick() <= 0) {
                    if (effectType == 1)
                        entity.setNoGravity(false);
                    changeStatus();
                }
                break;
            case 3:
                if (effectType == 3) {
                    reset();
                    break;
                }

                if (entity.onGround || entity.isInWater() || entity.posY < effectOrigin ) {
                    reset();
                }
                break;
        }
    }

    public boolean validateEffect(EntityLivingBase entity) {
        if (effectStrength == 0)
            effectStrength = 1;
        if (effectDuration == 0)
            effectDuration = Math.abs((int)(10 * effectStrength));
        if (effectMovement == null)
            effectMovement = entity.getLookVec();
        if (effectOrigin == 0)
            effectOrigin = entity.posY;
        //TODO: Check if player is in Creative, and if so, is flying...also check if player has creative flight on.
        return true;
    }

    @Override
    public void update(EntityLivingBase entity) {
        if (isInEffect())
            doEffect(entity);
    }

    @Override
    public int getType() {
        return effectType;
    }

    @Override
    public IEntityEffect setType(int effectType) {
        this.effectType = effectType;
        return this;
    }

    @Override
    public IEntityEffect setMovement(Vec3d movement) {
        effectMovement = movement;
        return this;
    }

    @Override
    public Vec3d getMovement() {
        return effectMovement;
    }

    @Override
    public double getOrigin() {
        return effectOrigin;
    }

    @Override
    public IEntityEffect setOrigin(double origin) {
        effectOrigin = origin;
        return this;
    }


}
