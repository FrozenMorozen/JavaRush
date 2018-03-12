package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOne = reader.readLine();
        String nameTwo = reader.readLine();
        if (!(compareNames(nameOne,nameTwo).isEmpty())) {
            System.out.println(compareNames(nameOne,nameTwo));
        }
    }

    public static String compareNames(String name1,String name2){
        if (name1.compareTo(name2) == 0) {
            return "Имена идентичны";
        } else if (name1.length() == name2.length()) {
            return "Длины имен равны";
        } else return "";
    }
}
