package program.stones;

public class PreciousStone extends Stone {
    public PreciousStone(String name, String color, int weight, int value, int transparency) {
        super(name, color, weight, value, transparency);
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
