package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinSpreadAlgorithmTest {
    private Algorithm algorithm;
    private List<String> testTargets;
    private List<Integer> testMax;
    private List<Integer> testMin;

    void setUpWorkingDataSet() {
        testTargets = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
        testMax = new ArrayList<Integer>(Arrays.asList(10, 20, 15, 30, 34));
        testMin = new ArrayList<Integer>(Arrays.asList(5, 10, 13, 29, 24));
        
    }

    void setUpFaultyDataSet() {
        testTargets = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6")); // 6 elements
        testMax = new ArrayList<Integer>(Arrays.asList(15, 21, 24, 27, 25)); // only 5 elements!
        testMin = new ArrayList<Integer>(Arrays.asList(10, 14, 22, 13, 24, 20)); // 6 elements
    }

    @Test
    void findMinSpreadTest() {
        setUpWorkingDataSet();
        algorithm = new MinSpreadAlgorithm(testTargets, testMax, testMin);
        assertEquals("4", algorithm.run());
    }

    @Test
    // what if Lists have different length?
    void differentListLengthsTest() {
        setUpFaultyDataSet();
        Assertions.assertThrows(IllegalArgumentException.class, () -> { 
            algorithm = new MinSpreadAlgorithm(testTargets, testMax, testMin);
        });
    }

    @Test
    void nullTest() {
        setUpWorkingDataSet();
        Assertions.assertThrows(IllegalArgumentException.class, () -> { 
            algorithm = new MinSpreadAlgorithm(null, null, null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> { 
            algorithm = new MinSpreadAlgorithm(null, testMax, testMin);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> { 
            algorithm = new MinSpreadAlgorithm(testTargets, null, testMin);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> { 
            algorithm = new MinSpreadAlgorithm(testTargets, testMax, null);
        });
    }
}
