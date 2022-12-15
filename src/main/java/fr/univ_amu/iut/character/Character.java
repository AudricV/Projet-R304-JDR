package fr.univ_amu.iut.character;

import com.opencsv.bean.CsvBindByName;

// Suppress unused warnings, as setters are not used in the project but used by OpenCSV
@SuppressWarnings("unused")
public class Character {
    @CsvBindByName(required = true, column = "TYPE")
    private String type;
    @CsvBindByName(column = "NAME")
    private String name;
    @CsvBindByName(required = true, column = "LVL")
    private int level;
    @CsvBindByName(required = true, column = "HP")
    private int healthPoints;
    @CsvBindByName(required = true, column = "DEF")
    private int defense;
    @CsvBindByName(required = true, column = "STR")
    private int strength;
    @CsvBindByName(required = true, column = "XP")
    private int xp;
    @CsvBindByName(required = true, column = "GOLD")
    private int goldAmount;
    @CsvBindByName(column = "ITEMS")
    private String items;
    @CsvBindByName(column = "POWERS")
    private String powers;

    public Character() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getGoldAmount() {
        return goldAmount;
    }

    public void setGoldAmount(int goldAmount) {
        this.goldAmount = goldAmount;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getPowers() {
        return powers;
    }

    public void setPowers(String powers) {
        this.powers = powers;
    }

    @Override
    public String toString() {
        return "Character{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", healthPoints=" + healthPoints +
                ", defense=" + defense +
                ", strength=" + strength +
                ", xp=" + xp +
                ", goldAmount=" + goldAmount +
                ", items=" + items +
                ", powers=" + powers +
                '}';
    }
}
