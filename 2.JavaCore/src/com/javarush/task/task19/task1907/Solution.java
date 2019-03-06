package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        // C:\Users\demorozov\IdeaProjects\test1.txt
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));


        FileReader reader = new FileReader(consoleReader.readLine());
        consoleReader.close();

        String word="";
        int count = 0;
        while (reader.ready()){
            char data = (char) reader.read();
            if (String.valueOf(data).matches("[^\\w]")) {

                if (word.equals("world")) {
                    count++;
                }
                word="";
            } else {
                word = word + data;
            }

        }
        reader.close();
        System.out.println(count);
    }
}
