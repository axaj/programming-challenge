package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FootballAnalyzerTest {
    private Analyzer analyzer;
    private List<String[]> data = new ArrayList<String[]>();

    void setUpWorkingDataSet() {
        String[] dataHeader = new String[]{"Team", "B", "Goals", "Goals Allowed", "E"};
        String[] dataRow1 = new String[]{"Liverpool", "10", "40", "15", "25"};
        String[] dataRow2 = new String[]{"Manchester United", "15", "35", "25", "30"};
        String[] dataRow3 = new String[]{"Leicester", "14", "25", "30", "15"};
        data.add(dataHeader);
        data.add(dataRow1);
        data.add(dataRow2);
        data.add(dataRow3);
    }

    @Test
    void analyzeFootballTest(){
        setUpWorkingDataSet();
        IDataSelector dataSelector = new DataSelector(data);
        analyzer = new FootballAnalyzer(dataSelector);
        assertEquals("Leicester", analyzer.run());
    }
}
