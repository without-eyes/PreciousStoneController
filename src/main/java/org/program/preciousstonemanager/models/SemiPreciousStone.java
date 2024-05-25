package org.program.preciousstonemanager.models;

public class SemiPreciousStone extends Stone {
    public SemiPreciousStone(String name, String color, int weight, int value, int transparency, Boolean isInNecklace) {
        super(name, color, weight, value, transparency, isInNecklace);
    }

    @Override
    public String getType() {
        return "напівкоштовний";
    }

    @Override
    public String getAsString() {
        return name + " (" +
                "Тип: напівкоштовний" +
                ", Колір: " + color +
                ", Маса: " + weight +
                ", Вартість: " + value +
                ", Процент прозорості: " + transparency + ")";
    }
}
