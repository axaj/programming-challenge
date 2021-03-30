package de.exxcellent.challenge;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CsvImport implements DataImport {
    public List<String[]> readData(String fileName){
        List<String[]> rows = new ArrayList<String[]>();

        try (
            InputStreamReader fileReader = new FileReader(fileName);
            CSVReader reader = new CSVReader(fileReader);
        ) {
            rows = reader.readAll();
        } catch (NullPointerException nullPointerException) {
            // log error message
            System.out.println(nullPointerException);
        } catch (IOException ioException) {
            // log error message
            System.out.println(ioException);
        } catch (CsvException csvException) {
            // log error message
            System.out.println(csvException);
        } 
        
        return rows;
    }
}
