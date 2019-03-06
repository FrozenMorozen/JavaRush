package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

/*
    Я ЗАТУПИЛ И СДЕЛАЛ ПЕРВЫМ ЗАДАНИЕМ ПРАЙСЫ 2, А ТОЛЬКО ПОСЛЕ ПРИСТУПИЛ К ЭТОМУ:((
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args.length != 0 && "-c".equals(args[0])) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            ArrayList<String> list = new ArrayList<>();

            BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
            int maxID = 0;
            while (readerFile.ready()){
                String line = readerFile.readLine();
                list.add(line);

                // Определить id максимального элемента в файле, для генерации нового id
                int id = Integer.parseInt(line.substring(0, 8).trim());
                if (maxID == 0) {
                    maxID = id;
                } else if (id>maxID){
                    maxID = id;
                }
            }
            readerFile.close();

            // Добавить новую строку в массив для записи
            list.add(String.format("%-8d%-30s%-8s%-4s", maxID+1, args[1], args[2], args[3]));

            BufferedWriter writerFile = new BufferedWriter(new FileWriter(fileName));
            for (String str: list){
                writerFile.write(str);
                writerFile.newLine();
            }
            writerFile.close();
        }

    }
}