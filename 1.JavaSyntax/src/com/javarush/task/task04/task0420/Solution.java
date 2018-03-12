package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int firstValue = Integer.parseInt(reader.readLine());
        int secondValue = Integer.parseInt(reader.readLine());
        int thirdValue = Integer.parseInt(reader.readLine());
        String res = sortNumbers(firstValue,secondValue,thirdValue);
        System.out.println(res);
    }

    public static String sortNumbers(int firstNumber, int secondNumber, int thirdNumber) {
        String result = "";
        int arr[] = {firstNumber,secondNumber,thirdNumber};

        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( arr[j] < arr[j+1] ){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == 0){
                result = String.valueOf(arr[i]) + " ";
            } else if (i == arr.length-1) {
                result = result + String.valueOf(arr[i]);
            } else {
                result = result + String.valueOf(arr[i]) + " ";
            }
        }
        return result;
    }
}
