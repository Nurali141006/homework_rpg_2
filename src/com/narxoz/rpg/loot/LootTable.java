package com.narxoz.rpg.loot;

import java.util.List;
import java.util.ArrayList;

public class LootTable {
    private List<String> items;

    public LootTable() {
        items = new ArrayList<>();
    }

    public LootTable(List<String> items) {
        this.items = new ArrayList<>(items);
    }

    public List<String> getItems() {
        return items;
    }

    public void addItem(String item) {
        items.add(item);
    }

    public LootTable clone() {
        return new LootTable(new ArrayList<>(items));
    }

    public void display() {
        System.out.println("Loot: " + items);
    }
}
