package com.gs.app.read.impl;

import com.gs.app.read.api.service.ReadWordService;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.util.Assert;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2016/9/20 14:38
 */

@Service("readWordService")
public class ReadWordImpl implements ReadWordService {

    /**
     *
     * @param fileInputStream
     * @return
     */
    public Range readWordTest(FileInputStream fileInputStream){
        Assert.notNull(fileInputStream, "fileInputStream is Null!");
        HWPFDocument hdt = null;
        try {
            hdt = new HWPFDocument(fileInputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Range harderRange= hdt.getHeaderStoryRange();
        //替换word页眉内容

        //读取页脚内容
        Range footRange=hdt.getFootnoteRange();

        //读取word文本内容
        Range bodyRange = hdt.getRange();

        return null;
    }







}
