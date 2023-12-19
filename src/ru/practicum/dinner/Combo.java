package ru.practicum.dinner;

import java.util.HashMap;

public class Combo {
    HashMap<Integer, String> resultCombos;

    Combo() {
        resultCombos = new HashMap<>();
    }

    boolean checkCombo(Integer numberOfCombos) {
        return resultCombos.containsKey(numberOfCombos);
    }

    boolean checkComboHash(Integer numberOfCombos, String combo) {
        for (String comb : resultCombos.values()) {
            if (comb.hashCode() == combo.hashCode()) {
                return true;
            }
        }
        return false;
    }

    void addCombo(Integer numberOfCombos, String combo) {
        if (checkCombo(numberOfCombos)) {
            System.out.println("Уже есть комбинация " + numberOfCombos);
        } else {
            resultCombos.put(numberOfCombos, combo);
        }
    }

    void printAllDishesByType() {
        for (Integer numberOfCombos : resultCombos.keySet()) {
            System.out.println("Комбинация " + numberOfCombos + ": " + resultCombos.get(numberOfCombos));
        }
        System.out.println("Всего комбинаций :" + resultCombos.size());
        System.out.println("------------------------------------------");
    }

    void clear(){
        resultCombos.clear();
    }
}
