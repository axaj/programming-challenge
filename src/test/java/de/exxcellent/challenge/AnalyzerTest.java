package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnalyzerTest {
    private Analyzer minSpread;

    @BeforeEach
    void setUp() {
        minSpread = new Analyzer();
    }

    @Test
    void findMinSpreadTest() {
        List<String> testTargets = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
        List<Integer> testMax = new ArrayList<Integer>(Arrays.asList(10,20,15,30,34));
        List<Integer> testMin = new ArrayList<Integer>(Arrays.asList(5,10,13,29,24));
        assertEquals("4", minSpread.findMinSpread(testTargets, testMax, testMin));
    }

    @Test
    // what if Lists have different length?
    void differentListLengthsTest() {
        List<String> testTargets = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6")); // 6 elements
        List<Integer> testMax = new ArrayList<Integer>(Arrays.asList(15, 21, 24, 27, 25)); // only 5 elements!
        List<Integer> testMin = new ArrayList<Integer>(Arrays.asList(10, 14, 22, 13, 24, 20)); // 6 elements
        
        assertEquals("Error: data set is incomplete there are missing values!", minSpread.findMinSpread(testTargets, testMax, testMin));
    }

    @Test
    void nullTest() {
        List<String> testTargets = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
        List<Integer> testMax = new ArrayList<Integer>(Arrays.asList(10, 20, 15, 30, 34));
        List<Integer> testMin = new ArrayList<Integer>(Arrays.asList(5, 10, 13, 29, 24));
        Assertions.assertThrows(NullPointerException.class, () -> { 
            minSpread.findMinSpread(null,null,null);
        });
        Assertions.assertThrows(NullPointerException.class, () -> { 
            minSpread.findMinSpread(null, testMax, testMin);
        });
        Assertions.assertThrows(NullPointerException.class, () -> { 
            minSpread.findMinSpread(testTargets, null, testMin);
        });
        Assertions.assertThrows(NullPointerException.class, () -> { 
            minSpread.findMinSpread(testTargets, testMax, null);
        });
    }
}
