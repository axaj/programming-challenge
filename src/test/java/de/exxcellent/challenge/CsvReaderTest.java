package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CsvReaderTest {
    // Test basic functionality with working filename
    @Test
    void readWeatherCsvDataTest() {
        CsvReader csvFileReader = new CsvReader();
        assertEquals(31, csvFileReader.readData("weather.csv").size());
    }
    
    @Test
    void fileNotFoundExceptionTest() {
        CsvReader csvFileReader = new CsvReader();
        Assertions.assertThrows(IllegalArgumentException.class, () -> { 
            csvFileReader.readData("wwweather.csv");
        });
    }
}
