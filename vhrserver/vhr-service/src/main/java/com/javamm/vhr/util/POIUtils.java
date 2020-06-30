package com.javamm.vhr.util;

import com.javamm.vhr.model.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class POIUtils {
    public static List<Employee> excel2Emp(MultipartFile file, List<Nation> allNation, List<Politicsstatus> allPoliticsstatus, List<Department> allDeptById, List<Position> allPositions, List<JobLevel> allJobLevels) {
        List<Employee> empList = new ArrayList<>();
        try {
            //创建workbook
            HSSFWorkbook hssfwk = new HSSFWorkbook(file.getInputStream());
            //获取workbook表单中的数量
            int numberOfSheets = hssfwk.getNumberOfSheets();
            for(int i = 0;i<numberOfSheets;i++){
                //获得表单
                HSSFSheet sheetAt = hssfwk.getSheetAt(i);
                //获取表单中的行数
                int numberOfRows = sheetAt.getPhysicalNumberOfRows();
                for(int j=0;j<numberOfRows; j++){
                    if(j==0)continue;//跳过标题行
                    HSSFRow row = sheetAt.getRow(j);//获取行
                    if(row==null)continue;
                    int ofCells = row.getPhysicalNumberOfCells();//获取列
                    Employee employee = new Employee();
                    for(int k=0;k<ofCells;k++){
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellType()){
                            case STRING:
                                String strCellValue = cell.getStringCellValue();
                                switch (k){
                                    case 1:
                                        employee.setName(strCellValue);
                                        break;
                                    case 2:
                                        employee.setWorkid(strCellValue);
                                        break;
                                    case 3:
                                        employee.setGender(strCellValue);
                                        break;
                                    case 5:
                                        employee.setIdcard(strCellValue);
                                        break;
                                    case 6:
                                        employee.setWedlock(strCellValue);
                                        break;
                                    case 7:
                                        int natinIndex = allNation.indexOf(new Nation(strCellValue));
                                        employee.setNationid(allNation.get(natinIndex).getId());
                                        break;
                                    case 8:
                                        employee.setNativeplace(strCellValue);
                                        break;
                                    case 9:
                                        int poIndex = allPoliticsstatus.indexOf(new Politicsstatus(strCellValue));
                                        employee.setPoliticid(allPoliticsstatus.get(poIndex).getId());
                                        break;
                                    case 10:
                                        employee.setEmail(strCellValue);
                                        break;
                                    case 11:
                                        employee.setPhone(strCellValue);
                                        break;
                                    case 12:
                                        employee.setAddress(strCellValue);
                                        break;
                                    case 13:
                                        int depindex = allDeptById.indexOf(new Department(strCellValue));
                                        employee.setDepartmentid(allDeptById.get(depindex).getId());
                                        break;
                                    case 14:
                                        int jobIndex = allJobLevels.indexOf(new JobLevel(strCellValue));
                                        employee.setJoblevelid(allJobLevels.get(jobIndex).getId());
                                        break;
                                    case 15:
                                        int posIndex = allPositions.indexOf(new Position(strCellValue));
                                        employee.setPosid(allPositions.get(posIndex).getId());
                                        break;
                                    case 16:
                                        employee.setEngageform(strCellValue);
                                        break;
                                    case 17:
                                        employee.setTiptopdegree(strCellValue);
                                        break;
                                    case 18:
                                        employee.setSpecialty(strCellValue);
                                        break;
                                    case 19:
                                        employee.setSchool(strCellValue);
                                        break;
                                    case 25:
                                        employee.setWorkstate(strCellValue);
                                        break;
                                }
                                break;
                                default:{
                                    switch (k){
                                        case 4:
                                            employee.setBirthday(cell.getDateCellValue());
                                            break;
                                        case 20:
                                            employee.setBegindate(cell.getDateCellValue());
                                            break;
                                        case 21:
                                            employee.setConversiontime(cell.getDateCellValue());
                                            break;
                                        case 22:
                                            employee.setBegincontract(cell.getDateCellValue());
                                            break;
                                        case 23:
                                            employee.setEndcontract(cell.getDateCellValue());
                                            break;
                                        case 24:
                                            employee.setContractterm(cell.getNumericCellValue());
                                            break;
                                    }
                                }
                                break;
                        }
                    }
                    empList.add(employee);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return empList;
    }
}
