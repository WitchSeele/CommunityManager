package com.utils;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {
    public static final String TITLE = "title";
    public static final String CONTENT = "content";
    public static final String CONTENT_GRAY = "content_gray";
    public static final String CONTENT_GRAY_NO_FRAME = "content_gray_no_frame";

    public static CellStyle getCellstyleTITLE(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.NONE); //下边框
        style.setBorderLeft(BorderStyle.NONE);//左边框
        style.setBorderTop(BorderStyle.NONE);//上边框
        style.setBorderRight(BorderStyle.NONE);//右边框
        style.setAlignment(HorizontalAlignment.CENTER); // 居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        Font font = workbook.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 16);//设置字体大小
        style.setFont(font);
        return style;
    }

    public static CellStyle getCellstyleCONTENT(Workbook workbook) {
        CellStyle style2 = workbook.createCellStyle();
        style2.setBorderBottom(BorderStyle.THIN); //下边框
        style2.setBorderLeft(BorderStyle.THIN);//左边框
        style2.setBorderTop(BorderStyle.THIN);//上边框
        style2.setBorderRight(BorderStyle.THIN);//右边框
        style2.setAlignment(HorizontalAlignment.CENTER_SELECTION); // 居中
        style2.setVerticalAlignment(VerticalAlignment.CENTER);
        style2.setWrapText(true);
        Font font2 = workbook.createFont();
        font2.setFontName("黑体");
        font2.setFontHeightInPoints((short) 12);
        style2.setFont(font2);
        return style2;
    }

    public static CellStyle getCellstyleContentGrayNoFrame(Workbook workbook) {
        CellStyle style22 = workbook.createCellStyle();
        style22.setBorderBottom(BorderStyle.NONE); //下边框
        style22.setBorderLeft(BorderStyle.NONE);//左边框
        style22.setBorderTop(BorderStyle.NONE);//上边框
        style22.setBorderRight(BorderStyle.NONE);//右边框
        style22.setAlignment(HorizontalAlignment.LEFT); // 居左
        style22.setVerticalAlignment(VerticalAlignment.CENTER);
        Font font2 = workbook.createFont();
        font2.setFontName("黑体");
        font2.setFontHeightInPoints((short) 12);
        style22.setFont(font2);
        return style22;
    }

    public static CellStyle getCellstyleContentGray(Workbook workbook) {
        CellStyle style3 = workbook.createCellStyle();
        style3.setBorderBottom(BorderStyle.THIN); //下边框
        style3.setBorderLeft(BorderStyle.THIN);//左边框
        style3.setBorderTop(BorderStyle.THIN);//上边框
        style3.setBorderRight(BorderStyle.THIN);//右边框
        style3.setAlignment(HorizontalAlignment.CENTER_SELECTION); // 居中
        style3.setVerticalAlignment(VerticalAlignment.CENTER);
        style3.setWrapText(true);
        Font font3 = workbook.createFont();
        font3.setFontName("仿宋_GB2312");
        font3.setFontHeightInPoints((short) 12);
        style3.setFont(font3);
        return style3;
    }
}
