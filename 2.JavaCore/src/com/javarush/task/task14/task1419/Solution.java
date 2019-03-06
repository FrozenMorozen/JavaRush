package com.javarush.task.task14.task1419;

import javax.management.RuntimeOperationsException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();
    public static int iterator =0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            initExceptions();
        }

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        iterator++;

        if (iterator == 1) {
            try {
                float i = 1 / 0;
            } catch (Exception e) {
                exceptions.add(e);
            }

        } else  if (iterator == 2) {

            Exception e = new RuntimeOperationsException(null);
            exceptions.add(e);

        } else if (iterator == 3) {
            try(FileReader reader = new FileReader("notes3.txt"))
            {
                int c;
                while((c=reader.read())!=-1){
                    System.out.print((char)c);
                }
            }
            catch(IOException e){
                exceptions.add(e);
            }

        } else if (iterator == 4) {

            Exception e = new RuntimeException();
            exceptions.add(e);

        } else if (iterator == 5) {

            Exception e = new ArrayIndexOutOfBoundsException();
            exceptions.add(e);

        } else if (iterator == 6) {

            Exception e = new ClassNotFoundException();
            exceptions.add(e);

        } else if (iterator == 7) {

            Exception e = new CloneNotSupportedException();
            exceptions.add(e);

        } else if (iterator == 8) {

            Exception e = new IllegalAccessException();
            exceptions.add(e);

        } else if (iterator == 9) {

            Exception e = new ArrayStoreException();
            exceptions.add(e);

        } else if (iterator == 10) {

            Exception e = new SecurityException();
            exceptions.add(e);
        }


        //напишите тут ваш код

    }
}
