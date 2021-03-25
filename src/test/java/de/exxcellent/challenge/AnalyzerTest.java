package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



class AnalyzerTest {
    private Analyzer minSpread;

    @BeforeEach
    void setUp() {
        minSpread = new Analyzer();
    }

    @Test
    void findMinSpreadTest() {
        List<String> testTargets = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> testMax = new ArrayList<String>(Arrays.asList("10","20","15","30","34"));
        List<String> testMin = new ArrayList<String>(Arrays.asList("5","10","13","29","24"));
        assertEquals("4", minSpread.findMinSpread(testTargets, testMax, testMin));
    }

    @Test
    // what if Lists have different length?
    void differentListLengthsTest() {
        List<String> testTargets = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6")); // 6 elements
        List<String> testMax = new ArrayList<String>(Arrays.asList("15","21","24","27","25")); // only 5 elements!
        List<String> testMin = new ArrayList<String>(Arrays.asList("10","14","22","13","24","20")); // 6 elements

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> { 
            minSpread.findMinSpread(testTargets, testMax, testMin);
        });
    }

    @Test
    void nullTest() {
        List<String> testTargets = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> testMax = new ArrayList<String>(Arrays.asList("10","20","15","30","34"));
        List<String> testMin = new ArrayList<String>(Arrays.asList("5","10","13","29","24"));
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

    // what if test columns are not numbers?
    @Test
    void findMinSpreadOfNonNumericValues() {
        List<String> testTargets = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> testColumn1 = new ArrayList<String>(Arrays.asList("abc","def","ghi","jkl","mno"));
        List<String> testColumn2 = new ArrayList<String>(Arrays.asList("pqr","stu","vwx","yza","bcd"));

        Assertions.assertThrows(NumberFormatException.class, () -> { 
            minSpread.findMinSpread(testTargets, testColumn1, testColumn2);
        });
        
    }

    @Test
    void isNumberTest() {
        assertTrue(Analyzer.isNumber("1"));
        assertTrue(Analyzer.isNumber("1.5"));
        assertTrue(Analyzer.isNumber("-1"));
        assertTrue(Analyzer.isNumber("-1.7"));
        assertFalse(Analyzer.isNumber("abc"));
        assertFalse(Analyzer.isNumber("1d.5abc"));
        assertFalse(Analyzer.isNumber("abc-1"));
        assertFalse(Analyzer.isNumber("-1.7abc"));
    }

    @Test
    void isIntegerTest() {
        assertTrue(Analyzer.isInteger("1"));
        assertFalse(Analyzer.isInteger("1.5"));
        assertTrue(Analyzer.isInteger("-1"));
        assertFalse(Analyzer.isInteger("-1.7"));
        assertFalse(Analyzer.isInteger("abc"));
        assertFalse(Analyzer.isInteger("1d.5abc"));
        assertFalse(Analyzer.isInteger("abc-1"));
        assertFalse(Analyzer.isInteger("-1.7abc"));
    }

    @Test
    void isDoubleTest() {
        assertTrue(Analyzer.isDouble("1"));
        assertTrue(Analyzer.isDouble("1.5"));
        assertTrue(Analyzer.isDouble("-1"));
        assertTrue(Analyzer.isDouble("-1.7"));
        assertFalse(Analyzer.isDouble("abc"));
        assertFalse(Analyzer.isDouble("1d.5abc"));
        assertFalse(Analyzer.isDouble("abc-1"));
        assertFalse(Analyzer.isDouble("-1.7abc"));
    }

}
