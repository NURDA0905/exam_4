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

    private int getIncreaseAmount() {
        if (age <= 5) return 7;
        if (age <= 10) return 5;
        return 4;
    }

    private int getDecreaseAmount() {
        if (age <= 5) return 3;
        if (age <= 10) return 5;
        return 6;
    }

    public void feed() {
        int inc = getIncreaseAmount();
        health = Math.min(100, health + inc);
        mood = Math.min(100, mood + inc);
        // no satiety decrease in feed
    }

    public void play() {
        int inc = getIncreaseAmount();
        int dec = getDecreaseAmount();
        health = Math.min(100, health + inc);
        mood = Math.min(100, mood + inc);
        satiety = Math.max(0, satiety - dec);
    }

    public void heal() {
        int inc = getIncreaseAmount();
        int dec = getDecreaseAmount();
        health = Math.min(100, health + inc);
        mood = Math.min(100, mood + inc);
        satiety = Math.max(0, satiety - dec);
    }

    public double getAverage() {
        return (health + mood + satiety) / 3.0;
    }
}
