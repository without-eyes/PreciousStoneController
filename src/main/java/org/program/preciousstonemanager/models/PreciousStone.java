package org.program.preciousstonemanager.models;

public class PreciousStone extends Stone {
    public PreciousStone(String name, String color, int weight, int value, int transparency, Boolean isInNecklace) {
        super(name, color, weight, value, transparency, isInNecklace);
    }

    @Override
    public String getType() {
        return "дорогоцінний";
    }

    @Override
    public String getAsString() {
        return name + " (" +
                "Тип: дорогоцінний" +
                ", Колір: " + color +
                ", Маса: " + weight +
                ", Вартість: " + value +
                ", Процент прозорості: " + transparency + ")";
    }
}
