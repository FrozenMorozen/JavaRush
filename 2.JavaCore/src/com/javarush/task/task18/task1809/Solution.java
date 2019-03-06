package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        //  C:\Users\demorozov\IdeaProjects\test1.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = reader.readLine();   // Файл для чтения
        String filename2 = reader.readLine();   // Файл для чтения


        FileInputStream fis = new FileInputStream(filename1);
        FileOutputStream fos = new FileOutputStream(filename2);

        while (fis.available() > 0){
            // Считать весь файл целиком в буффер
            byte[] buff = new byte[fis.available()];
            int byteCount = fis.read(buff);

            for (int i = byteCount-1; i >= 0; i--) {
                fos.write(buff[i]);
            }
        }
        fis.close();
        fos.close();
    }
}
