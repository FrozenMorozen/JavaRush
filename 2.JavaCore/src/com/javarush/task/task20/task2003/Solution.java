package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        try (InputStream inputStream = new FileInputStream(consoleReader.readLine())) {
            consoleReader.close();

            load(inputStream);
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (reader.ready()){
            String readingLine  = reader.readLine();

            // Если строка пустая(состоит из пробелов), то перейти к следующей
            /*if (readingLine.matches("[/s]")) {
                continue;
            }*/
            String[] propertiesArray = readingLine.split(":");
            if (propertiesArray.length == 2) {
                properties
            }
        }
        reader.close();
    }

    public static void main(String[] args) {

    }
}
