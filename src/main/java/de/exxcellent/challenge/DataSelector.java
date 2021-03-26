package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Utility class to help select columns out of a list of rows
 */
class DataSelector {
    private List<String[]> data;
    private List<String> headers;
    /**
     * @param inputData first item in List is expected to contain header fields as Array of Strings
     */
    DataSelector(List<String[]> inputData) {
        this.data = inputData;
        this.headers = Arrays.asList(data.get(0));
    }
    /**
     * Selects a certain subset of the data, according to a given String.
     * @param targetField name of the targeted field
     * @return List of String data
     */
    public List<String> getStringValuesByFieldName(String targetField) {
        int column = getTargetField(targetField); // TODO: what if column == -1 aka field not found
        ArrayList<String> values = new ArrayList<String>();

        for(int i = 1; i < this.data.size(); i++) {
            values.add(this.data.get(i)[column]);
        }
        return values;
    }
    /**
     * Selects a certain subset of the data, according to a given String.
     * @param targetField String name of the targeted field
     * @return List of Integer data
     */
    public List<Integer> getIntegerValuesByFieldName(String targetField) {
        int column = getTargetField(targetField); // TODO: what if column == -1 aka field not found
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 1; i < this.data.size(); i++) {
            if (isInteger(this.data.get(i)[column])) {
                result.add(Integer.parseInt(this.data.get(i)[column]));
            } else {
                throw new IllegalArgumentException("Argument invalid: " + this.data.get(i)[column] + " is not an Integer.");
            }
        }
        return result;
    }

    int getTargetField(String targetField) {
        return headers.indexOf(targetField);
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
