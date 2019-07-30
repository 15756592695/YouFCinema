package com.cinema.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Upload {
    //上传头像的地址
    private static String UPLOADED_FOLDER = "E://idea//endpro4//" +
            "YouFCinema//YouFCinema//YouFCinema_user8247//src//" +
            "main//resources//static//headimg//";

    public Path UploadHeadImg(MultipartFile file){
        try {
            System.out.println("开始上传");
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            System.out.println("上传成功");
            Files.write(path, bytes);
            return path;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
