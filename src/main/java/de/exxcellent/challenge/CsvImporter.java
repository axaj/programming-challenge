package de.exxcellent.challenge;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CsvImporter implements DataImport {
    public List<String[]> readData(String fileName){
        List<String[]> rows = new ArrayList<String[]>();

        try (
            InputStream input = getClass().getResourceAsStream(fileName);
            InputStreamReader inputReader = new InputStreamReader(input, StandardCharsets.UTF_8);
            CSVReader reader = new CSVReader(inputReader);
        ) {
            rows = reader.readAll();
        } catch (NullPointerException nullPointerException) {
            // log error message
            System.out.println(nullPointerException);
        } catch (IOException ioException) {
            // log error message
            // System.out.println(ioException);
        } catch (CsvException csvException) {
            // log error message
            // System.out.println(csvException);
        } 
        
        return rows;
    }
}
