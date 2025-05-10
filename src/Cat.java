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
    public void feed() {
        satiety = Math.min(100, satiety + 10);
    }

    public void play() {
        mood = Math.min(100, mood + 10);
    }

    public void heal() {
        health = Math.min(100, health + 10);
    }
}
