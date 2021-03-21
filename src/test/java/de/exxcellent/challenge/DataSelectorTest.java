package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataSelectorTest {
        List<String[]> data = new ArrayList<String[]>();
    @BeforeEach
    void setUp() {
        String[] dataHeader = new String[]{"A", "B", "C", "D", "E"}; // B is in field 1
        String[] dataRow1 = new String[]{"10", "40", "50", "15", "25"};
        String[] dataRow2 = new String[]{"20", "30", "60", "25", "30"};
        String[] dataRow3 = new String[]{"30", "20", "10", "25", "15"};
        data.add(dataHeader);
        data.add(dataRow1);
        data.add(dataRow2);
        data.add(dataRow3);
    }

    @Test
    void getTargetFieldTest() {
        String targetField = "B";
        DataSelector dataSelector = new DataSelector(data);
        assertEquals(1, dataSelector.getTargetField(targetField), "Wrong Column!"); // Test if field is in 1
    }
    @Test
    void getTargetValuesTest() {
        String targetField = "A";
        DataSelector dataSelector = new DataSelector(data);
        List<String> expectedList = new ArrayList<String>(Arrays.asList("10", "20", "30"));
        assertEquals(expectedList, dataSelector.getTargetValues(targetField), "Wrong Column!"); // {"10", "20", "30"}
    }
}