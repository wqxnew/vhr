package com.javamm.vhr.util;

import com.javamm.vhr.model.Employee;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class EmpExport {
    public static ResponseEntity<byte[]> emp2Xls(List<Employee> data) {
        //创建excel文档
        HSSFWorkbook sheets = new HSSFWorkbook();
        //创建文档摘要
        sheets.createInformationProperties();
        //获取并配置文档摘要信息
        DocumentSummaryInformation information = sheets.getDocumentSummaryInformation();
        //文档类别
        information.setCategory("员工信息");
        //文档管理员
        information.setManager("javamm");
        //设置公式信息
        information.setCompany("吴");
        //获取文档摘要信息
        SummaryInformation sumInfo = sheets.getSummaryInformation();
        //文档标题
        sumInfo.setTitle("员工信息表");
        //作者
        sumInfo.setAuthor("wu");
        sumInfo.setComments("本文档由javamm提供");
        HSSFCellStyle style = sheets.createCellStyle();
        style.setFillForegroundColor(IndexedColors.YELLOW.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle cellStyle = sheets.createCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

        //设置列宽
        HSSFSheet sheet = sheets.createSheet("员工信息表");
        sheet.setColumnWidth(0,5*256);
        sheet.setColumnWidth(1,10*256);
        sheet.setColumnWidth(2,12*256);
        sheet.setColumnWidth(3,5*256);
        sheet.setColumnWidth(4,12*256);
        sheet.setColumnWidth(5,20*256);
        sheet.setColumnWidth(6,10*256);
        sheet.setColumnWidth(7,10*256);
        sheet.setColumnWidth(8,16*256);
        sheet.setColumnWidth(9,12*256);
        sheet.setColumnWidth(10,15*256);
        sheet.setColumnWidth(11,20*256);
        sheet.setColumnWidth(12,16*256);
        sheet.setColumnWidth(13,14*256);
        sheet.setColumnWidth(14,14*256);
        sheet.setColumnWidth(15,12*256);
        sheet.setColumnWidth(16,8*256);
        sheet.setColumnWidth(17,20*256);
        sheet.setColumnWidth(18,20*256);
        sheet.setColumnWidth(19,15*256);
        sheet.setColumnWidth(20,8*256);
        sheet.setColumnWidth(21,25*256);
        sheet.setColumnWidth(22,14*256);
        sheet.setColumnWidth(23,15*256);
        sheet.setColumnWidth(24,15*256);
        sheet.setColumnWidth(25,15*256);
        //创建标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("编号");
        c0.setCellStyle(style);
        HSSFCell c1 = r0.createCell(1);
        c1.setCellValue("姓名");
        c1.setCellStyle(style);
        HSSFCell c2 = r0.createCell(2);
        c2.setCellValue("工号");
        c2.setCellStyle(style);
        HSSFCell c3 = r0.createCell(3);
        c3.setCellValue("性别");
        c3.setCellStyle(style);
        HSSFCell c4 = r0.createCell(4);
        c4.setCellValue("出生日期");
        c4.setCellStyle(style);
        HSSFCell c5 = r0.createCell(5);
        c5.setCellValue("身份证号码");
        c5.setCellStyle(style);
        HSSFCell c6 = r0.createCell(6);
        c6.setCellValue("婚姻状况");
        c6.setCellStyle(style);
        HSSFCell c7 = r0.createCell(7);
        c7.setCellValue("民族");
        c7.setCellStyle(style);
        HSSFCell c8 = r0.createCell(8);
        c8.setCellValue("籍贯");
        c8.setCellStyle(style);
        HSSFCell c9 = r0.createCell(9);
        c9.setCellValue("政治面貌");
        c9.setCellStyle(style);
        HSSFCell c10 = r0.createCell(10);
        c10.setCellValue("电子邮件");
        c10.setCellStyle(style);
        HSSFCell c11 = r0.createCell(11);
        c11.setCellValue("电话号码");
        c11.setCellStyle(style);
        HSSFCell c12 = r0.createCell(12);
        c12.setCellValue("联系地址");
        c12.setCellStyle(style);
        HSSFCell c13 = r0.createCell(13);
        c13.setCellValue("所属部门");
        c13.setCellStyle(style);
        HSSFCell c14 = r0.createCell(14);
        c14.setCellValue("职位");
        c14.setCellStyle(style);
        HSSFCell c15 = r0.createCell(15);
        c15.setCellValue("职称");
        c15.setCellStyle(style);
        HSSFCell c16 = r0.createCell(16);
        c16.setCellValue("聘用形式");
        c16.setCellStyle(style);
        HSSFCell c17 = r0.createCell(17);
        c17.setCellValue("最高学历");
        c17.setCellStyle(style);
        HSSFCell c18 = r0.createCell(18);
        c18.setCellValue("专业");
        c18.setCellStyle(style);
        HSSFCell c19 = r0.createCell(19);
        c19.setCellValue("毕业院校");
        c19.setCellStyle(style);
        HSSFCell c20 = r0.createCell(20);
        c20.setCellValue("入职日期");
        c20.setCellStyle(style);
        HSSFCell c21 = r0.createCell(21);
        c21.setCellValue("转正日期");
        c21.setCellStyle(style);
        HSSFCell c22 = r0.createCell(22);
        c22.setCellValue("合同起始日期");
        c22.setCellStyle(style);
        HSSFCell c23 = r0.createCell(23);
        c23.setCellValue("合同结束日期");
        c23.setCellStyle(style);
        HSSFCell c24 = r0.createCell(24);
        c24.setCellValue("合同期限(年)");
        c24.setCellStyle(style);
        HSSFCell c25 = r0.createCell(25);
        c25.setCellValue("工作状态");
        c25.setCellStyle(style);

        for(int i=0;i<data.size();i++){
            Employee emp = data.get(i);
            HSSFRow row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(emp.getId());
            row.createCell(1).setCellValue(emp.getName());
            row.createCell(2).setCellValue(emp.getWorkid());
            row.createCell(3).setCellValue(emp.getGender());
            HSSFCell r4 = row.createCell(4);
            r4.setCellStyle(cellStyle);
            r4.setCellValue(emp.getBirthday());
            row.createCell(5).setCellValue(emp.getIdcard());
            row.createCell(6).setCellValue(emp.getWedlock());
            row.createCell(7).setCellValue(emp.getNation().getName());
            row.createCell(8).setCellValue(emp.getNativeplace());
            row.createCell(9).setCellValue(emp.getPoliticsstatus().getName());
            row.createCell(10).setCellValue(emp.getEmail());
            row.createCell(11).setCellValue(emp.getPhone());
            row.createCell(12).setCellValue(emp.getAddress());
            row.createCell(13).setCellValue(emp.getDepartment().getName());
            row.createCell(14).setCellValue(emp.getJobLevel().getName());
            row.createCell(15).setCellValue(emp.getPosition().getName());
            row.createCell(16).setCellValue(emp.getEngageform());
            row.createCell(17).setCellValue(emp.getTiptopdegree());
            row.createCell(18).setCellValue(emp.getSchool());
            row.createCell(19).setCellValue(emp.getSpecialty());
            HSSFCell r20 = row.createCell(20);
            r20.setCellStyle(cellStyle);
            r20.setCellValue(emp.getBegindate());
            HSSFCell r21 = row.createCell(21);
            r21.setCellStyle(cellStyle);
            r21.setCellValue(emp.getConversiontime());
            HSSFCell r22 = row.createCell(22);
            r22.setCellStyle(cellStyle);
            r22.setCellValue(emp.getContractterm());
            HSSFCell r23 = row.createCell(23);
            r23.setCellStyle(cellStyle);
            r23.setCellValue(emp.getBegincontract());
            row.createCell(24).setCellValue(emp.getContractterm());
            row.createCell(25).setCellValue(emp.getWorkstate());
        }
        ByteArrayOutputStream byteOut= new ByteArrayOutputStream();
        HttpHeaders httpHeaders=new HttpHeaders();
        try {
            httpHeaders.setContentDispositionFormData("attachment",new String("员工表.xls".getBytes("UTF-8"),
                    "ISO-8859-1"));
            httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            sheets.write(byteOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(byteOut.toByteArray(),httpHeaders,HttpStatus.CREATED);
    }
}
