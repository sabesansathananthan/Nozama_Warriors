package Nozama_warriors;

public abstract class Inhabitant {
    private String name;
    private int age;
    private int x;
    private int y;

    // Constructor to get inhabitant like fish an warrior
    public Inhabitant(String name, int age) {
        this.name = name;
        this.age = age;
        GUI.attach(this);
    }

    // Constructor to get inhabitant like LotusFlower
    public Inhabitant(String name) {
        this.name = name;
        GUI.attach(this);
    }

    // getter
    public int getAge() {
        return age;
    }

    // Setter
    public void setAge(int age) {
        this.age = age;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }
}
