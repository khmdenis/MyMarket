package com.org.mymarket.util;

import com.org.mymarket.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by denis on 02.09.16.
 */
public class ImageBuilder {
    private static final String PATH = "images/";

    public static Image build(MultipartFile image) throws NullPointerException, IOException {

        String directoryPath = PATH + image.getOriginalFilename();
        File file = new File(directoryPath);
        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(file));
        stream.write(image.getBytes());
        stream.close();
        return new Image(file.getPath(), image.getOriginalFilename());

    }
}

