package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("C:\\Users\\demorozov\\IdeaProjects\\test1.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User javarushUser = new User();
            javarushUser.setFirstName("firstName");
            javarushUser.setLastName("lastName");
            javarushUser.setBirthDate(new Date());
            javarushUser.setMale(true);
            javarushUser.setCountry(User.Country.RUSSIA);
            javaRush.users.add(javarushUser);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.users.get(0).getBirthDate());
            System.out.println(loadedObject.users.get(0).getBirthDate());
            if (javaRush.equals(loadedObject)) {
                System.out.println("javaRush.equals(loadedObject)");
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            String isUsersPresent = users != null ? "yes" : "no";
            fileWriter.write(isUsersPresent);
            fileWriter.newLine();
            fileWriter.flush();

            if (users != null) {
                for (User user: users) {
                    String isUserPresent = user != null ? "yes" : "no";
                    fileWriter.write(isUserPresent);
                    fileWriter.newLine();
                    fileWriter.flush();

                    if (user != null) {
                        String isUserFirstName = user.getFirstName() != null ? "yes" : "no";    // firstName
                        fileWriter.write(isUserFirstName);
                        fileWriter.newLine();
                        fileWriter.flush();

                        if (user.getFirstName() != null) {
                            fileWriter.write(user.getFirstName());
                            fileWriter.newLine();
                            fileWriter.flush();
                        }

                        String isUserLastName = user.getLastName() != null ? "yes" : "no";    // lastName
                        fileWriter.write(isUserLastName);
                        fileWriter.newLine();
                        fileWriter.flush();

                        if (user.getLastName() != null) {
                            fileWriter.write(user.getLastName());
                            fileWriter.newLine();
                            fileWriter.flush();
                        }

                        String isUserBirthDate = user.getBirthDate() != null ? "yes" : "no";    // birthDate
                        fileWriter.write(isUserBirthDate);
                        fileWriter.newLine();
                        fileWriter.flush();

                        if (user.getBirthDate() != null) {
                            fileWriter.write(String.valueOf(user.getBirthDate()));
                            fileWriter.newLine();
                            fileWriter.flush();
                        }

                        fileWriter.write(String.valueOf(user.isMale()));                        // isMale
                        fileWriter.newLine();
                        fileWriter.flush();

                        String isUserCountry = user.getCountry() != null ? "yes" : "no";        // country
                        fileWriter.write(isUserCountry);
                        fileWriter.newLine();
                        fileWriter.flush();

                        if (user.getCountry() != null) {
                            fileWriter.write(String.valueOf(user.getCountry()));
                            fileWriter.newLine();
                            fileWriter.flush();
                        }
                    }
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));
            String isUsersPresent = fileReader.readLine();

            // Загружать массив users ?
            if (isUsersPresent.equals("yes")) {
                List<User> loadedUsers = new ArrayList<>();

                while (fileReader.ready()) {
                    User loadedUser = null;

                    String isUserPresent = fileReader.readLine();
                    if (isUserPresent.equals("yes")) {
                        loadedUser = new User();

                        String isUserFirstName = fileReader.readLine();         // firstName
                        if (isUserFirstName.equals("yes")) {
                            loadedUser.setFirstName(fileReader.readLine());
                        }

                        String isUserLastName = fileReader.readLine();          // lastName
                        if (isUserLastName.equals("yes")) {
                            loadedUser.setLastName(fileReader.readLine());
                        }

                        String isUserBirthDate = fileReader.readLine();         // birthDate
                        if (isUserBirthDate.equals("yes")) {
/*
                            SimpleDateFormat parser = new SimpleDateFormat("dd.MM.yyyy");
                            String date = String.valueOf(parser.format(new Date()));

                            Date date1 = parser.parse(date);
                            */
                            SimpleDateFormat parser = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
                            loadedUser.setBirthDate(parser.parse(fileReader.readLine()));
                        }

                        loadedUser.setMale(Boolean.parseBoolean(fileReader.readLine()));   // isMale

                        String isUserCountry = fileReader.readLine();           // country
                        if (isUserCountry.equals("yes")) {
                            loadedUser.setCountry(User.Country.valueOf(fileReader.readLine()));
                        }
                    }
                    loadedUsers.add(loadedUser);
                }
                users = loadedUsers;
            } else {
                users = null;
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
