package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("А");
        words.add("Б");
        words.add("В");
    }

    public static void main(String[] args) {
        // C:\Users\demorozov\IdeaProjects\test3.txt

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        try(BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()))) {
            consoleReader.close();


            while (fileReader.ready()){
                String readingLine = fileReader.readLine();
                String[] wordsFromFile = readingLine.split("\\s");
                HashMap<String, Integer> useCounter = new HashMap<>();
                int targetWordCount = 0;

                for (int i = 0; i < wordsFromFile.length; i++) {

                    // Если слово есть в списке words
                    if (words.contains(wordsFromFile[i])) {

                        targetWordCount = targetWordCount + 1;
                    }

                }

                if (targetWordCount == 2) {
                    System.out.println(readingLine);
                }

            }
            fileReader.close();




            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
