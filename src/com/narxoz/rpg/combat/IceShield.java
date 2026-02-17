package com.narxoz.rpg.combat;

public class IceShield implements Ability {
    public String getName() { return "Ice Shield"; }
    public int getDamage() { return 0; }
    public String getDescription() { return "Defensive ice buff"; }
    public Ability clone() { return new IceShield(); }
}