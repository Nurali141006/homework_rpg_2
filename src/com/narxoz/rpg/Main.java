package com.narxoz.rpg;

import com.narxoz.rpg.enemy.*;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System Demo ===\n");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        List<Ability> fireAbilities = fireFactory.createAbilities();
        LootTable fireLoot = fireFactory.createLootTable();
        String fireAI = fireFactory.createAIBehavior();
        System.out.println("Fire Components:");
        fireAbilities.forEach(a -> System.out.println("- " + a.getName()));
        fireLoot.display();
        System.out.println("AI: " + fireAI + "\n");

        Enemy dragon = new BossEnemyBuilder()
                .setName("Ancient Fire Dragon")
                .setHealth(80000)
                .setDamage(300)
                .addAbility(new FlameBreath())
                .addAbility(new FireShield())
                .addPhase(1,80000)
                .addPhase(2,30000)
                .setLootTable(fireLoot)
                .setAI(fireAI)
                .setCanFly(true)
                .setHasBreathAttack(true)
                .setWingspan(20)
                .build();
        dragon.displayInfo();
        System.out.println();

        
        EnemyDirector director = new EnemyDirector(new BossEnemyBuilder());
        Enemy fireBoss = director.createRaidBoss(new FireComponentFactory());
        System.out.println("Fire Boss created by Director:");
        fireBoss.displayInfo();
        System.out.println();
        Enemy iceBoss = director.createRaidBoss(new IceComponentFactory());
        System.out.println("Ice Boss created by Director:");
        iceBoss.displayInfo();
        Enemy shadowBoss = director.createRaidBoss(new ShadowComponentFactory());
        System.out.println("Shadow Boss created by Director:");
        shadowBoss.displayInfo();
        System.out.println();

        EnemyRegistry registry = new EnemyRegistry();
        registry.registerTemplate("dragon", dragon);
        Enemy eliteDragon = registry.createFromTemplate("dragon");
        eliteDragon.multiplyStats(2.0);
        System.out.println("Elite Dragon:");
        eliteDragon.displayInfo();
        System.out.println();

        Enemy goblinTemplate = new Goblin("Forest Goblin");
        registry.registerTemplate("goblin", goblinTemplate);
        Enemy eliteGoblin = registry.createFromTemplate("goblin");
        eliteGoblin.multiplyStats(2.0);
        System.out.println("Elite Goblin:");
        eliteGoblin.displayInfo();
        System.out.println();
    }
    
}
