import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                saveSteps(scanner, stepTracker);
            } else if (command == 2) {
                showStats(scanner, stepTracker);
            } else if (command == 3) {
                changeGoal(scanner, stepTracker);
            } else if (command == 0) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }

    public static void saveSteps(Scanner scanner, StepTracker stepTracker) {
        System.out.println("Введите месяц");
        String month = scanner.next();
        Months result = Months.fromString(month.trim());
        if (result == null) {
            System.out.println("Такого месяца нет");
            return;
        }

        System.out.println("Введите день");
        int day = scanner.nextInt();
        if (day <= 0 || day > 30) {
            System.out.println("Введите число от 1 до 30");
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Число шагов не может быть отрицательным");
            return;
        }
        stepTracker.saveSteps(result, day, steps);
        System.out.println("Данные сохранены");
    }

    public static void showStats(Scanner scanner, StepTracker stepTracker) {
        System.out.println("Введите месяц");
        String month = scanner.next();
        Months result = Months.fromString(month.trim());
        Stats stats = stepTracker.getStats(result);
        System.out.println("Количество пройденных шагов по дням:");

        for (int i = 0; i < stats.getDays().length; i++) {
            System.out.print((i + 1) + " день: " + stats.getDays()[i]);
            if (i < stats.getDays().length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("\nОбщее количество шагов: " + stats.findTotal());
        System.out.println("Максимальное пройденное количество шагов: " + stats.findMax());
        System.out.println("Среднее количество шагов: " + stats.findAverage());
        System.out.println("Пройденная дистанция: " + stats.findDistance() + " км");
        System.out.println("Количество сожжённых килокалорий: " + stats.findKcal());
        System.out.println("Лучшая серия: " + stats.findBestStreak());
    }

    public static void changeGoal(Scanner scanner, StepTracker stepTracker) {
        System.out.println("Введите новое колличество шагов");
        int goal = scanner.nextInt();
        if (goal > 0) {
            stepTracker.setGoal(goal);
            System.out.println("Цель сохранена");
        } else {
            System.out.println("Число шагов не может быть отрицательным");
        }
    }
}
