package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        // Английские символы
        // 65-90 верхний регистр
        // 97-122 нижний регистр

         FileInputStream fis = new FileInputStream(args[0]);
        //FileInputStream fis = new FileInputStream("C:\\Users\\demorozov\\IdeaProjects\\test1.txt");

        int englishSymbolCounter = 0;
        while (fis.available()>0){
            int readCharacter = fis.read();
            if (((readCharacter >=65) && (readCharacter<=90))
                    || ((readCharacter >=97) && (readCharacter<=122))) {
                // Увеличить счетчик английских букв в файле
                englishSymbolCounter++;
            }
        }

        System.out.println(englishSymbolCounter);
        fis.close();
    }
}
