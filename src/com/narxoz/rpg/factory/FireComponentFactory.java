package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;
import java.util.ArrayList;

public class FireComponentFactory implements EnemyComponentFactory {
    public List<Ability> createAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new FlameBreath());
        abilities.add(new FireShield());
        return abilities;
    }
    public LootTable createLootTable() {
        LootTable loot = new LootTable();
        loot.addItem("Fire Gem");
        loot.addItem("Dragon Scale");
        loot.addItem("Flame Rune");
        return loot;
    }
    public String createAIBehavior() { return "AGGRESSIVE"; }
}
