package com.javarush.task.task16.task1632.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FifthThread extends Thread {

    @Override
    public void run() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputNumber;
        int sumInputNumbers = 0;

        try {
            while (true){
                inputNumber = reader.readLine();
                if (inputNumber.equals("N")) {
                    System.out.println(sumInputNumbers);
                    break;
                }
                sumInputNumbers = sumInputNumbers + Integer.parseInt(inputNumber);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
