package com.javarush.task.task03.task0325;

import java.io.*;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int salary=Integer.parseInt(bufferedReader.readLine());
        System.out.println("Я буду зарабатывать $" + salary + " в час");
    }
}
