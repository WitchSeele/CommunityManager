package com.utils;

import com.exception.DataValidateFiledException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class InputExcel {
    /********************************************************************************
     *  操作jar包对应信息和Excel表的名称对应
     *  HSSFWorkbook/XSSFWorkbook/Workbook                       工作簿
     *  HSSF Sheet/Sheet                             工作表
     *  HSSF Row                                     行
     * HSSF Cell                                     单元格
     * HSSF Font                                     字体
     * HSSF Name                                     名称
     * HSSF DataFormat                               日期格式
     * HSSFHeader                                   表头
     * HSSFFooter                                   表尾
     * HSSFCellStyle                               单元格样式设计
     * HSSFDateUtil                                  日期
     * HSSFPrintSetup                               打印
     * HSSFErrorConstants                         错误信息表
     *******************************************************************************/

    /** ******************************************************
     3、导入Excel常用的方法：
     POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("d:/test.xls"));    
     HSSFWorkbook wb = new HSSFWorkbook(fs);  //得到Excel工作簿对象   
     HSSFSheet sheet = wb.getSheetAt(0);   //得到Excel工作表对象   
     HSSFRow row = sheet.getRow(i);  //得到Excel工作表的行   
     HSSFCell cell = row.getCell((short) j);  //得到Excel工作表指定行的单元格 
     cellStyle = cell.getCellStyle();  //得到单元格样式 
     **********************************************************/

    /********************************************************
     4、导出Excel常用的方法：
     HSSFWorkbook wb = new HSSFWorkbook();  //创建Excel工作簿对象   
     HSSFSheet sheet = wb.createSheet("new sheet");  //创建Excel工作表对象     
     HSSFRow row = sheet.createRow((short)0);  //创建Excel工作表的行   
     cellStyle = wb.createCellStyle();  //创建单元格样式   
     row.createCell((short)0).setCellStyle(cellStyle);  //创建Excel工作表指定行的单元格   
     row.createCell((short)0).setCellValue(1);  //设置Excel工作表的值  
     ************************************************************/


    public static final String OFFICE_EXCEL_XLS = "xls";  //2003版
    public static final String OFFICE_EXCEL_XLSX = "xlsx";//2007版

    /**
     * 描述：根据文件后缀，自适应上传文件的版本
     */
    public static Workbook getWorkbook(InputStream inStr, String fileName) throws IOException {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (OFFICE_EXCEL_XLS.equals(fileType)) {
            wb = new HSSFWorkbook(inStr);  //2003-
        } else if (OFFICE_EXCEL_XLSX.equals(fileType)) {
            wb = new XSSFWorkbook(inStr);  //2007+
        } else {
            throw new DataValidateFiledException("解析的文件格式有误！");
        }
        return wb;
    }

    /**
     * Excel导入
     *
     * @param in          文件 二进制流
     * @param fileName    文件名字
     * @param startRowNum 数据记录起始行数, NULL 表示 全部都要读取
     * @param sheetNo     sheet编号，从0开始,必填
     * @return
     */
    public static List<List<Object>> getBankListBySheetno(InputStream in, String fileName, Integer startRowNum, int sheetNo, int titleNo) {
        List<List<Object>> list = null;
        //创建Excel工作薄
        Workbook work = null;
        try {
            work = getWorkbook(in, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataValidateFiledException("该文件无法解析！");
        }
        if (null == work) {
            throw new DataValidateFiledException("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        list = new ArrayList<List<Object>>();
        //遍历Excel中所有的sheet
        sheet = work.getSheetAt(sheetNo);
        //遍历当前sheet中的所有行
        //包涵头部，所以要小于等于最后一列数,这里也可以在初始值加上头部行数，以便跳过头部
        if (startRowNum != null) {
        } else {
            startRowNum = sheet.getFirstRowNum();
        }
        Row title = sheet.getRow(titleNo);
        for (int j = startRowNum; j <= sheet.getLastRowNum(); j++) {
            //读取一行
            row = sheet.getRow(j);
            //去掉空行和表头
            if (row == null || row.getFirstCellNum() == j || row.getLastCellNum() < 0) {
                continue;
            }
            //遍历所有的列
            List<Object> li = new ArrayList<Object>();
            for (int y = title.getFirstCellNum(); y < title.getLastCellNum(); y++) {
                cell = row.getCell(y);
                li.add(getCellValue(cell));
            }
            list.add(li);
        }
        return list;
    }

    private static NumberFormat numberFormat = NumberFormat.getNumberInstance();

    static {
        numberFormat.setGroupingUsed(false);
    }

    /**
     * 描述：对表格中数值进行格式化
     */
    public static Object getCellValue(Cell cell) {
        Object value = null;
        DecimalFormat df = new DecimalFormat("0");  //格式化字符类型的数字
        DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");  //日期格式化
        if (cell == null) {
            value = "";
            return value;
        } else {
            if (cell.getCellType() == null) {
                value = "";
                return value;
            }
            switch (cell.getCellType()) { //目前版本还好没有取消获取枚举变量的对应code值方法，
                case STRING:
                    value = cell.getRichStringCellValue().getString().trim();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        value = sdf1.format(cell.getDateCellValue());
                    } else {
                        value = numberFormat.format(cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    value = cell.getBooleanCellValue();
                    break;
                case BLANK:
                    value = "";
                    break;
                case FORMULA:
                    cell.setCellType(CellType.STRING);
                    String cellValue = cell.getStringCellValue();
                    if (StringUtils.isEmpty(cellValue) || "#N/A".equals(cellValue)) {
                        value = "";
                    } else {
                        try {
                            value = new BigDecimal(cellValue).setScale(2, RoundingMode.HALF_UP);
                        } catch (Exception e) {
                            value = cell.getStringCellValue().trim();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return value;
    }
}
