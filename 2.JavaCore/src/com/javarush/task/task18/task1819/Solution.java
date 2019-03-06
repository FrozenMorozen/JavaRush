package com.javarush.task.task18.task1819;

/* 
Объединение файлов
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

        FileInputStream fis1 = new FileInputStream(filename1);
        FileInputStream fis2 = new FileInputStream(filename2);

        List<byte[]> reading = new ArrayList<>();

        while (fis1.available()>0){
            // Считать данные в буфер
            byte[] r1 = new byte[fis1.available()];
            fis1.read(r1);
            reading.add(r1);
        }
        fis1.close();

        FileOutputStream fos = new FileOutputStream(filename1);
        while (fis2.available()>0){
            // Считать данные в буфер
            byte[] r1 = new byte[fis2.available()];
            fis2.read(r1);
            fos.write(r1);
        }
        fis2.close();


        for (byte[] elements: reading) {
            fos.write(elements);
        }
        fos.close();

    }
}
