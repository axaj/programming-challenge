package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WeatherAnalyzerTest {
    private Analyzer analyzer;
    private List<String[]> data = new ArrayList<String[]>();

    void setUpWorkingDataSet() {
        String[] dataHeader = new String[]{"Day", "MnT", "MxT", "D", "E"};
        String[] dataRow1 = new String[]{"1", "10", "20", "15", "25"};
        String[] dataRow2 = new String[]{"2", "15", "30", "25", "30"};
        String[] dataRow3 = new String[]{"3", "14", "16", "25", "15"};
        data.add(dataHeader);
        data.add(dataRow1);
        data.add(dataRow2);
        data.add(dataRow3);
    }

    @Test
    void analyzeWeatherTest(){
        setUpWorkingDataSet();
        IDataSelector dataSelector = new DataSelector(data);
        analyzer = new WeatherAnalyzer(dataSelector);
        assertEquals("3", analyzer.run());
    }
}
