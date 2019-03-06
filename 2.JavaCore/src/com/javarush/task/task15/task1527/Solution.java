package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputURL = reader.readLine();

            // Предположим, что в строке может быть максимум только один символ "?"
            // поэтому проверим присутсвует ли он в строке
            if (inputURL.lastIndexOf("?") != -1) {

                // Обрезать строку начиная с символа "?"
                char inputURLarr[] = inputURL.substring(inputURL.lastIndexOf("?")+1).toCharArray();
                String parametr= "";
                ArrayList<String> paramsList = new ArrayList<>();
                String paramObjValue = "";

                for (int i=0; i<inputURLarr.length; i++) {

                    //  javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

                    if (inputURLarr[i] == '=') {
                        paramsList.add(parametr);   // добавить в список параметров

                        // Если имя параметра obj, то запомнить его значение
                        if (parametr.equals("obj")){
                            i++;    // начать со следущего после "=" символа
                            // пока не найден символ "&" и не достигнута максимальная длина
                            while ((inputURLarr[i] != '&') && (i < inputURLarr.length-1)){
                                paramObjValue = paramObjValue + inputURLarr[i];
                                i++;
                            }
                        } else {
                            // пока не найден символ "&" и не достигнута максимальная длина
                            while ((inputURLarr[i] != '&') && (i < inputURLarr.length-1)){
                                i++;
                            }
                        }
                        parametr = "";              // обнулить параметр
                        continue;                   // перейти к след символу

                    } else if (inputURLarr[i] == '&'){
                        paramsList.add(parametr);   // добавить в список параметров
                        parametr = "";              // обнулить параметр
                        continue;                   // перейти к след символу
                    }
                    parametr = parametr + inputURLarr[i];
                }

                for (String element : paramsList) {
                    System.out.print(element+" ");
                }
                System.out.println();

                if (!paramObjValue.equals("")){
                    try {
                        alert(Double.valueOf(paramObjValue));
                    } catch (Exception ex) {
                        alert(paramObjValue);
                    }
                }
                /*for (String element : paramsList) {
                    if (element.equals("obj")) {
                        if (element.contains(".")) {
                            alert(Double.parseDouble(element));
                        } else {
                            alert(element);
                        }
                    }
                }*/

            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
