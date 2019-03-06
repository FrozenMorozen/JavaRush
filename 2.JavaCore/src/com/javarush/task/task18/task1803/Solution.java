package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //  C:\Users\demorozov\IdeaProjects\test.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fis1 = new FileInputStream(fileName);



        Map<Integer, Integer> map = new HashMap<>();

        while (fis1.available()>0){
            int rByte = fis1.read();

            // Если такого значения ещё нет, то добавить
            if (map.get(rByte)==null) {
                map.put(rByte, 1);
            } else {
                // Заменить старое значение на новое
                map.replace(rByte, map.get(rByte), map.get(rByte)+1);
            }
            
        }

        fis1.close();

        int max = Collections.max(map.values());

        for (Map.Entry<Integer, Integer> pair: map.entrySet()){
            if (pair.getValue().equals(max)){
                byte b = (byte) pair.getKey().intValue();
                System.out.printf(b + " ");
            }
        }
    }
}
