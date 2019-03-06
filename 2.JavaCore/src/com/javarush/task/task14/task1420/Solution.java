package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int fistNumber = 0;
        int secondNumber =0;
        try {
            fistNumber = Integer.parseInt(reader.readLine());
            secondNumber = Integer.parseInt(reader.readLine());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if ((fistNumber <= 0) || (secondNumber <= 0)) {
            //System.out.println("Ошибка! Одно из введённых чисел <= 0");
            //return;
            throw new NumberFormatException();
        }

        // Наибольший общий делитель
        int nod = 1;

        // Максимальное из введенных чисел
        int maxNumber = Math.max(fistNumber, secondNumber);

        for (int i = maxNumber; i >0 ; i--) {
            if (fistNumber % i == 0) {
                if (secondNumber % i == 0) {
                    nod = i;
                    break;
                }
            }
        }

        System.out.println(nod);

    }
}
