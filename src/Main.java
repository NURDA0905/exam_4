package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Peach", 11, 78, 86, 50));
        cats.add(new Cat("Jasper", 12, 83, 39, 43));
        cats.add(new Cat("Poppy", 9, 38, 57, 71));

        cats.sort(Comparator.comparingDouble(Cat::getAverage).reversed());
        
        printTable(cats);
    }

    public static void printTable(List<Cat> cats) {
        String format = "| %-2s | %-6s | %-7s | %-9s | %-11s | %-8s | %-15s |\n";
        String line = "+----+--------+---------+-----------+-------------+----------+-----------------+";

        System.out.println(line);
        System.out.printf(format, "#", "имя", "возраст", "здоровье", "настроение", "сытость", "средний уровень");
        System.out.println(line);

        int index = 1;
        for (Cat cat : cats) {
            System.out.printf(format,
                    index++,
                    cat.name,
                    String.format("%.1f", cat.age),
                    String.format("%.1f", cat.health),
                    String.format("%.1f", cat.mood),
                    String.format("%.1f", cat.satiety),
                    String.format("%.1f", cat.getAverage()));
        }

        System.out.println(line);
    }
}
