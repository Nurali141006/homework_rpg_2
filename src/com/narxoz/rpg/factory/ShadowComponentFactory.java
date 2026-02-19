package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;
import java.util.ArrayList;

public class ShadowComponentFactory implements EnemyComponentFactory {
    public List<Ability> createAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new ShadowStrike());
        abilities.add(new Vanish());
        abilities.add(new DarkNova());
        return abilities;
    }

    public LootTable createLootTable() {
        LootTable loot = new LootTable();
        loot.addItem("Shadow Gem");
        loot.addItem("Dark Essence");
        loot.addItem("Shadow Rune");
        return loot;
    }

    public String createAIBehavior() {
        return "TACTICAL";
    }
}


