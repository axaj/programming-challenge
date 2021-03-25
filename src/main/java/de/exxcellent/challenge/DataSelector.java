package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Utility class to help select columns out of a list of rows
 */
class DataSelector {
    private List<String[]> data;
    private String[] headers;
    /**
     * @param inputData first item in List is expected to contain header fields as Array of Strings
     */
    DataSelector(List<String[]> inputData) {
        this.data = inputData;
        this.headers = data.get(0);
    }
    /**
     * Selects a certain subset of the data, according to a given String.
     * @param targetField name of the targeted field
     * @return 
     */
    public List<String> getValuesByFieldName(String targetField) {
        int column = getTargetField(targetField); // TODO: what if column == -1 aka field not found
        ArrayList<String> values = new ArrayList<String>();

        for(int i = 1; i < this.data.size(); i++) {
            values.add(this.data.get(i)[column]);
        }
        return values;
    }

    int getTargetField(String targetField) {
        return Arrays.asList(headers).indexOf(targetField);
    }
}
