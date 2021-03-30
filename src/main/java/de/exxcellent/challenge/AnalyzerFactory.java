package de.exxcellent.challenge;

public class AnalyzerFactory {
    public Analyzer createAnalyzer(IDataSelector dataSelector, String type) {
        Analyzer analyzer = null;

        if(type.equals("weather")) {
            analyzer = new WeatherAnalyzer(dataSelector);
        } else if (type.equals("football")) {
            analyzer = new FootballAnalyzer(dataSelector);
        }

        return analyzer;
    }
}
