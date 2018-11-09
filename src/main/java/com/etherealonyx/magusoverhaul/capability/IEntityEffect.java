package com.etherealonyx.magusoverhaul.capability;

public interface IEntityEffect {

    public boolean isInEffect();

    /*switch(instance.getEffectType()) {
    case NONE:
        nbt.setInteger("EntityEffectType", 0);
        break;
    case AERIAL:
        nbt.setInteger("EntityEffectType", 1);
        break;
    case KNOCKBACK:
        nbt.setInteger("EntityEffectType", 2);
        break;
    case STUN:
        nbt.setInteger("EntityEffectType", 3);
        break;
    case KNOCKDOWN:
        nbt.setInteger("EntityEffectType", 4);
        break;
    default:
        nbt.setInteger("EntityEffectType", 0);
}*/

    public void addEffect(int effectType, int effectPhase,
                          int effectDuration);
    public void changeStatus();

    public int getPhase();
    public int getDuration();
    public int getEffectType();
    public void setPhase(int effectPhase);
    public void setDuration(int effectDuration);
    public void setEffectType(int effectType);
    public void doDurationTick();

}
