package com.younho.main;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class CsvExample {
    public static void main(String[] args) throws IOException {
        // Reading a CSV file (Access Values by Column Index)
//        read_csv_1();

        // Reading a CSV file (Access Values by Names assigned to each column)
        read_csv_2();

        // Reading a CSV file with Header Auto-detection (Access Values by Header names)
//        read_csv_3();

        // Generating a CSV file
//        write_csv();
    }

    private static void write_csv() throws IOException {
        CSVFormat csvFormat = CSVFormat.Builder.create()
                .setIgnoreHeaderCase(true)
                .setHeader("ID", "Name", "Designation", "Company")
                .build();
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get("test.csv"));
                CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat);
        ) {

            csvPrinter.printRecord("1", "Sundar Pichai ♥", "CEO", "Google");
            csvPrinter.printRecord("2", "Satya Nadella", "CEO", "Microsoft");
            csvPrinter.printRecord("3", "Tim cook", "CEO", "Apple");

            csvPrinter.printRecord(Arrays.asList("4", "Mark Zuckerberg", "CEO", "Facebook"));

            csvPrinter.flush();
        }
    }

    private static void read_csv_3() throws IOException {
        CSVFormat csvFormat = CSVFormat.Builder.create()
                .setSkipHeaderRecord(true)
                .setIgnoreHeaderCase(true)
                .setTrim(true)
                .build();
        try (
                Reader reader = Files.newBufferedReader(Paths.get("test.csv"));
                CSVParser csvParser = new CSVParser(reader, csvFormat);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by Header names
                String name = csvRecord.get("Name");
                String email = csvRecord.get("Email");
                String phone = csvRecord.get("Phone");
                String country = csvRecord.get("Country");

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Name : " + name);
                System.out.println("Email : " + email);
                System.out.println("Phone : " + phone);
                System.out.println("Country : " + country);
                System.out.println("---------------\n\n");
            }
        }
    }

    private static void read_csv_2() throws IOException {
        CSVFormat csvFormat = CSVFormat.Builder.create()
                .setHeader("Name", "Email", "Phone", "Country")
                .setIgnoreHeaderCase(true)
                .setTrim(true)
                .build();
        try (
                Reader reader = Files.newBufferedReader(Paths.get("test.csv"));
                CSVParser csvParser = new CSVParser(reader, csvFormat);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by the names assigned to each column
                String name = csvRecord.get("Name");
                String email = csvRecord.get("Email");
                String phone = csvRecord.get("Phone");
                String country = csvRecord.get("Country");

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Name : " + name);
                System.out.println("Email : " + email);
                System.out.println("Phone : " + phone);
                System.out.println("Country : " + country);
                System.out.println("---------------\n\n");
            }
        }
    }

    private static void read_csv_1() throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get("test.csv"));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String name = csvRecord.get(0);
                String email = csvRecord.get(1);
                String phone = csvRecord.get(2);
                String country = csvRecord.get(3);

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Name : " + name);
                System.out.println("Email : " + email);
                System.out.println("Phone : " + phone);
                System.out.println("Country : " + country);
                System.out.println("---------------\n\n");
            }
        }
    }
}
