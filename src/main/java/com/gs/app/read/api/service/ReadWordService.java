package com.gs.app.read.api.service;

import org.apache.poi.hwpf.usermodel.Range;

import java.io.FileInputStream;

/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2016/9/20 14:38
 */
public interface ReadWordService {

    /**
     *
     * @param fileInputStream
     * @return
     */
    public Range readWordTest(FileInputStream fileInputStream);

}
