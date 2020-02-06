package com.river.test;

import com.river.controller.ImageController;
import com.river.service.impl.ImageServiceImpl;

import javax.imageio.stream.FileImageInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class Test {

    public static void main(String[] args){
        ImageServiceImpl controller = new ImageServiceImpl();
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File("/Users/Duoy/IdeaProjects/river/src/main/java/com/river/test/test.jpeg"));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        }
        catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        }
        catch (IOException ex1) {
            ex1.printStackTrace();
        }
        controller.verifySense(data);
    }
}
