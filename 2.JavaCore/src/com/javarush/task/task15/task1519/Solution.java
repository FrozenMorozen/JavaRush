package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = reader.readLine();
            if (s.equals("exit")) break;

            try {
                int res = Integer.parseInt(s);
                if (res <= 0 || res >= 128) {
                    print(res);
                } else if (res > 0 && res < 128) {
                    print(Short.parseShort(s));
                }
            } catch (NumberFormatException ee) {
                try {
                    if (s.contains(".")) {
                        double l = Double.parseDouble(s);
                        print(l);
                    } else print(s);

                } catch (NumberFormatException e) {
                    print(s);

                }
            }

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }

}
