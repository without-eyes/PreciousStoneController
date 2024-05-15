package org.program.stones;

public class SemiPreciousStone extends Stone {
    public SemiPreciousStone(String name, String color, int weight, int value, int transparency) {
        super(name, color, weight, value, transparency);
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
