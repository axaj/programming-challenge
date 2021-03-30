package de.exxcellent.challenge;

import java.io.File;
import java.util.List;

import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.Spec;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
@Command(name = "csvanalyzer", version = "0.1", description = "")
public final class App implements Runnable {
    @Spec CommandSpec spec;

    @ArgGroup(exclusive = false, multiplicity = "1")
    OptionGroup group = new App.OptionGroup();

    static class OptionGroup {
        @Option(names = "--weather", description = "Find the day with the smallest temperature difference (absolute)")
        String weatherFile;
        @Option(names = "--football", description = "Find the name of the team with the smallest goal difference (absolute)")
        String footballFile;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args); 
        System.exit(exitCode); 
    }

    @Override
    public void run() {
        if (group.weatherFile != null && group.weatherFile.length() > 0) {
            if (checkIfFileExists(group.weatherFile)) {
                String dayWithSmallestTempSpread = analyzeWeather(group.weatherFile);
                spec.commandLine().getOut().print(dayWithSmallestTempSpread);
                System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
            } else {
                System.out.printf("File " + group.weatherFile + " not found.");
            }
        }
        if (group.footballFile != null && group.footballFile.length() > 0) {
            if (checkIfFileExists(group.footballFile)) {
                String teamWithSmallestGoalSpread = analyzeFootball(group.footballFile);
                spec.commandLine().getOut().print(teamWithSmallestGoalSpread);
                System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
            } else {
                System.out.printf("File " + group.footballFile + " not found.");
            }
        }

    }

    static String analyzeWeather(String fileName) {
        DataImport csv = new CsvImporter();
        List<String[]> data = csv.readData(fileName);
        IDataSelector dataSelector = new DataSelector(data);
        Analyzer analyzer = new WeatherAnalyzer(dataSelector);

        return analyzer.run();
    }

    static String analyzeFootball(String fileName) {
        DataImport csv = new CsvImporter();
        List<String[]> data = csv.readData(fileName);
        IDataSelector dataSelector = new DataSelector(data);
        Analyzer analyzer = new FootballAnalyzer(dataSelector);

        return analyzer.run();
    }

    private static boolean checkIfFileExists(String fileName) {
        File file = new File("target/classes/de/exxcellent/challenge/" + fileName);
        return file.isFile();
    }
}

class FieldNames {
    public String category;
    public String columnA;
    public String columnB; 

    FieldNames(String categoryName, String a, String b) {
        this.category = categoryName;
        this.columnA = a;
        this.columnB = b;
    }
}