package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        String temp  = bufferedReader.readLine();
        System.out.println("количество дней в году: " + checkYear(Integer.parseInt(temp)));
    }

    public static int checkYear(int year){
        int result = 365;
            if ( year % 4 == 0 ) {
                result =  366;
                if ((year % 100 == 0) && (year % 400 != 0)) {
                    result =  365;
                }
            }
        return result;
    }
}