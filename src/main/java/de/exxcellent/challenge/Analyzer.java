package de.exxcellent.challenge;

import java.util.List;
/**
 * TODO: Make this more easily extendable/reusable
 */
public class Analyzer {
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


    int calculateSpread(String maxValue, String minValue) {
        return Math.abs(Integer.parseInt(maxValue) - Integer.parseInt(minValue));
    }

    static boolean isNumber(String str) {
        return isInteger(str) || isDouble(str);
    }

    static boolean isInteger(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    static boolean isDouble(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
}
