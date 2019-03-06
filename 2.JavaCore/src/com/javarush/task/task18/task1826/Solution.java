package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

/*
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.

 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
       /*
            -e fileName fileOutputName
            -d fileName fileOutputName

            -e C:\Users\demorozov\IdeaProjects\test1.txt C:\Users\demorozov\IdeaProjects\test2.txt
            -d C:\Users\demorozov\IdeaProjects\test2.txt C:\Users\demorozov\IdeaProjects\test3.txt
        */
       try {
           switch (args[0]){

               // Зашифровать данные из 1-го параметра во 2-ой параметр
               case "-e":
                   FileInputStream readerE = new FileInputStream(args[1]);
                   FileOutputStream writerE= new FileOutputStream(args[2]);

                   while (readerE.available()>0){
                       int readSymbolinANSII = readerE.read();
                       if (readSymbolinANSII != 0) {
                           writerE.write(readSymbolinANSII-1);
                       } else {
                           writerE.write(readSymbolinANSII+10);
                       }

                   }
                   readerE.close();
                   writerE.close();

                   break;

               // Расшифровать данные из  1-го параметра во 2-ой параметр
               case "-d":
                   FileInputStream readerD = new FileInputStream(args[1]);
                   FileOutputStream writerD= new FileOutputStream(args[2]);

                   //FileInputStream readerD = new FileInputStream("C:\\Users\\demorozov\\IdeaProjects\\test2.txt");
                   //FileOutputStream writerD= new FileOutputStream("C:\\Users\\demorozov\\IdeaProjects\\test3.txt");

                   while (readerD.available()>0){
                       int readSymbolinANSII = readerD.read();
                       if (readSymbolinANSII != 0) {
                           writerD.write(readSymbolinANSII+1);
                       } else {
                           writerD.write(readSymbolinANSII-10);
                       }
                   }
                   readerD.close();
                   writerD.close();

                   break;

               default: throw new Exception("Первый паараметр может принимать значения [-e/-d]");
           }
       } catch (IOException e) {
           e.printStackTrace();
       } catch (Exception e) {
            e.printStackTrace();
       }








    }

}
