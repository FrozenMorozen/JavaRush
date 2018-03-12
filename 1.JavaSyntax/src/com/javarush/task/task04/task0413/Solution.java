package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String day = reader.readLine();
        System.out.println(checkDayOfTheWeek(Integer.parseInt(day)));
    }

    public static String checkDayOfTheWeek(int dayNumber){
        String result;
        switch (dayNumber){
            case 1:
                result =  "понедельник";
                break;
            case 2:
                result =  "вторник";
                break;
            case 3:
                result =  "среда";
                break;
            case 4:
                result =  "четверг";
                break;
            case 5:
                result =  "пятница";
                break;
            case 6:
                result =  "суббота";
                break;
            case 7:
                result =  "воскресенье";
                break;
            default:
                result =  "такого дня недели не существует";
                break;
        }
        return result;
    }
}