package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinner;

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

}
