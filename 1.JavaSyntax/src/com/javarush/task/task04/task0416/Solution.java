package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double inputNumber = Double.valueOf(reader.readLine());
        System.out.println(trafficLightsColor(inputNumber));
    }

    public static String trafficLightsColor(double t){
        double time = 0;
        if ( (t>=0) && (t<60) ) {
            for (int i = 0; i < 60; i = i+5) {
                if (  (t>= 0 + i) && (t < 3+i) ) {
                    return "зелёный";
                } else if ((t>=3+i) && (t<4+i)) {
                    return "жёлтый";
                } else if ((t>=4+i) && (t<5+i)) {
                    return "красный";
                }
            }
        }
        return "Введённое число не принадлежит минутам в часе";
    }
}