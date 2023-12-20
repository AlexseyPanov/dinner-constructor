package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinner;
    Random random = new Random();

    DinnerConstructor() {
        dinner = new HashMap<>();
    }

    boolean checkType(String type) {
        return dinner.containsKey(type);
    }

    void addDinner(String dishType, String dishName) {
        if (checkType(dishType)) {
            ArrayList<String> dishes = dinner.get(dishType);
            dishes.add(dishName);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dinner.put(dishType, dishes);
        }
    }

    public ArrayList<ArrayList<String>> generateCombos(int comboNumber, ArrayList<String> dishTypes) {
        ArrayList<ArrayList<String>> combos = new ArrayList<>();
        for (int i = 1; i <= comboNumber; i++) {
            ArrayList<String> combo = generateCombo(dishTypes);
            combos.add(combo);
        }
        return combos;
    }

    private ArrayList<String> generateCombo(ArrayList<String> dishTypes) {
        ArrayList<String> selectedDishes = new ArrayList<>();
        for (String dishType : dishTypes) {
            ArrayList<String> availableDishes = dinner.get(dishType);
            int numberOfDishesForType = availableDishes.size();
            int dishIndex = random.nextInt(numberOfDishesForType);
            String selectedDish = availableDishes.get(dishIndex);
            selectedDishes.add(selectedDish);
        }
        return selectedDishes;
    }
}
