package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        // C:\\Users\\demorozov\\IdeaProjects\\test1.txt

        String filename1;
        String filename2;
        String filename3;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        filename1 = reader.readLine();
        filename2 = reader.readLine();
        filename3 = reader.readLine();

        // TEST
        /*filename1 = "C:\\Users\\demorozov\\IdeaProjects\\test1.txt";
        filename2 = "C:\\Users\\demorozov\\IdeaProjects\\test2.txt";
        filename3 = "C:\\Users\\demorozov\\IdeaProjects\\test3.txt";*/

        // В первый файл записать содержимое
        FileOutputStream fos = new FileOutputStream(filename1);
        FileInputStream fis1 = new FileInputStream(filename2);
        FileInputStream fis2 = new FileInputStream(filename3);

        while (fis1.available()>0){
            // Считать данные в буфер
            byte[] r = new byte[fis1.available()];
            fis1.read(r);
            fos.write(r);
        }
        fis1.close();

        while (fis2.available()>0){
            // Считать данные в буфер
            byte[] r = new byte[fis2.available()];
            fis2.read(r);
            fos.write(r);
        }
        fis2.close();
        fos.close();


    }
}
