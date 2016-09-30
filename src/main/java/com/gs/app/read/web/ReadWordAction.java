package com.gs.app.read.web;

import com.gs.app.read.api.service.ReadWordService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2016/9/26 16:00
 */
public class ReadWordAction {

    private static ReadWordService readWordService;


    public static void main(String[] args) {
        String filePath="d://test.doc";
        FileInputStream fileInputStream  =null;
        try {
            fileInputStream = new FileInputStream(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        readWordService.readWordTest(fileInputStream);
    }

}
