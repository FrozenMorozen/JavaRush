package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //  C:\Users\demorozov\IdeaProjects\test.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fis1 = new FileInputStream(fileName);



        Map<Integer, Integer> map = new HashMap<>();

        TreeSet<Integer> bytesList = new TreeSet<>();

        while (fis1.available()>0){
            int rByte = fis1.read();

            bytesList.add(rByte);
        }
        fis1.close();

        for (Integer element: bytesList) {
            System.out.print(element+" ");
        }
    }
}
