package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {

        // Тестовый файл
        // C:\Users\demorozov\IdeaProjects\test1.txt

        // Определить имя файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        BufferedReader buff = new BufferedReader(new FileReader(fileName));

        while (buff.ready()) {
            String s = buff.readLine();

            if (s.startsWith(args[0] + " ")) {
                System.out.println(s);
            }
        }

        reader.close();
        buff.close();
    }
}
