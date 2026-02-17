package com.narxoz.rpg.combat;

public class FrostBreath implements Ability {
    public String getName() { return "Frost Breath"; }
    public int getDamage() { return 50; }
    public String getDescription() { return "AoE ice damage with slow"; }
    public Ability clone() { return new FrostBreath(); }
}