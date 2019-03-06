package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        //  C:\Users\demorozov\IdeaProjects\test1.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename;
        while ((filename=reader.readLine())!= null){
            FileInputStream fis = new FileInputStream(filename);
            while (fis.available() > 0) {

                byte[] buffer = new byte[fis.available()];
                int charCount = fis.read(buffer);
                if (charCount < 1000) {
                    fis.close();
                    throw  new DownloadException();
                }

            }
            fis.close();
        }

    }

    public static class DownloadException extends Exception {

    }
}
