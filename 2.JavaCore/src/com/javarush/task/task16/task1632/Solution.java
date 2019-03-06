package com.javarush.task.task16.task1632;

import com.javarush.task.task16.task1632.threads.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        FirstThread firstThread = new FirstThread();
        threads.add(firstThread);

        SecondThread secondThread = new SecondThread();
        threads.add(secondThread);

        ThirdThread thirdThread = new ThirdThread();
        threads.add(thirdThread);

        FourthThread fourthThread= new FourthThread();
        threads.add(fourthThread);

        FifthThread fifthThread= new FifthThread();
        threads.add(fifthThread);
    }

    public static void main(String[] args) {
    }
}