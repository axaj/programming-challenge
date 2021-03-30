package de.exxcellent.challenge;

import java.util.List;

public class FootballAnalyzer implements Analyzer {
    private IDataSelector dataSelector;
    private Algorithm algorithm;
    private FieldNames fieldNames;

    public FootballAnalyzer(IDataSelector dataSelector) {
        this.dataSelector = dataSelector;
        this.fieldNames = new FieldNames("Team", "Goals","Goals Allowed");
    }

    public FootballAnalyzer(IDataSelector dataSelector, FieldNames fieldNames) {
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
