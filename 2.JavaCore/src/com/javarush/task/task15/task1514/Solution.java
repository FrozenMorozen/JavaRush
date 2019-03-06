package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static{
        labels.put(15.0,"Value-4");
        labels.put(16.0,"Value-1");
        labels.put(17.0,"Value-2");
        labels.put(18.0,"Value-3");
        labels.put(19.0,"Value-3");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
