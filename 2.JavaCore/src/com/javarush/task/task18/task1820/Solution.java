package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        // C:\\Users\\demorozov\\IdeaProjects\\test1.txt

        String filename1;
        String filename2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        filename1 = reader.readLine();
        filename2 = reader.readLine();

        // TEST
        /*filename1 = "C:\\Users\\demorozov\\IdeaProjects\\test1.txt";
        filename2 = "C:\\Users\\demorozov\\IdeaProjects\\test2.txt";*/

        String buffer = "";
        FileInputStream fis = new FileInputStream(filename1);
        FileOutputStream fos = new FileOutputStream(filename2);

        while (fis.available()>0){

            // Считать сразу раскодированный символ
            char b = (char) fis.read();

            // Если символ не пробел
            if (b != 32) {
                buffer = buffer + b;
            } else {
                String tr = String.valueOf((int) Math.round(Double.parseDouble(buffer)));

                int numberLength = 0;
                while (numberLength < tr.length()){
                    fos.write(tr.codePointAt(numberLength));
                    numberLength++;
                }
                // Поставить пробел
                fos.write(32);

                // Очистить число
                buffer = "";
            }
        }
        fis.close();

        if (!buffer.equals("")) {

            String tr = String.valueOf((int) Math.round(Double.parseDouble(buffer)));

            int numberLength = 0;
            while (numberLength < tr.length()){
                fos.write(tr.codePointAt(numberLength));
                numberLength++;
            }
        }

        // Закрыть поток записи
        fos.close();
    }
}
