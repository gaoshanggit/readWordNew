import com.gs.app.read.api.domain.UserDao;
import com.gs.app.read.api.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2016/9/21 12:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ReadWordServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void hasMathUser() {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        System.out.println(b1 + "**************");
    }


    @Test
    public void select() {
        userService.findUserByUserName("admin");
    }

    @Test
    public  void  insetLog(){


    }

   /* public static void main(String[] args) {
        try {
            //word 2003： 图片不会被读取
            InputStream is = new FileInputStream(new File("d://test.doc"));
            WordExtractor ex = new WordExtractor(is);
            String text2003 = ex.getText();
            System.out.println(text2003);


          *//*  //word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后
            OPCPackage opcPackage = POIXMLDocument.openPackage("d://testdoc.docx");
            POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
            String text2007 = extractor.getText();
            System.out.println(text2007);*//*
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
