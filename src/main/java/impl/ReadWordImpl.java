package impl;


import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2016/9/20 14:38
 */
public class ReadWordImpl {


    public static void main(String[] args) {
        try {
            //word 2003： 图片不会被读取
            InputStream is = new FileInputStream(new File("d://test.doc"));
            WordExtractor ex = new WordExtractor(is);
            String text2003 = ex.getText();
            System.out.println(text2003);

            //word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后
            OPCPackage opcPackage = POIXMLDocument.openPackage("d://testdoc.docx");
            POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
            String text2007 = extractor.getText();
            System.out.println(text2007);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
