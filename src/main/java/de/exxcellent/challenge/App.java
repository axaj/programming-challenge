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

        // TODO: Clean up code -> create methods for repeated function calls

        // Your preparation code …

        // Read data from file
        DataInput csvReader = new CsvReader();
        List<String[]> weatherData = csvReader.readData("weather.csv");

        // Select data needed for analysis
        DataSelector weatherDataSelector = new DataSelector(weatherData);
        List<String> days = weatherDataSelector.getTargetValues("Day");
        List<String> maxTemps = weatherDataSelector.getTargetValues("MxT");
        List<String> minTemps = weatherDataSelector.getTargetValues("MnT");

        // Analysis function call
        MinSpread weatherMinSpread = new MinSpread();
        String dayWithSmallestTempSpread = weatherMinSpread.findMinSpread(days, maxTemps, minTemps);
        
        // Output Temperature
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        // Read data from file
        List<String[]> footballData = csvReader.readData("football.csv");

        // Select data needed for analysis
        DataSelector footballDataSelector = new DataSelector(footballData);
        List<String> teamNames = footballDataSelector.getTargetValues("Team");
        List<String> goalsScored = footballDataSelector.getTargetValues("Goals");
        List<String> goalsAllowed = footballDataSelector.getTargetValues("Goals Allowed");

        // Analysis function call
        MinSpread footballMinSpread = new MinSpread();
        String teamWithSmallestGoalSpread = footballMinSpread.findMinSpread(teamNames, goalsScored, goalsAllowed);
        
        // Output Football
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

        // String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        // System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        // String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        // System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
