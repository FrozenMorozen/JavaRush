package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat birthInfo = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        switch (args[0]) {
            case "-c":  create(args);
                break;
            case "-u":  update(args);
                break;
            case "-d":  delete(args);
                break;
            case "-i":  inform(args);
                break;
        }
    }

    public static void  create (String[] args) throws ParseException {
        Date birth = sdf.parse(args[3]);
        Person person = null;

        if (args[2].equals("м")) {
            person = Person.createMale(args[1], birth);
            allPeople.add(person);
        }
        else if (args[2].equals("ж")) {
            person = Person.createFemale(args[1], birth);
            allPeople.add(person);
        }
        System.out.println(allPeople.lastIndexOf(person));
    }

    public static void  update (String[] args) throws ParseException {
        Date birth = sdf.parse(args[4]);
        allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
        allPeople.get(Integer.parseInt(args[1])).setBirthDate(birth);

        if (args[3].equals("м")) {
            allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
        }
        else if (args[3].equals("ж")) {
            allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
        }
    }

    public static void delete (String[] args)  {
        allPeople.get(Integer.parseInt(args[1])).setName(null);
        allPeople.get(Integer.parseInt(args[1])).setSex(null);
        allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
    }

    public static void inform (String[] args)  {

        Person info  = allPeople.get(Integer.parseInt(args[1]));
        String name = info.getName();
        String halfOfName = name.substring(0, name.lastIndexOf(" "));

        String sex;
        if (info.getSex()==Sex.MALE) {
            sex = "м";
        } else {
            sex = "ж";
        }

        System.out.println(info.getName() + " " + sex + " "+ birthInfo.format(info.getBirthDate()));


    }
}