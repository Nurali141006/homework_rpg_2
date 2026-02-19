package com.narxoz.rpg.combat;

public class DarkNova implements Ability {
    public String getName() { return"Dark Nova" ; }
    public int getDamage() { return 400; }
    public String getDescription() { return "Releases a burst of dark energy.";}
    public Ability clone() { return new ShadowStrike();}

    }