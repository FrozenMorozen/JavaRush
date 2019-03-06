package com.javarush.task.task18.task1802;


import java.io.BufferedReader;
import java.io.FileInputStream;
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

        Integer minByte= null;
        while (fis.available()>0){
            int rByte = fis.read();
            if ((minByte==null) || (rByte < minByte)) {
                minByte =  rByte;
            }
        }

        System.out.println(minByte);
        fis.close();
    }
}
