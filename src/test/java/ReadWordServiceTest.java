import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.gs.app.read.api.domain.UserDao;
import org.junit.Test;
import com.gs.app.read.api.service.UserService;

import javax.annotation.Resource;

/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2016/9/21 12:05
 */

@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ReadWordServiceTest {

    /*  @Resource
      private ReadWordService readWordService;
      @Test
      public void readWordTest(){

          String filePath="d://test.doc";
          FileInputStream fileInputStream  =null;
          try {
              fileInputStream = new FileInputStream(new File(filePath));
          } catch (FileNotFoundException e) {
              e.printStackTrace();
          }
          readWordService.readWordTest(fileInputStream);
      }*/
    @Resource
    private UserDao userDao;

    @Autowired
    private UserService userService;
    @Test
    public void readWordTest() {

         boolean b1 = userService.hasMatchUser("admin","123456");
      /*  LoginLog loginLog = new LoginLog();
        loginLog.setIp("123.111.1111.1");
        loginLog.setUserId(UUID.randomUUID().toString());
        loginLog.setLoginLogId(UUID.randomUUID().toString());
        loginLog.setLoginDate(new Date());
        userDao.insertLogin(loginLog);*/

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
