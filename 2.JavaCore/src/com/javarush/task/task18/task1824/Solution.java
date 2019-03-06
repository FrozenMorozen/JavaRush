package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String inputFileName="";

        while (true){

            try {
                inputFileName = bReader.readLine();
                FileInputStream reader = new FileInputStream(inputFileName);
                reader.close();

            } catch (FileNotFoundException e) {
                System.out.println(inputFileName);
                break;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
