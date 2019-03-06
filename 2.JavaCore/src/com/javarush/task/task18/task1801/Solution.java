package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //  C:\Users\demorozov\IdeaProjects\test.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fis = new FileInputStream(fileName);

        int maxByte = 0;
        while (fis.available()>0){
            int rByte = fis.read();
            if (rByte > maxByte) {
                maxByte =  rByte;
            }
        }

        System.out.println(maxByte);
        fis.close();
    }
}
