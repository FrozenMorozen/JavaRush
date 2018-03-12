package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String a = bufferedReader.readLine();
        checkNumber(Integer.parseInt(a));
    }

    public static void checkNumber(int number){
        if (number >= 0) {
            System.out.println(number*2);
        } else {
            System.out.println(number+1);
        }
    }
}