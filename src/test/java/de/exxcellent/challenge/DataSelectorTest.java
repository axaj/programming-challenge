package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataSelectorTest {
        List<String[]> data = new ArrayList<String[]>();
    @BeforeEach
    void setUp() {
        String[] dataHeader = new String[]{"A", "B", "C", "D", "E"};
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
        assertEquals(1, dataSelector.getTargetField(targetField)); // Test if field is in column 1
    }
    @Test
    void getTargetIntegerValuesTest() {
        String targetField = "A";
        DataSelector dataSelector = new DataSelector(data);
        List<Integer> expectedList = new ArrayList<Integer>(Arrays.asList(10, 20, 30));
        assertEquals(expectedList, dataSelector.getIntegerValuesByFieldName(targetField));
    }

    @Test
    void getTargetStringValuesTest() {
        String targetField = "D";
        DataSelector dataSelector = new DataSelector(data);
        List<String> expectedList = new ArrayList<String>(Arrays.asList("15", "25", "25"));
        assertEquals(expectedList, dataSelector.getStringValuesByFieldName(targetField));
    }

    @Test
    void isIntegerTest() {
        assertTrue(DataSelector.isInteger("1"));
        assertFalse(DataSelector.isInteger("1.5"));
        assertTrue(DataSelector.isInteger("-1"));
        assertFalse(DataSelector.isInteger("-1.7"));
        assertFalse(DataSelector.isInteger("abc"));
        assertFalse(DataSelector.isInteger("1d.5abc"));
        assertFalse(DataSelector.isInteger("abc-1"));
        assertFalse(DataSelector.isInteger("-1.7abc"));
    }
}
