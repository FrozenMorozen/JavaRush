package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {

    private String firstField;
    private int secondField;
    private boolean thirdField;

    private Solution (String firstField){}

    Solution (){}

    protected Solution (int secondField){}
    public Solution (boolean thirdField){}

    public static void main(String[] args) {

    }
}

