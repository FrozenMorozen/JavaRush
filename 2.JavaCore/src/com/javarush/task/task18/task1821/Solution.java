package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    // Справочник, чтобы складывтаь кол-во повторяемых значений
    private static Map<Integer, Integer> catalog = new HashMap<Integer , Integer>();

    // Справчник ASCII
    private static Map<Integer, Character> ASCII = new HashMap<Integer, Character>();

   /* public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(args[0]);

        // TEST
         //FileInputStream fis = new FileInputStream("C:\\Users\\demorozov\\IdeaProjects\\test1.txt");

         // Считать все данные в справочник
        while (fis.available() > 0) {
            char symbol =(char) fis.read();
            addValueInCatalog(symbol);
        }
        fis.close();

        Map<Integer, Integer> treeMap = new TreeMap<>(catalog);


        treeMap.forEach((key, value) -> {
            System.out.println(ASCII.get(key)+ " " + value);
            //System.out.println(key + " " + value);
        });
    }*/


    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);

        ArrayList<Character> arr = new ArrayList<>();

        while(reader.ready()){
            arr.add((char)reader.read());
        }
        reader.close();

        TreeMap<Character,Integer> map = new TreeMap<>();

        for (char ar : arr) {
            if (map.containsKey(ar)) {
                map.put(ar,map.get(ar) + 1);
            }
            else{
                map.put(ar, 1);
            }
        }
        for (Map.Entry<Character,Integer>pair : map.entrySet() ) {
            System.out.println(pair.getKey() + " "+ pair.getValue());
        }

    }

    public static void addValueInCatalog(char key) {

        // Если такого значения ещё нет в справочнике
        if (!catalog.containsKey((int)key)) {
            // то создать
            catalog.put((int)key, 1);

            // добавить значение для символа в ascii
            ASCII.put((int) key, key);

        // Иначе увеличить счетчик для знаечния
        } else {
            catalog.put((int)key, catalog.get((int)key)+1);
        }

    }
}
