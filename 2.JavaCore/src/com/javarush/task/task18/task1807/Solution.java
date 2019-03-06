package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        //  C:\Users\demorozov\IdeaProjects\test.txt

        // Считать имя файла с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        // Прочитать содержимое файла
        FileInputStream fis = new FileInputStream(filename);
        int commaCounter = 0;
        while (fis.available() > 0){
            int ch = fis.read();
            if (ch == 44) {
                commaCounter++;
            }
        }
        fis.close();
        System.out.println(commaCounter);
    }
}
