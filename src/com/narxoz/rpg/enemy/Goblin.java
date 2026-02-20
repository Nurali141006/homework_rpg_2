package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;
import java.util.ArrayList;

public class Goblin implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private List<Ability> abilities;
    private LootTable lootTable;
    private String element;

    public Goblin(String name) {
        this.name = name;
        this.health = 150;
        this.damage = 25;
        this.defense = 10;
        this.speed = 55;
        this.abilities = new ArrayList<>();
        this.lootTable = new LootTable();
        this.element = "NONE";
    }
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public List<Ability> getAbilities() { return abilities; }
    public LootTable getLootTable() { return lootTable; }

    public void displayInfo() {
        System.out.println("=== " + name + " (Goblin) ===");
        System.out.println("HP: " + health + " | DMG: " + damage + " | DEF: " + defense + " | SPD: " + speed);
        System.out.println("Element: " + element);
        System.out.println("Abilities: " + abilities.size());
        lootTable.display();
    }
    public Enemy clone() {
        Goblin copy = new Goblin(this.name);
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;
        copy.element = this.element;
        copy.abilities = new ArrayList<>();
        for (Ability a : abilities) {
            copy.abilities.add(a.clone());
        }
        copy.lootTable = lootTable.clone();
        return copy;
    }
    public void multiplyStats(double multiplier) {
        this.health *= multiplier;
        this.damage *= multiplier;
        this.defense *= multiplier;
        this.speed *= multiplier;
    }
    public void setElement(String element) {
        this.element = element;
    }
    public void addAbility(Ability ability) {
        abilities.add(ability);
    }
}
