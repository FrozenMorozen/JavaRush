package com.javarush.task.task18.task1813;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:\\Users\\demorozov\\IdeaProjects\\test1.txt";

    private FileOutputStream original;

    public AmigoOutputStream(FileOutputStream fos) throws FileNotFoundException {
        super(fileName);
        this.original = fos;
    }

    @Override
    public void write(int b) throws IOException {
        this.original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.original.write(b, off, len);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.original.write(b);
    }

    @Override
    public void flush() throws IOException {
        this.original.flush();
    }

    @Override
    public void close() throws IOException {
        this.original.flush();
        String reservedPhrase = "JavaRush © All rights reserved.";
        this.original.write(reservedPhrase.getBytes());
        this.original.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
