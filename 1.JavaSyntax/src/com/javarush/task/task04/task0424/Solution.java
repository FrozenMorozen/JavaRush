package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstNumber = reader.readLine();
        String secondNumber = reader.readLine();
        String thirdNumber = reader.readLine();
        int resultPosition = compareNumber(firstNumber,secondNumber,thirdNumber);
        if (!(resultPosition == -1)) {
            System.out.println(resultPosition);
        }

    }
    public static int compareNumber(String first, String second, String third) {
        String result;
        if ((first.equals(second)) && (second.equals(third))) {
            result = "-1";
        } else if ( !(first.equals(second)) && (second.equals(third))) {
            result = first;
        } else if (!(third.equals(second)) && (first.equals(second))) {
            result = third;
        } else if (!(second.equals(third)) && (third.equals(first))) {
            result = second;
        } else {
            result = "-1";
        }
        String numberArray[] = {first, second, third};
        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i].equals(result)) {
                result = String.valueOf(i + 1);
                break;
            }
        }
        return Integer.parseInt(result);
    }
}
