package de.exxcellent.challenge;

import java.util.List;
/**
 * TODO: Make this more easily extendable/reusable
 */
public class MinSpread {
    public String findMinSpread(List<String> searchTarget, List<String> maxValues, List<String> minValues) {
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

    private int calculateSpread(String maxValue, String minValue) {
        return Math.abs(Integer.parseInt(maxValue) - Integer.parseInt(minValue));
    }
}
