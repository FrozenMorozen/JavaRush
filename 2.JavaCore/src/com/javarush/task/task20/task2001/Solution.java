package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("C:\\Users\\demorozov\\IdeaProjects\\test1.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            // Поле name в классе Human не может быть пустым.
            BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            fileWriter.write(this.name);
            fileWriter.newLine();
            fileWriter.flush();

            String isAssetPresent = assets != null ? "yes" : "no";
            fileWriter.write(isAssetPresent);
            fileWriter.newLine();
            fileWriter.flush();

            if (this.assets != null) {
                for (Asset element: assets) {

                    String isAssetElementPresent = element != null ? "yes" : "no";
                    fileWriter.write(isAssetElementPresent);
                    fileWriter.newLine();
                    fileWriter.flush();

                    if (element != null) {

                        String isAssetNamePresent = element.getName() != null ? "yes" : "no";
                        fileWriter.write(isAssetNamePresent);
                        fileWriter.newLine();
                        fileWriter.flush();

                        if (element.getName() != null) {
                            fileWriter.write(element.getName());
                            fileWriter.newLine();
                            fileWriter.flush();
                        }

                        fileWriter.write(String.valueOf(element.getPrice()));
                        fileWriter.newLine();
                        fileWriter.flush();
                    }
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));
            name = fileReader.readLine();
            List<Asset> readingAssets = new ArrayList<>();


            String isAssetPresent = fileReader.readLine();
            if (isAssetPresent.equals("yes")) {
                String assetName = null;
                double assetPrice= 0;

                while (fileReader.ready()){
                    String isAssetElementPresent = fileReader.readLine();
                    if (isAssetElementPresent.equals("yes")) {

                        String isAssetNamePresent = fileReader.readLine();
                        if (isAssetNamePresent.equals("yes")) {
                            assetName = fileReader.readLine();

                        } else { // "no"
                            assetName = null;
                        }
                        assetPrice = Double.parseDouble(fileReader.readLine());

                    } else {    // "no"
                        assetName = null;
                        assetPrice = 0;
                    }

                    Asset readingAsset = new Asset(assetName, assetPrice);
                    readingAssets.add(readingAsset);
                }

            } else { // "no"
                readingAssets = null;
            }

            assets = readingAssets;
        }
    }
}
