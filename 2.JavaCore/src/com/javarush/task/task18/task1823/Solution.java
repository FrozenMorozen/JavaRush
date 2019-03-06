package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        // C:\Users\demorozov\IdeaProjects\test1.txt
        // C:\Users\demorozov\IdeaProjects\test2.txt
        // C:\Users\demorozov\IdeaProjects\test3.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString;

        while (true) {
            inputString = reader.readLine();

            if (inputString.equals("exit")) {
                break;
            }
            new ReadThread(inputString).start();
        }

        /*System.out.println("resultMap:");
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/
    }

    public static class ReadThread extends Thread {
        private volatile String fileName;
        private Map<Integer, Integer> repeatAmount;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream reader = new FileInputStream(this.fileName);

                while (reader.available()>0){
                    addIntoReadList(reader.read());
                }
                reader.close();

                // Определить максимальное среди всех значений для ключей
                int maxValueInMap=(Collections.max(repeatAmount.values()));

                // Поиск записей для найденного максимального значения
                for (Map.Entry<Integer, Integer> entry : repeatAmount.entrySet()) {
                    if (entry.getValue() == maxValueInMap) {
                        resultMap.put(this.fileName, entry.getKey());
                    }
                }



            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public synchronized void addIntoReadList(int rByte){
            if (repeatAmount == null) {
                repeatAmount = new HashMap<>();
            }

            if (!repeatAmount.containsKey(rByte)) {
                repeatAmount.put(rByte, 1);

            } else {
                repeatAmount.put(rByte, repeatAmount.get(rByte)+1);
            }
        }
    }
}
