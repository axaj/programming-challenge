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
        if (inputData == null) {
            throw new IllegalArgumentException("There is no data.");
        }
        this.data = inputData;
        if (this.data.size() > 0) {
            this.headers = Arrays.asList(data.get(0));
        }
    }
    /**
     * Selects a certain subset of the data, according to a given String.
     * @param targetField name of the targeted field
     * @return List of String data
     */
    public List<String> getStringValuesByFieldName(String targetField) {
        int column = getTargetField(targetField);
        if (column == -1) {
            throw new IllegalArgumentException("Field (" + targetField + ") not in headers.");
        }
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
        List<String> numbers = getStringValuesByFieldName(targetField);
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(String number : numbers) {
            if (isInteger(number)) {
                result.add(Integer.parseInt(number));
            } else {
                throw new IllegalArgumentException("Argument invalid: " + number + " is not an Integer.");
            }
         }
        return result;
    }

    int getTargetField(String targetField) {
        return headers.indexOf(targetField);
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
}
