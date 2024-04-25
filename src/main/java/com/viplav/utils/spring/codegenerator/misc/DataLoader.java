package com.viplav.utils.spring.codegenerator.misc;
/*package com.viplav.utils.spring.codegenerator.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class DataLoader {

    public void loadCSV(String filePath) {
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(csvSplitBy);

                System.out.println("Data [column-1= " + data[0] + " , column-2=" + data[1] + "]");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JsonNode convert(String csvFilePath) throws IOException {
        File csvFile = new File(csvFilePath);
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();

        MappingIterator<JsonNode> mappingIterator = csvMapper.readerFor(JsonNode.class)
                .with(csvSchema)
                .readValues(csvFile);

        return csvMapper.valueToTree(mappingIterator.readAll());
    }

}
*/