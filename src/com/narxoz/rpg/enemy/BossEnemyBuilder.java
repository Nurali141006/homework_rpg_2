package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BossEnemyBuilder {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities = new ArrayList<>();
    private Map<Integer,Integer> phases = new HashMap<>();
    private LootTable lootTable;
    private String aiBehavior;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    public BossEnemyBuilder setName(String name) { this.name = name; return this; }
    public BossEnemyBuilder setHealth(int health) { this.health = health; return this; }
    public BossEnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    public BossEnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    public BossEnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }
    public BossEnemyBuilder setElement(String element) { this.element = element; return this; }
    public BossEnemyBuilder addAbility(Ability ability) { abilities.add(ability); return this; }
    public BossEnemyBuilder addPhase(int phase, int threshold) { phases.put(phase, threshold); return this; }
    public BossEnemyBuilder setLootTable(LootTable loot) { this.lootTable = loot; return this; }
    public BossEnemyBuilder setAI(String ai) { this.aiBehavior = ai; return this; }
    public BossEnemyBuilder setCanFly(boolean canFly) { this.canFly = canFly; return this; }
    public BossEnemyBuilder setHasBreathAttack(boolean hasBreathAttack) { this.hasBreathAttack = hasBreathAttack; return this; }
    public BossEnemyBuilder setWingspan(int wingspan) { this.wingspan = wingspan; return this; }

    public Enemy build() {
        if (name == null || health <= 0) throw new IllegalStateException("Name & Health required");
        return new DragonBoss(name, health, damage, defense, speed,
                              element, abilities, phases, lootTable, aiBehavior,
                              canFly, hasBreathAttack, wingspan);
    }
    public BossEnemyBuilder addAbilityList(List<Ability> abilities) {
    this.abilities.addAll(abilities);
    return this;
}

}
