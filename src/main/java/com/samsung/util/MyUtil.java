package com.samsung.util;

import com.google.common.collect.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class MyUtil {
    private static final Logger LOGGER = LogManager.getLogger(MyUtil.class);

    @Inject
    public MyUtil() {
        LOGGER.debug("Initializing MyUtil");
    }

    public void guavaTableToCSV(Table<String, String, String> table, String fileName) throws IOException {
        FileWriter csvWriter = new FileWriter(fileName);

        // Write header (column keys)
        csvWriter.append(" ");
        for (String columnKey : table.columnKeySet()) {
            csvWriter.append(",").append(columnKey);
        }
        csvWriter.append("\n");

        // Write data rows
        for (String rowKey : table.rowKeySet()) {
            csvWriter.append(rowKey);  // Row key
            Map<String, String> row = table.row(rowKey);
            for (String columnKey : table.columnKeySet()) {
                csvWriter.append(",").append(row.getOrDefault(columnKey, ""));  // Row values
            }
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }

    // TODO Guava Table pretty print
//    https://github.com/JakeWharton/flip-tables 괜찮은 듯?

}
