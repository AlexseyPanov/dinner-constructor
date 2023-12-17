package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
                case "4":
                    printAllDishesByType();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
        System.out.println("4 - Показать блюда по типам");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        // добавьте новое блюдо
        dc.addDinner(dishType, dishName);
    }

    private static void printAllDishesByType() {
        for (String type : dc.dinner.keySet()) {
            System.out.println(type);

            ArrayList<String> dishes = dc.dinner.get(type);
            for (String dish : dishes) {
                System.out.println("    " + dish);
            }
        }
    }

    private static void generateDishCombo() {
        ArrayList<String> typesOfDishes = new ArrayList<>();
        Random random = new Random();
        int indexRandomDines = 0;
        String combo;

        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        while (true) {
            System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
            String nextItem = scanner.nextLine();

            if (!nextItem.isEmpty()) {
                if (dc.checkType(nextItem)) {
                    System.out.println("Такой тип есть! Добавим тип " + nextItem);
                    typesOfDishes.add(nextItem);
                } else {
                    System.out.println("Такого типа нет! Попробуйте еще раз.");
                }
            } else {
                break;
            }
        }
        // сгенерируйте комбинации блюд и выведите на экран
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.print("Комбинация блюд " + (i + 1));
            combo = "";
            for (int j = 0; j < typesOfDishes.size(); j++) {
                indexRandomDines = random.nextInt(dc.dinner.get(typesOfDishes.get(j)).size());
                combo = combo + " " + dc.dinner.get(typesOfDishes.get(j)).get(indexRandomDines);
            }
            System.out.println(": " + combo);
        }
        System.out.println("--------------------------------");
    }
}