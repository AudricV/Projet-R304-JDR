package fr.univ_amu.iut.item;

import com.opencsv.bean.CsvBindByName;

/**
 * An item of the game.
 *
 * <p>
 * Game items are elements such as powers, objects with an instant effect or portable objects (see
 * values of the enum {@link ItemType}).
 * </p>
 */
// Suppress unused warnings, as setters are not used in the project but used by OpenCSV
@SuppressWarnings("unused")
public class Item {
    @CsvBindByName(required = true, column = "TYPE")
    private ItemType itemType;
    @CsvBindByName(required = true, column = "NAME")
    private String name;
    @CsvBindByName(required = true, column = "TARGET")
    private Target target;
    @CsvBindByName(required = true, column = "EFFECT TYPE")
    private EffectType effectType;
    @CsvBindByName(required = true, column = "EFFECT OPERATION")
    private String effectOperation;
    @CsvBindByName(required = true, column = "DESCRIPTION")
    private String description;

    public Item() {
        // No arguments needed in the constructor
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public EffectType getEffectType() {
        return effectType;
    }

    public void setEffectType(EffectType effectType) {
        this.effectType = effectType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEffectOperation() {
        return effectOperation;
    }

    public void setEffectOperation(String effectOperation) {
        this.effectOperation = effectOperation;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemType=" + itemType +
                ", name='" + name + '\'' +
                ", target=" + target +
                ", effectType=" + effectType +
                ", effectOperation='" + effectOperation + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
