package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        FileReader reader = new FileReader(consoleReader.readLine());
        FileWriter writer = new FileWriter(consoleReader.readLine());
        consoleReader.close();

        int i = 1;
        while (reader.ready()){
            int data = reader.read();
            if (i % 2 == 0) {
                writer.write(data);
            }
            i++;
        }
        reader.close();
        writer.close();
    }
}
