package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
        public static void main(String[] args) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int firstNumber = Integer.parseInt(reader.readLine());
            int secondNumber = Integer.parseInt(reader.readLine());
            int thirdNumber = Integer.parseInt(reader.readLine());
            String resultPosition = compareNumber(firstNumber,secondNumber,thirdNumber);
            if (!(resultPosition.isEmpty())) {
                System.out.println(resultPosition);
            }
        }
        public static String compareNumber(int first, int second, int third) {
            String result;
            if ((first == second) && (second == third)) {
                result = String.valueOf(first + " " + second + " " + third);
            } else if (first == second) {
                result = String.valueOf(first + " " + second);
            } else if (second == third) {
                result = String.valueOf(second + " " + third);
            } else if (first == third) {
                result = String.valueOf(first + " " + third);
            } else {
                result = "";
            }

            return result;
        }
    }