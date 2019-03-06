package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        // C:\Users\demorozov\IdeaProjects\test1.txt
        // C:\Users\demorozov\IdeaProjects\test2.txt

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));
        BufferedWriter fileWriter= new BufferedWriter(new FileWriter(consoleReader.readLine()));
        consoleReader.close();

        /*String numberDataBuffer="";

        while (fileReader.ready()){
            char data = (char) fileReader.read();

            if (String.valueOf(data).matches("[^\\d]")) {

                if (!numberDataBuffer.equals("")) {
                    fileWriter.write(numberDataBuffer+" ");
                    numberDataBuffer="";
                }
            } else {
                numberDataBuffer = numberDataBuffer + data;
            }
        }*/

        while (fileReader.ready()) {
            String[] content = fileReader.readLine().split("\\s");
            for (String str : content) {
                if (str.matches("\\d+")) {
                    fileWriter.write(str + " ");
                }
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
