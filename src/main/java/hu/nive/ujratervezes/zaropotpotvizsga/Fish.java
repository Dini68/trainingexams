package hu.nive.ujratervezes.zaropotpotvizsga;

public abstract class Fish {

    private String name;
    private int weight;
    private String color;

    public void addWeight(int weight) {
        this.weight += weight;
    }

    public Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String status() {
        return name + ", weight: " + weight + ", color: " + color + ", short term memory loss: " + hasMemoryLoss();
    }

    public abstract void feed();

    public abstract boolean hasMemoryLoss();
}
