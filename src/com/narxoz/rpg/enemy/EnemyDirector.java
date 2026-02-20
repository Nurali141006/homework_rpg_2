package com.narxoz.rpg.enemy;

import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {

    private BossEnemyBuilder builder;

    public EnemyDirector(BossEnemyBuilder builder) {
        this.builder = builder;
    }

    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        return builder
                .setName("Raid Boss")
                .setHealth(200_000)
                .setDamage(2000)
                .setDefense(300)
                .setSpeed(50)
                .setElement("THEME")  
                .setAI(factory.createAIBehavior())
                .setLootTable(factory.createLootTable())
                .addAbilityList(factory.createAbilities())
                .addPhase(1, 200_000)
                .addPhase(2, 50_000)
                .setCanFly(true)
                .setHasBreathAttack(true)
                .setWingspan(25)
                .build();
    }
}
