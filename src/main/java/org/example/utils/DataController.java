package org.example.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataController {
    Integer columnNum;

    public DataController() {

    }

    public void printByColumnAndLine(String line) {
        long parseTime = System.currentTimeMillis();

        Map<String, List<String>> results = new TreeMap<>();
        long rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("airports.csv"))) {
            String row;
            while ((row = br.readLine()) != null) {
                String[] values = row.split(",");
                if (values[columnNum].toLowerCase().replace("\"", "").startsWith(line)) {
                    results.put(values[columnNum], Arrays.asList(values));
                    rowCount++;
                }

            }

        } catch (IOException e) {
            throw new RuntimeException("Файл airports.csv отсутствует в папке");
        }

        results.forEach((a, b) -> System.out.println(a + b));
        long millis = (System.currentTimeMillis() - parseTime);
        System.out.println("Количество найденных записей: " + rowCount + ", Время затраченное на поиск: " + millis + " мс");
    }

    public Integer getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(Integer columnNum) {
        this.columnNum = columnNum;
    }
}
