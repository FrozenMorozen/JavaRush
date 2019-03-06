package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

            while (fileReader.ready()){
                String[] lineElements = fileReader.readLine().split("\\s");
                for (String element: lineElements) {
                    if (element.matches(".*\\d+.*")) {
                        fileWriter.write(element+" ");
                    }
                }
            }
            fileReader.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
