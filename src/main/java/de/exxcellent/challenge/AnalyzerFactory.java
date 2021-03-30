package de.exxcellent.challenge;

import java.util.List;

public class AnalyzerFactory {
    public Analyzer createAnalyzer(String fileName, ContentType type) {
        DataImportFactory dataImporterFactory = new DataImportFactory();
        DataImport csv = dataImporterFactory.createDataImport("csv");
        List<String[]> data = csv.readData(fileName);
        IDataSelector dataSelector = new DataSelector(data);
        Analyzer analyzer = null;

        if(type == ContentType.WEATHER) {
            analyzer = new WeatherAnalyzer(dataSelector);
        } else if (type == ContentType.FOOTBALL) {
            analyzer = new FootballAnalyzer(dataSelector);
        }

        return analyzer;
    }
}
