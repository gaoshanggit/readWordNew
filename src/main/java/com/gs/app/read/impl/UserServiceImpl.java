package com.gs.app.read.impl;

import com.gs.app.read.api.domain.*;
import com.gs.app.read.api.service.UserService;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2016/9/30 19:35
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginDao loginDao;

    public boolean hasMatchUser(String userName, String passWord) {
        int matchCount = userDao.getMatchCount(userName, passWord);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    public void loginSuccess(User user) {
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = getLoginLog(user);
        userDao.updateLoginInfo(user);
        loginDao.insertLogin(loginLog);
    }

    @Override
    public void demo(String str) {

        List<StudentBean> studentBeans = readExcel(str);
        System.out.println(studentBeans+"21GG");


    }

    private LoginLog getLoginLog(User user) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        return loginLog;
    }




    /**
     * 读取excel中的数据
     * @param path
     * @return List<StudentBean>
     */
    private List<StudentBean> readExcel(String path) {

        if (path != null && !path.equals("")) {
            String ext = getExt(path);
            if (ext!=null && !ext.equals("")) {
                if (ext.equals("xls")) {
                    return readXls(path);
                } else if (ext.equals("xlsx")) {
                    return readXlsx(path);
                }
            }
        }
        return new ArrayList<StudentBean>();
    }

    /**
     * 读取后缀为xls的excel文件的数据
     * @param path
     * @return List<StudentBean>
     * @author zhang 2015-08-18 00:10
     */
    private List<StudentBean> readXls(String path) {

        HSSFWorkbook hssfWorkbook = null;
        try {
            InputStream is = new FileInputStream(path);
            hssfWorkbook = new HSSFWorkbook(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StudentBean studentBean = null;
        List<StudentBean> list = new ArrayList<StudentBean>();
        if (hssfWorkbook != null) {
            // Read the Sheet
            for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                // Read the Row
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null) {
                        studentBean = new StudentBean();
                        HSSFCell no = hssfRow.getCell(0);
                        HSSFCell name = hssfRow.getCell(1);
                        HSSFCell age = hssfRow.getCell(2);
                        HSSFCell score = hssfRow.getCell(3);
                        studentBean.setNo(getValue(no));
                        studentBean.setName(getValue(name));
                        studentBean.setAge(getValue(age));
                        studentBean.setScore(Float.valueOf(getValue(score)));
                        list.add(studentBean);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 读取后缀为xlsx的excel文件的数据
     * @param path
     * @return List<StudentBean>
     */
    private List<StudentBean> readXlsx(String path) {

        XSSFWorkbook xssfWorkbook = null;
        try {
            InputStream is = new FileInputStream(path);
            xssfWorkbook = new XSSFWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StudentBean studentBean = null;
        List<StudentBean> list = new ArrayList<StudentBean>();
        if(xssfWorkbook!=null){
            // Read the Sheet
            for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
                if (xssfSheet == null) {
                    continue;
                }
                // Read the Row
                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    if (xssfRow != null) {
                        studentBean = new StudentBean();
                        XSSFCell no = xssfRow.getCell(0);
                        XSSFCell name = xssfRow.getCell(1);
                        XSSFCell age = xssfRow.getCell(2);
                        XSSFCell score = xssfRow.getCell(3);
                        studentBean.setNo(getValue(no));
                        studentBean.setName(getValue(name));
                        studentBean.setAge(getValue(age));
                        studentBean.setScore(Float.valueOf(getValue(score)));
                        list.add(studentBean);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 获取文件扩展名
     * @param path
     * @return String
      */
    private String getExt(String path) {
        if (path == null || path.equals("") || !path.contains(".")) {
            return null;
        } else {
            return path.substring(path.lastIndexOf(".") + 1, path.length());
        }
    }


    /**
     * 判断后缀为xlsx的excel文件的数据类型
     * @param xssfRow
     * @return String
     */
    @SuppressWarnings("static-access")
    private String getValue(XSSFCell xssfRow) {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

    /**
     * 判断后缀为xls的excel文件的数据类型
     * @param hssfCell
     * @return String
     */
    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

}
