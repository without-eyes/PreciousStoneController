package program.stones;

public abstract class Stone {
    protected String name;
    protected String color;
    protected int weight;
    protected int value;
    protected int transparency;

    protected Stone(String name, String color, int weight, int value, int transparency) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.value = value;
        this.transparency = transparency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return "Stone";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public String getAsString() {
        return null;
    }
}
