package com.narxoz.rpg.combat;

public class FlameBreath implements Ability {
    public String getName() { return "Flame Breath"; }
    public int getDamage() { return 70; }
    public String getDescription() { return "AoE fire damage with burn effect"; }
    public Ability clone() { return new FlameBreath(); }
}