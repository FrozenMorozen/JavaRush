package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    // Форматеры
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat birthInfo = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);

    /*
    -c name1 sex1 bd1 name2 sex2 bd2 ...
    -u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
    -d id1 id2 id3 id4 ...
    -i id1 id2 id3 id4 ...
    * */

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople){
                    create(args);
                }

                break;
            case "-u":
                synchronized (allPeople){
                    update(args);
                }

                break;
            case "-d":
                synchronized (allPeople){
                    delete(args);
                }

                break;
            case "-i":
                synchronized (allPeople){
                    inform(args);
                }

                break;
        }
    }

    public static void  create (String[] args) throws Exception {

        // Число аргументов должно быть кратно трём
        // 1-ый элемент не учитываем - "-с"
        if ((args.length - 1) % 3 !=0) {
            throw new Exception("Недопустимое число аргументов");
        }

        for (int i = 1; i < args.length; i=i+3) {

            Date birth = sdf.parse(args[i+2]);
            Person person = null;

            if (args[i+1].equals("м")) {
                person = Person.createMale(args[i], birth);
                allPeople.add(person);
            }
            else if (args[i+1].equals("ж")) {
                person = Person.createFemale(args[i], birth);
                allPeople.add(person);
            }
            System.out.println(allPeople.lastIndexOf(person));
        }
    }

    public static void  update (String[] args) throws Exception {

        // Число аргументов должно быть кратно трём
        // 1-ый  элемент не учитываем - "-u"
        if ((args.length - 1) % 4 !=0) {
            throw new Exception("Недопустимое число аргументов");
        }

        for (int i = 1; i < args.length; i=i+4) {

            Date birth = sdf.parse(args[i+3]);

            allPeople.get(Integer.parseInt(args[i])).setName(args[i+1]);
            allPeople.get(Integer.parseInt(args[i])).setBirthDate(birth);

            if (args[i+2].equals("м")) {
                allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
            }
            else if (args[i+2].equals("ж")) {
                allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
            }
        }
    }

    public static void delete (String[] args) throws Exception {

        if (args.length <= 1) {
            throw new Exception("Недопустимое число аргументов");
        }
        for (int i = 1; i < args.length; i++) {
            allPeople.get(Integer.parseInt(args[i])).setName(null);
            allPeople.get(Integer.parseInt(args[i])).setSex(null);
            allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
        }

    }

    public static void inform (String[] args) throws Exception {

        if (args.length <= 1) {
            throw new Exception("Недопустимое число аргументов");
        }

        for (int i = 1; i < args.length; i++) {

            Person info  = allPeople.get(Integer.parseInt(args[i]));

            String sex;
            if (info.getSex() == Sex.MALE) {
                sex = "м";
            } else {
                sex = "ж";
            }

            System.out.println(info.getName() + " " + sex + " "+ birthInfo.format(info.getBirthDate()));
        }
    }
}
