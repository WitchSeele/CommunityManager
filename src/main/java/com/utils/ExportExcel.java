package com.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExportExcel {
    public static Workbook getWorkbook(String fileName) {
        Workbook workbook = null;
        if (fileName.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (fileName.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            try {
                throw new Exception("invalid file name, should be xls or xlsx");
            } catch (Exception e) {
                System.out.print("必须是xls或者xlsx结尾的文件.");
                e.printStackTrace();
            }

        }
        return workbook;
    }

    public static Workbook getWorkbook(Workbook workbook, String title, String[] headers, List<Map<String, Object>> dataset, String pattern) {
        if (workbook == null) {
            return null;
        }
        Sheet sheet = workbook.createSheet(title);
        CellStyle style = workbook.createCellStyle();
        // 列名
        Row row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = row.createCell(i);
            sheet.setColumnWidth(i, 5000);
            //style.setAlignment(CellStyle.ALIGN_CENTER);
            cell.setCellValue(headers[i]);
        }

        Iterator<Map<String, Object>> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);

            Map map = it.next();
//            System.out.print(map.toString());
            Set<String> mapKey = (Set<String>) map.keySet();
//            System.out.print(mapKey.toString());
            Iterator<String> iterator = mapKey.iterator();
//            System.out.print(iterator.toString());
            int num = 0;
            while (iterator.hasNext()) {
                Cell cell = row.createCell(num);
                num++;
                String key = iterator.next();
//                System.out.print(key);
                Object object = map.get(key);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                if (object instanceof Double) {
                    cell.setCellValue((Double) object);
                } else if (object instanceof Date) {
                    String time = simpleDateFormat.format((Date) object);
                    cell.setCellValue(time);
                } else if (object instanceof BigDecimal) {
                    cell.setCellValue(((BigDecimal) object).doubleValue());
                } else if (object instanceof Calendar) {
                    Calendar calendar = (Calendar) object;
                    String time = simpleDateFormat.format(calendar.getTime());
                    cell.setCellValue(time);
                } else if (object instanceof Boolean) {
                    cell.setCellValue((Boolean) object);
                } else if (object instanceof Integer) {
                    cell.setCellValue((Integer) object);
                } else if (object instanceof Float) {
                    cell.setCellValue((float) object);
                } else {
                    if (object != null) {
                        cell.setCellValue(object.toString());
                    }
                }
            }
        }
        return workbook;
    }

    public static void download(String fileName, Workbook workbook, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
        String userAgent = request.getHeader("USER-AGENT");
        String newFilename = URLEncoder.encode(fileName, "UTF-8").replace("+", " ");
        ;

        if (userAgent != null) {
            if (userAgent.contains("edge") || userAgent.contains("Edge") || userAgent.contains("Trident") || userAgent.contains("trident")) {
                newFilename = URLEncoder.encode(fileName, "UTF-8").replace("+", " ");
            } else {
                newFilename = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
            }
        }
        try {
            response.addHeader("Content-Disposition", "attachment;filename=" + newFilename);
            response.setContentType("application/vnd.ms-excel");
            OutputStream toClient = response.getOutputStream();
            workbook.write(toClient);
            toClient.flush();
            toClient.close();
        } catch (FileNotFoundException e) {
            System.out.print("文件不存在");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.print("文件写入错误");
            e.printStackTrace();
        }
    }
}
