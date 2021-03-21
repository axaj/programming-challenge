package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CsvFileReaderTest {
    // Test basic functionality with working filename
    @Test
    void readWeatherCsvDataTest() {
        CsvFileReader csvFileReader = new CsvFileReader();
        assertEquals(31, csvFileReader.readData("weather.csv").size());
    }

    @Test
    void fileNotFoundExceptionTest() {
        CsvFileReader csvFileReader = new CsvFileReader();
        Assertions.assertThrows(IllegalArgumentException.class, () -> { 
            csvFileReader.readData("wwweather.csv");
        });
    }
}
