package com.ebay.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JavaUtils {

    public String[] readCSV(String value) throws IOException {

        // if we have multiple CSV files, we can parameterize file path
        BufferedReader br = new BufferedReader(new FileReader("../ebayassignment_raghavendra/src/test/resources/csv/gbLoginTestData.csv"));
        String line = "";
        while ((line = br.readLine()) != null) {

            String[] testData = line.split(",");
            if (testData[0].equalsIgnoreCase(value)) {
                System.out.println("The value expected to be read was found in the CSV file");
                return testData;
            }

        }
        System.out.println("The data to be read : " + value + " was not found in this csv file");
        return null;
    }

}


