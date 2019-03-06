package com.javarush.task.task15.task1521;

public class Tree {
    public static int globalNumber;
    public int number;

    public Tree() {
        this.number = ++globalNumber;
    }

    public void info(Object s) {
        System.out.println(String.format("Дерево № %d , метод Object, параметр %s", number, s.getClass().getSimpleName()));
    }

    public void info(Number s) {
        System.out.println(String.format("Дерево № "+ number +" , метод Number, параметр " + s.getClass().getSimpleName()));
    }

    public void info(String s) {
        System.out.println(String.format("Дерево № "+ number +" , метод String, параметр " + s.getClass().getSimpleName()));
    }
}
