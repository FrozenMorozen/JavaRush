package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount=-1;

    public static void main(String[] args) {
       new GenerateThread();
    }

    public static class GenerateThread extends Thread {

        @Override
        public String toString() {
            //return this.getName() + " № " + createdThreadCount + " created";
            return  this.getName() + " created";
        }

        @Override
        public void run() {

            if (createdThreadCount < Solution.count) {
                System.out.println(new GenerateThread());
            } else {
                return;
            }

        }

        public GenerateThread(){
            super(String.valueOf(++createdThreadCount));
            start();
        }
    }
}
