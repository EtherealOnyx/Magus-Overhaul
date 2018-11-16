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
    public IEntityEffect setEffectType(int effectType) {
        this.effectType = effectType;
        return this;
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
        System.out.println(effectPhase);
    }

    @Override
    public int doDurationTick() {
        System.out.println(effectDuration);
        return effectDuration--;
    }

    @Override
    public void reset() {
        effectType = 0;
        effectPhase = 0;
        effectDuration = 0;
        System.out.println("Reset Capability");
    }
}
