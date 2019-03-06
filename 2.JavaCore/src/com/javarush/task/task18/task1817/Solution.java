package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(args[0]);
        // FileInputStream fis = new FileInputStream("C:\\Users\\demorozov\\IdeaProjects\\test1.txt");

        int spaceSymbolCounter = 0;     // Счетчик пробелов
        int otherSymbolCounter = 0;     // Счетчик прочих символов

        while (fis.available()>0) {
            int readCharacter = fis.read();
            otherSymbolCounter++;
            // Если считанный символ - пробел
            if (readCharacter == 32) {
                // Увеличить счетчик пробело в файле
                spaceSymbolCounter++;
            }
        }
        double result = spaceSymbolCounter;
        result = result/otherSymbolCounter*100;
        String formattedDouble = String.format("%.2f", result);

        System.out.println(formattedDouble);

        fis.close();
    }
}
