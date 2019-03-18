package com.example.demo.service.impl;

import com.example.demo.common.BusinessException;
import com.example.demo.dao.LoginDAO;
import com.example.demo.model.Login;
import com.example.demo.service.LoginService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDAO loginDAO;

    @Override
    public Login insert(Login login) {
        loginDAO.insert(login);
        return login;
    }

    @Override
    public Login update(Login login) {
         loginDAO.update(login);
        return login;
    }

    @Override
    public List<Login> selectByCondition(Login condition) {
        return null;
    }

    @Override
    public void checkPassword(String loginName, String password) {
        Login login = this.selectByLoginName(loginName);
        if (null == login || !password.equals(login.getPassword())) {
            throw new BusinessException("登录名或密码错误!");
        }
    }

    @Override
    public Login selectByLoginName(String loginName) {
        Login login = new Login();
        login.setLoginName(loginName);
        List<Login> loginList = loginDAO.selectByCondition(login);
        return !loginList.isEmpty() ? loginList.get(0) : null;
    }

    @Override
    public void addUser(Login var1) {
        this.insert(var1);
    }

    @Override
    public void validLoginName(String loginName) {
        Login login = new Login();
        login.setLoginName(loginName);
        List<Login> loginList = loginDAO.selectByCondition(login);
       if (!loginList.isEmpty()){
           throw new BusinessException("登陆名已存在!");
       }
    }

    public static void main(String[] args) {
        //导出测试
        //创建一个表格
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个Excel的Sheet页
        HSSFSheet sheet = workbook.createSheet();
        // 冻结行 不随滚轮滚动
        sheet.createFreezePane(0, 1);
        //设置列宽
        sheet.setColumnWidth(0, 9100);
        //单元格样式
        // Sheet样式
       HSSFCellStyle sheetStyle = workbook.createCellStyle();
       // 背景色的设定
       //sheetStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
       // 前景色的设定
       //sheetStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
       // 填充模式
       sheetStyle.setFillPattern(HSSFCellStyle.FINE_DOTS);
       // 设置列的样式
      /* for (int i = 0; i <= 14; i++) {
             sheet.setDefaultColumnStyle((short) i, sheetStyle);
       }*/
        // 设置字体
        HSSFFont headfont = workbook.createFont();
        headfont.setFontName("黑体");
        headfont.setFontHeightInPoints((short) 22);// 字体大小
        headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
        // 另一个样式
        HSSFCellStyle headStyle = workbook.createCellStyle();
        headStyle.setFont(headfont);//字体样式
        headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        //headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        headStyle.setLocked(true);//不可编辑
        headStyle.setWrapText(true);// 自动换行

        //设置表格
        HSSFRow row0 = sheet.createRow(0);//创建第一行
        // 设置行高
        row0.setHeight((short) 900);
        //创建第一行第一个单元格
        HSSFCell cell =row0.createCell(0);
        //设置此单元格的内容
        cell.setCellValue(new HSSFRichTextString("登陆名"));
        sheet.setColumnWidth(0, (short) (37 * 200));
        //设置此单元格样式
        cell.setCellStyle(headStyle);
        //创建第一行第二个单元格
        cell = row0.createCell(1);
        cell.setCellValue(new HSSFRichTextString("用户名"));
        cell.setCellStyle(headStyle);
        sheet.setColumnWidth(1, (short) (37 * 200));
        //填充数据
        List<Login> datas = datas();
        //循环创建表格数据
        for (int i = 0; i <datas.size() ; i++) {
            Login login = datas.get(i);
            //重新创建一行
            HSSFRow row = sheet.createRow(i+1);
            cell = row.createCell(0);
            cell.setCellValue(new HSSFRichTextString(login.getLoginName()));

            cell = row.createCell(1);
            cell.setCellValue(new HSSFRichTextString(login.getUserName()));
        }

        // 列尾
        int footRownumber = sheet.getLastRowNum();
        HSSFRow footRow = sheet.createRow(footRownumber + 1);
        HSSFCell footRowcell = footRow.createCell(0);
        footRowcell.setCellValue(new HSSFRichTextString("最后一行"));

        //1:使用File类创建一个要操作的文件路径
        File file = new File("D:" + File.separator + "demo" + File.separator + "test.xls");
        if(!file.getParentFile().exists()){ //如果文件的目录不存在
            file.getParentFile().mkdirs(); //创建目录
        }
        //2: 实例化OutputString 对象
        try {
            OutputStream output = new FileOutputStream(file);
            workbook.write(output);
            output.flush();
            output.close();
        } catch (IOException e) {
            System.out.println("导出失败"+e);;
        }
    }
    private static List<Login> datas(){
        List<Login> logins = new ArrayList<>();
        for (int i = 0; i < 111; i++) {
            Login login = new Login();
            login.setUserName("登录名："+i);
            login.setLoginName("用户名："+i);
            logins.add(login);
        }
        return logins;
    }

}
