package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        /*
                    C:\Users\demorozov\IdeaProjects
         */

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()))) {
            consoleReader.close();

            StringBuilder fileContent = new StringBuilder();
            while (fileReader.ready()){
                fileContent =fileContent.append(fileReader.readLine());
            }
            fileReader.close();

            Document document = Jsoup.parse(fileContent.toString(),  "", Parser.xmlParser());
            Elements elem = document.select(args[0]);
            for (Element element : elem) {
                System.out.println(element.outerHtml());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } ;

    }
}
