package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // args[0] - Имя файла

        HashMap<String, Double> salaryList = new HashMap<>();

            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
                while (fileReader.ready()){

                    String[] readLine = fileReader.readLine().split(" ");

                    // Выделить имя и зарплату сотрудника в отдельные переменые
                    String name = readLine[0];
                    double salary = Double.parseDouble(readLine[1]);

                    if (salaryList.containsKey(name)) {
                        // Увеличить зарплату
                        salaryList.put(name, salaryList.get(name) + salary);
                    } else {
                        // Добавить запись
                        salaryList.put(name, salary);
                    }
                }
            fileReader.close();


        if (salaryList.size() > 1) {    // имеет ли смысл сортировать?
            List<Map.Entry<String, Double>> list = new ArrayList<>(salaryList.entrySet());
            list.sort(Map.Entry.comparingByKey());

            for (Map.Entry<String, Double> entry : list) {
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }
    }
}
