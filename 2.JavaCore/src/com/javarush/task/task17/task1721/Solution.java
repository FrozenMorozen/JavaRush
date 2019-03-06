package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution /*extends Thread*/ {

    /*
    *   C:\Users\demorozov\IdeaProjects\test.txt
    * */

    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputString = null;
        try {
            int i = 0;

            while (i<2){
                i++;

                inputString = reader.readLine();

                // Тест, потом удалить
                /*switch (i){
                    case 1:
                        inputString = "C:\\Users\\demorozov\\IdeaProjects\\test.txt";
                        break;
                    case 2:
                        inputString = "C:\\Users\\demorozov\\IdeaProjects\\test2.txt";
                        break;
                }*/

                FileInputStream fstream = new FileInputStream(inputString);
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

                System.out.println();
                String strLine;
                while ((strLine = br.readLine()) != null){
                   switch (i){
                       case 1:
                           System.out.println(strLine);
                           allLines.add(strLine);
                           break;
                       case 2:
                           System.out.println(strLine);
                           forRemoveLines.add(strLine);
                           break;
                   }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Solution solution = new Solution();
        // solution.start();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

   /* public void run(){
        try {
            joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }*/

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            System.out.println("allLines.containsAll(forRemoveLines)");

            allLines.removeAll(forRemoveLines);
        } else {
            System.out.println("else");

            allLines.clear();
            throw  new CorruptedDataException();
        }

        /*for (String element: allLines) {
            System.out.println(element);
        }*/
    }
}
