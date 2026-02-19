package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;
import java.util.ArrayList;

public class IceComponentFactory implements EnemyComponentFactory {
    public List<Ability> createAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new FrostBreath());
        return abilities;
    }
    public LootTable createLootTable() {
        LootTable loot = new LootTable();
        loot.addItem("Ice Gem");
        loot.addItem("Frost Scale");
        loot.addItem("Ice Rune");
        return loot;
    }
    public String createAIBehavior() { return "DEFENSIVE"; }
}
