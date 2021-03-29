package de.exxcellent.challenge;

import java.util.List;

public class Analyzer {
    public String findMinSpread(List<String> searchTarget, List<Integer> maxValues, List<Integer> minValues) {
        if ((searchTarget == null) || (maxValues == null) || (minValues == null)) {
            throw new IllegalArgumentException("null parameters not allowed.");
        }
        if ((searchTarget.size() != maxValues.size()) || (searchTarget.size() != minValues.size())) {
            throw new IllegalArgumentException("arguments have to have same size!");
        }

        int minSpread = calculateSpread(maxValues.get(0), minValues.get(0));
        int rowNumber = 0;

        for(int i = 1; i < searchTarget.size(); i++) {
            if (minSpread > calculateSpread(maxValues.get(i), minValues.get(i))) {
                minSpread = calculateSpread(maxValues.get(i), minValues.get(i));
                rowNumber = i;
            }
        }
        return searchTarget.get(rowNumber);
    }

    int calculateSpread(int maxValue, int minValue) {
        return Math.abs(maxValue - minValue);
    }
}
