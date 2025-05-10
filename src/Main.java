package src;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<Cat> cats = new ArrayList<>();

        System.out.print("Введите количество кошек: ");
        int numberOfCats = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfCats; i++) {
            System.out.printf("Введите имя кошки %d: ", i + 1);
            String name = scanner.nextLine();

            System.out.printf("Введите возраст кошки %d: ", i + 1);
            double age = scanner.nextDouble();
            scanner.nextLine();

            double health = 20 + random.nextInt(61);
            double mood = 20 + random.nextInt(61);
            double satiety = 20 + random.nextInt(61);

            cats.add(new Cat(name, age, health, mood, satiety));
        }

        while (true) {
            cats.sort(Comparator.comparingDouble(Cat::getAverage).reversed());
            FormatTable.printTable(cats);

            System.out.println("Выберите кошку по номеру или имени (или введите 'nextday' или 'exit'):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) break;

            if (input.equalsIgnoreCase("nextday")) {
                for (Cat cat : cats) {
                    cat.nextDay(random);
                }
                System.out.println("Прошел один день...");
                continue;
            }

            Cat selectedCat = null;

            try {
                int index = Integer.parseInt(input);
                if (index >= 1 && index <= cats.size()) {
                    selectedCat = cats.get(index - 1);
                }
            } catch (NumberFormatException e) {
                for (Cat cat : cats) {
                    if (cat.name.equalsIgnoreCase(input.replace("*", ""))) {
                        selectedCat = cat;
                        break;
                    }
                }
            }

            if (selectedCat == null) {
                System.out.println("Кошка не найдена. Попробуйте снова.");
                continue;
            }

            if (selectedCat.actedToday) {
                System.out.println("Вы уже взаимодействовали с этой кошкой сегодня.");
                continue;
            }

            System.out.println("Выберите действие: feed | play | heal");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "feed":
                    selectedCat.feed();
                    break;
                case "play":
                    selectedCat.play();
                    break;
                case "heal":
                    selectedCat.heal();
                    break;
                default:
                    System.out.println("Неизвестное действие.");
            }
        }

        System.out.println("Программа завершена.");
    }
}