package de.exxcellent.challenge;

import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        
        String dayWithSmallestTempSpread = findDayWithSmallestTempSpread();
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = findTeamWithSmallestGoalSpread();
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

    }

    public static String findDayWithSmallestTempSpread() {
        String fileName = "weather.csv";
        FieldNames fieldNames = new FieldNames("Day", "MxT", "MnT");

        return analyze(fileName, fieldNames);
    }

    public static String findTeamWithSmallestGoalSpread() {
        String fileName = "football.csv";
        FieldNames fieldNames = new FieldNames("Team", "Goals", "Goals Allowed");

        return analyze(fileName, fieldNames);
    }

    private static String analyze(String fileName, FieldNames fieldNames) {
        DataImport csv = new CsvImporter();
        List<String[]> data = csv.readData(fileName);

        DataSelector dataSelector = new DataSelector(data);
        List<String> categories = dataSelector.getValuesByFieldName(fieldNames.category);
        List<String> dataPointsA = dataSelector.getValuesByFieldName(fieldNames.a);
        List<String> dataPointsB = dataSelector.getValuesByFieldName(fieldNames.b);

        MinSpread minSpread = new MinSpread();
        return minSpread.findMinSpread(categories, dataPointsA, dataPointsB);
    }
}

class FieldNames {
    public String category;
    public String a;
    public String b; 

    FieldNames(String categoryName, String aName, String bName) {
        this.category = categoryName;
        this.a = aName;
        this.b = bName;
    }
}