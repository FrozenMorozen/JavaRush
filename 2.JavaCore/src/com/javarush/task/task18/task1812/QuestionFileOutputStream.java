package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream aOutputStream;


    public QuestionFileOutputStream(AmigoOutputStream aOutputStream) {
        this.aOutputStream = aOutputStream;
    }

    @Override
    public void flush() throws IOException {
        aOutputStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        aOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        aOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        aOutputStream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String question = reader.readLine();

        if (question.equals("Д")) {
            aOutputStream.close();
        }
    }
}

