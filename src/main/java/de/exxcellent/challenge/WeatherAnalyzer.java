package de.exxcellent.challenge;

import java.util.List;

public class WeatherAnalyzer implements Analyzer {
    private IDataSelector dataSelector;
    private Algorithm algorithm;
    private FieldNames fieldNames;

    public WeatherAnalyzer(IDataSelector dataSelector) {
        this.dataSelector = dataSelector;
        this.fieldNames = new FieldNames("Day", "MxT","MnT");
    }

    public WeatherAnalyzer(IDataSelector dataSelector, FieldNames fieldNames) {
        this.dataSelector = dataSelector;
        this.fieldNames = fieldNames;
    }

    public String run() {
        algorithm = new MinSpreadAlgorithm(getCategory(), getColumn(fieldNames.columnA), getColumn(fieldNames.columnB));
        return algorithm.run();
    }

    private List<String> getCategory() {
        return dataSelector.selectStringsByFieldName(fieldNames.category);
    }

    private List<Integer> getColumn(String fieldName) {
        return dataSelector.selectIntegersByFieldName(fieldName);
    }
}
