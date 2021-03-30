package de.exxcellent.challenge;

public class DataImportFactory {
    public DataImport createDataImport(String type) {
        DataImport dataImport = null;

        if(type.equals("csv")) {
            dataImport = new CsvImport();
        }

        return dataImport;
    }
}
