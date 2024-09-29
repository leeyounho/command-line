package com.younho.main;

import com.jakewharton.fliptables.FlipTable;

public class TablePrintExample {
    public static void main(String[] args) {
        String[] headers = { "Test", "Header" };
        String[][] data = {
                { "Foo", "Bar" },
                { "Kit", "Kat" },
        };
        System.out.println(FlipTable.of(headers, data));
    }
}
