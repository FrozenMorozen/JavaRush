package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type){
        if (type == null) {
            throw new IllegalArgumentException();
        }
        switch (type) {
            case BMP:
                //System.out.println("BmpReader");
                return new BmpReader();
            case JPG:
                //System.out.println("JpgReader");
                return new JpgReader();
            case PNG:
                //System.out.println("PngReader");
                return new PngReader();
            default:
                throw new IllegalArgumentException();
        }

    }
}
