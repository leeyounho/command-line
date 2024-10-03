package com.younho.main;

import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

import java.util.Arrays;
import java.util.List;

public class TablesawExample {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30, "New York"),
                new Person("Bob", 25, "Los Angeles"),
                new Person("Charlie", 35, "Chicago")
        );

        Table personTable = convertToTable(people);
        System.out.println(personTable);
    }

    public static Table convertToTable(List<Person> personList) {
        // 컬럼 생성
        StringColumn nameColumn = StringColumn.create("Name");
        IntColumn ageColumn = IntColumn.create("Age");
        StringColumn cityColumn = StringColumn.create("City");

        // List의 데이터를 각 컬럼에 추가
        for (Person person : personList) {
            nameColumn.append(person.getName());
            ageColumn.append(person.getAge());
            cityColumn.append(person.getCity());
        }

        // 테이블 생성 및 컬럼 추가
        Table table = Table.create("Person Table");
        table.addColumns(nameColumn, ageColumn, cityColumn);

        return table;
    }

    public static class Person {
        private String name;
        private int age;
        private String city;

        // Constructor
        public Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }

        // Getters
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getCity() {
            return city;
        }
    }
}
