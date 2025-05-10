package src;

import java.util.List;

public class FormatTable {
    public static void printTable(List<Cat> cats) {
        String format = "| %-2s | %-6s | %-7s | %-9s | %-11s | %-8s | %-15s |\n";
        String line = "+----+--------+---------+-----------+-------------+----------+-----------------+";

        System.out.println(line);
        System.out.printf(format, "#", "имя", "возраст", "здоровье", "настроение", "сытость", "средний уровень");
        System.out.println(line);

        int index = 1;
        for (Cat cat : cats) {
            String nameDisplay = cat.actedToday ? cat.name + "*" : cat.name;
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
