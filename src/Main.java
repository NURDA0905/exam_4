package src;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<Cat> cats = new ArrayList<>();

        System.out.print("Введите количество кошек: ");
        int numberOfCats = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numberOfCats; i++) {
            System.out.printf("Введите имя кошки %d: ", i + 1);
            String name = scanner.nextLine();

            System.out.printf("Введите возраст кошки %d: ", i + 1);
            double age = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            double health = 20 + random.nextInt(61);   // 20 to 80
            double mood = 20 + random.nextInt(61);
            double satiety = 20 + random.nextInt(61);

            cats.add(new Cat(name, age, health, mood, satiety));
        }
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
