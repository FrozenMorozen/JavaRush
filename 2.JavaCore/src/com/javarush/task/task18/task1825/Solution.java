package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        /*
            C:\Users\demorozov\IdeaProjects\task1825\eboy.part1
        */

        // Список имён файлов
        List<String> fileNameList = new ArrayList<>();

        // "Целевое" имя
        String targetFile="";

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        // Введённое имя файла
        String inputFileName;

        // Пока не ввели end
        while (!(inputFileName=consoleReader.readLine()).equals("end")) {

            // Проверить соответствует ли файл маске
            if (inputFileName.contains(".part")) {
                fileNameList.add(inputFileName);
            } else throw new Exception("Имя файла не содержит: .part");

            // Сохранить "целевую" часть имени файла
            if (targetFile.equals("")) {
                targetFile = inputFileName.substring(0, inputFileName.length()-6);

            // Если первая часть введённого имени файла не соответствует "целевому" имени
            } else if (!inputFileName.contains(targetFile)) {
                throw new Exception("Введены разные части файлов. Имя файла не содержит: "+ targetFile);
            }
        }
        consoleReader.close();

        // Если список введённых имён файлов не пустой
        if (fileNameList.size() != 0) {

            // Отсортировать список файлов
            Collections.sort(fileNameList);

            FileOutputStream writer = new FileOutputStream(targetFile);

            for (String filename: fileNameList) {

                FileInputStream reader = new FileInputStream(filename);
                while (reader.available()>0){
                    byte[] buffer = new byte[reader.available()];
                    reader.read(buffer);
                    writer.write(buffer);
                }
                reader.close();
            }
            writer.close();
        }
    }
}
