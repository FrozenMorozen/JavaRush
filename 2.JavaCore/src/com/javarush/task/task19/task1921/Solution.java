package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {

        try(BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {

            while (fileReader.ready()){
                String[] readLine = fileReader.readLine().split(" ");

                // Получить имя пользователя
                String name = null;
                for (int i = 0 ; i < readLine.length-3 ; i++) { // Гарантированно последние 3 элемента строки: [день] - int, [месяц] - int, [год] - int
                    if (i == 0) {                               // Поэтому всё остальное это имя
                        name = readLine[i]+" ";
                    } else {
                        name = name + readLine[i]+" ";
                    }

                }
                name = name.substring(0,name.length()-1);       //  Обрезать последний пробел

                String day = readLine[readLine.length-3].length() < 2   ? ("0"+readLine[readLine.length-3]) : readLine[readLine.length-3];
                String month = readLine[readLine.length-2].length() < 2 ? ("0"+readLine[readLine.length-2]) : readLine[readLine.length-2];
                Date birthDate = null;
                try {
                    SimpleDateFormat sdf= new SimpleDateFormat("ddMMyyyy", Locale.ENGLISH);
                    birthDate = sdf.parse(day + month + readLine[readLine.length-1]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                PEOPLE.add(new Person(name, birthDate));
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
