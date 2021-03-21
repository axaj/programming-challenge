package de.exxcellent.challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CsvFileReader implements DataInput {
    public List<String[]> readData(String fileName){
        // UGLY, don't know how to correctly access resources with Maven
        File file = new File(System.getProperty("user.dir") + "/target/classes/de/exxcellent/challenge/" + fileName);
        List<String[]> rows = new ArrayList<String[]>();

        try (
            CSVReader reader = new CSVReader(new FileReader(file));
        ) {
            rows = reader.readAll();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException);
            throw new IllegalArgumentException("File not found.");
        } catch (IOException ioException) {
            System.out.println(ioException);
        } catch (CsvException csvException) {
            System.out.println(csvException);
        }
        return rows;
    }
}
