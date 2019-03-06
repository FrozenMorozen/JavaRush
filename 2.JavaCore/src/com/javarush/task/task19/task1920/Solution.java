package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import sun.awt.SunHints;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // args[0] - Имя файла

        HashMap<String, Double> salaryList = new HashMap<>();

        try(BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {

            while (fileReader.ready()){
                String[] readLine = fileReader.readLine().split(" ");

                // Выделить имя и зарплату сотрудника в отдельные переменые
                String name = readLine[0];
                double salary = Double.parseDouble(readLine[1]);

                if (salaryList.containsKey(name)) {
                    salaryList.put(name, salaryList.get(name) + salary);    // Увеличить значение зарплаты
                } else {
                    salaryList.put(name, salary);                           // Добавить запись
                }
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (salaryList.size() > 1) {    // имеет ли смысл сортировать?

            double maxSalary = Collections.max(salaryList.values());

            for (Map.Entry<String, Double> entry : salaryList.entrySet()) {
                if (entry.getValue() == maxSalary) {
                    System.out.println(entry.getKey());
                }
            }

        }
    }
}
