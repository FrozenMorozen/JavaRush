package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        String c = reader.readLine();
        System.out.println(existTriangle(convert(a),convert(b),convert(c)) ?
                "Треугольник существует." : "Треугольник не существует.");
    }

    public static boolean existTriangle(int a, int b, int c){
        if (((a+b)>c) && ((a+c)>b) && ((c+b)>a)) {
            return true;
        } else {
            return false;
        }
    }

    public static int convert(String str){
        try {
            return Integer.parseInt(str);
        } catch (Exception ex) {
            System.out.println("Невозможно конвертировать " + str + " в число: " + ex);
            return 0;
        }
    }
}