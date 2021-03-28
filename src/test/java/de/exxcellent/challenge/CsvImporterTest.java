package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CsvImporterTest {
    // Test basic functionality with working filename
    private DataImport csv;

    @BeforeEach
    void setup() {
        csv = new CsvImporter();
    }

    @Test
    void readWeatherCsvData() {
        final int EXPECTED_NUMBER_OF_LINES = 31;
        assertEquals(EXPECTED_NUMBER_OF_LINES, csv.readData("weather.csv").size());
    }
    
    @Test
    void readFootballCsvData() {
        final int EXPECTED_NUMBER_OF_LINES = 21;
        assertEquals(EXPECTED_NUMBER_OF_LINES, csv.readData("football.csv").size());
    }

    @Test
    void wrongFilenNameTest() {
        assertEquals(0, csv.readData("wwweather.csv").size());
    }
}
