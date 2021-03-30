package de.exxcellent.challenge;

import java.util.List;

public class MinSpreadAlgorithm implements Algorithm {
    private List<String> searchTarget;
    private List<Integer> maxValues;
    private List<Integer> minValues;

    public MinSpreadAlgorithm(List<String> searchTarget, List<Integer> maxValues, List<Integer> minValues) {
        this.searchTarget = searchTarget;
        this.maxValues = maxValues;
        this.minValues = minValues;
        if ((searchTarget == null) || (maxValues == null) || (minValues == null)) {
            throw new IllegalArgumentException("null parameters not allowed.");
        }
        if ((searchTarget.size() != maxValues.size()) || (searchTarget.size() != minValues.size())) {
            throw new IllegalArgumentException("arguments have to have same size!");
        }
    }

    public String run() {

        int minSpread = calculateSpread(this.maxValues.get(0), this.minValues.get(0));
        int rowNumber = 0;

        for(int i = 1; i < this.searchTarget.size(); i++) {
            if (minSpread > calculateSpread(this.maxValues.get(i), this.minValues.get(i))) {
                minSpread = calculateSpread(this.maxValues.get(i), this.minValues.get(i));
                rowNumber = i;
            }
        }
        return this.searchTarget.get(rowNumber);
    }

    int calculateSpread(int maxValue, int minValue) {
        return Math.abs(maxValue - minValue);
    }
}
