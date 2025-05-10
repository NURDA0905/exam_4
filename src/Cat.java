package src;

public class Cat {
    String name;
    double age;
    double health;
    double mood;
    double satiety;

    public Cat(String name, double age, double health, double mood, double satiety) {
        this.name = name;
        this.age = age;
        this.health = health;
        this.mood = mood;
        this.satiety = satiety;
    }

    public double getAverage() {
        return (health + mood + satiety) / 3.0;
    }
}
