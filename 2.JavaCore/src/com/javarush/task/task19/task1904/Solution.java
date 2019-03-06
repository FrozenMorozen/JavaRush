package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        //PersonScannerAdapter psa = new PersonScannerAdapter(new Scanner(new File("C:\\Users\\demorozov\\IdeaProjects\\test1.txt")));
        //Person person = psa.read();
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }


        @Override
        public Person read() throws IOException {

            String personString = null;
            if (fileScanner.hasNextLine()) {
                personString = fileScanner.nextLine();
            }

            if (personString.length() > 0) {
                int separatorIndex = personString.indexOf(" ");

                String lastName = personString.substring(0, separatorIndex);
                personString = personString.substring(separatorIndex+1, personString.length());
                separatorIndex = personString.indexOf(" ");

                String firstName = personString.substring(0, separatorIndex);
                personString = personString.substring(separatorIndex+1, personString.length());
                separatorIndex = personString.indexOf(" ");

                String middleName = personString.substring(0, separatorIndex);
                personString = personString.substring(separatorIndex+1, personString.length());
                //separatorIndex = personString.indexOf(" ");

                Date birthDate = null;
                try {
                    SimpleDateFormat sdf= new SimpleDateFormat("dd MM yyyy");

                    birthDate = sdf.parse(personString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return new Person(firstName,middleName,lastName,birthDate);
            }
            return null;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
