package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class DragonBoss implements Enemy {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities;
    private Map<Integer, Integer> phases;
    private LootTable lootTable;
    private String aiBehavior;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    public DragonBoss(String name, int health, int damage, int defense, int speed,
               String element, List<Ability> abilities,
               Map<Integer,Integer> phases, LootTable lootTable,
               String aiBehavior, boolean canFly, boolean hasBreathAttack, int wingspan) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = abilities != null ? abilities : new ArrayList<>();
        this.phases = phases != null ? phases : new HashMap<>();
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
    }
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public List<Ability> getAbilities() { return abilities; }
    public LootTable getLootTable() { return lootTable; }

    public void displayInfo() {
        System.out.println("=== " + name + " (Dragon Boss) ===");
        System.out.println("HP: " + health + " | DMG: " + damage + " | DEF: " + defense + " | SPD: " + speed);
        System.out.println("Element: " + element + " | AI: " + aiBehavior);
        System.out.println("Abilities: " + abilities.size());
        for (Map.Entry<Integer,Integer> phase : phases.entrySet()) {
            System.out.println("Phase " + phase.getKey() + ": triggers at " + phase.getValue() + " HP");
        }
        lootTable.display();
        System.out.println("Fly: " + canFly + " | Breath: " + hasBreathAttack + " | Wingspan: " + wingspan);
    }
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : abilities) clonedAbilities.add(a.clone());
        Map<Integer,Integer> clonedPhases = new HashMap<>(phases);
        LootTable clonedLoot = lootTable.clone();
        return new DragonBoss(name, health, damage, defense, speed, element,
                              clonedAbilities, clonedPhases, clonedLoot,
                              aiBehavior, canFly, hasBreathAttack, wingspan);
    }
    public void multiplyStats(double multiplier) {
        health *= multiplier;
        damage *= multiplier;
        defense *= multiplier;
        speed *= multiplier;
    }
    public void setElement(String element) {
        this.element = element;
    }
    public void addAbility(Ability ability) {
        abilities.add(ability);
    }
    public void addPhase(int phase, int threshold) {
        if (phases == null) phases = new HashMap<>();
        phases.put(phase, threshold);
    }
}
