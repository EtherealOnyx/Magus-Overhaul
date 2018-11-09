package com.etherealonyx.magusoverhaul.capability;

public class LivingEntityEffect implements IEntityEffect {

    public int effectType = 0;
    public int effectPhase = 0;
    public int effectDuration = 0;

    @Override
    public boolean isInEffect() {
        return effectType > 0;
    }

    @Override
    public void addEffect(int effectType, int effectPhase,
                          int effectDuration) {
        if (effectType > 0) {
            this.effectType = effectType;
            this.effectDuration = effectDuration;
            this.effectPhase = effectPhase;
        }

    }

    @Override
    public void setPhase(int effectPhase) {
        this.effectPhase = effectPhase;
    }

    @Override
    public void setDuration(int effectDuration) {
        this.effectDuration = effectDuration;
    }

    @Override
    public void setEffectType(int effectType) {
        this.effectType = effectType;
    }

    @Override
    public int getEffectType() {
        return effectType;
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
    public void changeStatus() {
        effectPhase++;
    }

    @Override
    public void doDurationTick() {
        if (effectDuration > 0)
            effectDuration--;
    }
}
