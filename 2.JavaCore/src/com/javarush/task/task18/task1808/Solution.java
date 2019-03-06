package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        //  C:\Users\demorozov\IdeaProjects\test1.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = reader.readLine();   // Файл для чтения
        String filename2 = reader.readLine();   // Файл для чтения первой половины
        String filename3 = reader.readLine();   // Файл для чтения воторой половины(большей если число нечетное)

        FileInputStream fis = new FileInputStream(filename1);
        FileOutputStream fos1 = new FileOutputStream(filename2);
        FileOutputStream fos2 = new FileOutputStream(filename3);

        while (fis.available() > 0){
            // Считать весь файл целиком в буффер
            byte[] buff = new byte[fis.available()];
            int byteCount = fis.read(buff);

            // Записать первую часть в файл filename2
            fos1.write(buff,0, (byteCount % 2 == 0) ? byteCount/2 : byteCount/2+1);

            // Записать вторую часть в файл filename3
            fos2.write(buff
                    , (byteCount % 2 == 0) ? byteCount/2 : byteCount/2 + 1
                    , (byteCount % 2 == 0) ? byteCount/2 : (byteCount - 1)/2);
        }

        fis.close();
        fos1.close();
        fos2.close();
    }
}
