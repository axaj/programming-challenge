package de.exxcellent.challenge;

import java.io.File;
import java.util.List;

import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Spec;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
@Command(name = "csvanalyzer", mixinStandardHelpOptions = true, version = "0.1", description = "")
public final class App implements Runnable {
    @Spec CommandSpec spec;

    @ArgGroup(exclusive = true, multiplicity = "1")
    private OptionGroup group = new App.OptionGroup();

    static class OptionGroup {
        @Option(names = "--weather", description = "Find the day with the smallest temperature difference (absolute)")
        boolean weather;
        @Option(names = "--football", description = "Find the name of the team with the smallest goal difference (absolute)")
        boolean football;
    }

    @Parameters(paramLabel = "FILE", arity = "1..*", description = "CSV files whose contents to analyze")
    private List<File> files;

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args); 
        System.exit(exitCode); 
    }

    @Override
    public void run() {
        if (group.weather) {
            for(File f : files) {
                if (f.isFile()) {
                    String dayWithSmallestTempSpread = analyze(f, "weather");
                    spec.commandLine().getOut().print(dayWithSmallestTempSpread);
                    System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
                } else {
                    System.out.printf("File " + f.toString() + " not found.");
                    // throw new IllegalArgumentException("File " + f.toString() + " doesn't exist.");
                }
            }
        } else if (group.football) {
            for(File f : files) {
                if (f.isFile()) {
                    String teamWithSmallestGoalSpread = analyze(f, "football");
                    spec.commandLine().getOut().print(teamWithSmallestGoalSpread);
                    System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
                } else {
                    System.out.printf("File " + f.toString() + " not found.");
                    // throw new IllegalArgumentException("File " + f.toString() + " doesn't exist.");
                }
            }
        }
    }

    static String analyze(File file, String dataType) {
        DataImportFactory dataImporterFactory = new DataImportFactory();
        DataImport csv = dataImporterFactory.createDataImport("csv");
        List<String[]> data = csv.readData(file.getAbsolutePath());
        IDataSelector dataSelector = new DataSelector(data);

        AnalyzerFactory analyzerFactory = new AnalyzerFactory();
        Analyzer analyzer = analyzerFactory.createAnalyzer(dataSelector, dataType);

        return analyzer.run();
    }
}