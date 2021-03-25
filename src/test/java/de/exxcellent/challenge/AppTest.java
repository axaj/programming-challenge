package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    // TODO: make this test actually useful -> implement CLI
    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }

    @Test
    void analyzeWeatherTest() {
        assertEquals("14", App.findDayWithSmallestTempSpread());
    }

    @Test
    void analyzeFootballTest() {
        assertEquals("Aston_Villa", App.findTeamWithSmallestGoalSpread());
    }

}