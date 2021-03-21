package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



class MinSpreadTest {
    @Test
    void findMinSpreadTest() {
        MinSpread minSpread = new MinSpread();
        List<String> testTargets = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> testMax = new ArrayList<String>(Arrays.asList("10","20","15","30","34"));
        List<String> testMin = new ArrayList<String>(Arrays.asList("5","10","13","29","24"));
        assertEquals("4", minSpread.findMinSpread(testTargets, testMax, testMin));
    }
}
