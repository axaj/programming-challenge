package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.List;
/**
 * Utility class to help select columns out of a list of rows
 */
class DataSelector {
    private List<String[]> data;
    /**
     * 
     * @param inputData first item in List is expected to contain header fields as Array of Strings
     */
    DataSelector(List<String[]> inputData) {
        this.data = inputData;
    }
    /**
     * Selects a certain subset of the data, according to a given target .
     * @param targetField name of the targeted field
     * @return 
     */
    public List<String> getTargetValues(String targetField) {
        int column = getTargetField(targetField); // TODO: what if column -1
        ArrayList<String> values = new ArrayList<String>();

        for(int i = 1; i < this.data.size(); i++) {
            values.add(this.data.get(i)[column]);
        }

        return values;
    }

    int getTargetField(String targetField) {
        String[] headers = data.get(0);
        int column = -1;

        for(int i = 0; i < headers.length; i++) {
            if (targetField.equals(headers[i])) {
                column = i;
                break;
            }
        }
        return column;
    }
}
