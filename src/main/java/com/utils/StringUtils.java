package com.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StringUtils {
    public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat formatDay = new SimpleDateFormat("yyyy-MM-dd");

    public static boolean isEmpty(Map<String, Object> map) {
        return (map == null || map.isEmpty());
    }

    public static boolean isEmpty(List<?> list) {
        return (list == null || list.isEmpty());
    }

    public static String getStringValue(Object ob) {
        if (ob == null) {
            return null;
        }
        return ob.toString().trim();
    }

    public static Integer getIntegerValue(Object ob) {
        if (ob == null) {
            return 0;
        }
        try {
            return (Integer) ob;
        } catch (Exception e) {
            try {
                return Integer.valueOf(ob.toString().trim());
            } catch (Exception e1) {
                return 0;
            }
        }
    }

    public static Date getDateValue(Object ob) {
        if (ob == null) {
            return null;
        }
        try {
            return (Date) ob;
        } catch (Exception e) {
            try {
                return format.parse(ob.toString().trim());
            } catch (ParseException ex) {
                try {
                    return formatDay.parse(ob.toString().trim());
                } catch (ParseException exc) {
                    return null;
                }
            }
        }
    }

    public static Date DoubleToDate(Double dVal) {
        Date oDate = new Date();
        @SuppressWarnings("deprecation")
        long localOffset = oDate.getTimezoneOffset() * 60000; //系统时区偏移 1900/1/1 到 1970/1/1 的 25569 天
        oDate.setTime((long) ((dVal - 25569) * 24 * 3600 * 1000 + localOffset));

        return oDate;
    }

    public static BigDecimal getBigDecimalValue(Object ob) {
        if (ob == null) {
            return new BigDecimal(0);
        }
        try {
            return (BigDecimal) ob;
        } catch (Exception e) {
            try {
                return new BigDecimal(ob.toString().trim());
            } catch (Exception s) {
                return null;
            }
        }
    }

    /**
     * 设置字符长度  不足者 左侧添加 指定字符
     *
     * @param str1  元字符
     * @param lenth 指定长度
     * @param st2   指定字符
     * @return
     * @throws Exception
     */

    public static String strAppendStr(String str1, int lenth, String st2) throws Exception {
        StringBuilder strb1 = new StringBuilder(str1);
        lenth = lenth - str1.getBytes("GBK").length;
        while (lenth > 0) {
            lenth--;
            strb1.insert(0, st2);
        }
        return strb1.toString();
    }

    public static String getDateString(Date date, SimpleDateFormat format) {
        if (date == null) {
            date = new Date();
        }
        return format.format(date);
    }

    /* 导出txt文件
     * @author
     * @param	response
     * @param	text 导出的字符串
     * @return
     */
    public static void exportTxt(String filePath, String text) {
        File file = new File(filePath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        OutputStream output = null;
        try {
            output = new FileOutputStream(file);
            output.write(text.getBytes("GBK"));
            output.flush();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 判断目标字符串是否为空
     *
     * @param target
     * @return
     */
    public static Boolean isEmpty(String target) {
        if (target == null) {
            return true;
        }
        if (target.trim().length() <= 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断目标字符串是否不为空
     *
     * @param target
     * @return
     */
    public static Boolean isNotEmpty(String target) {
        if (target == null) {
            return false;
        }
        if (target.trim().length() <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 分裂字符串
     *
     * @param splitStr 需要分裂的字符串
     * @param spilt    此字符分裂
     * @return String[]
     */
    public static String[] splitString(String splitStr, String spilt) {
        if (isEmpty(splitStr) || isEmpty(spilt)) {
            return null;
        }
        String[] strA = splitStr.split(spilt);
        return strA;
    }

    /**
     * 分裂字符串
     *
     * @param splitStr 需要分裂的字符串
     * @param spilt    此字符分裂
     * @return Integer[]
     */
    public static Integer[] splitIntger(String splitStr, String spilt) {
        if (isEmpty(splitStr) || isEmpty(spilt)) {
            return null;
        }
        String[] strA = splitStr.split(spilt);
        Integer[] strB = new Integer[strA.length];
        for (int i = 0; i < strA.length; i++) {
            strB[i] = Integer.parseInt(strA[i]);
        }
        return strB;
    }


    public static String getdoubleString(double d) {
        double value = new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return value + "";
    }


    /**
     * 生成签名
     *
     * @param map
     * @return
     */
    public static String getSign(Map<String, String> map, String sign) {

        String result = "";
        try {
            List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(map.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {

                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });

            // 构造签名键值对的格式
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> item : infoIds) {
                if (item.getKey() != null || item.getKey() != "") {
                    String key = item.getKey();
                    String val = item.getValue();
                    if (!(val == "" || val == null)) {
                        sb.append(key + "=" + val + "&");
                    }
                }

            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(sign);
            System.out.print(sb.toString() + "\n");
            result = sb.toString();

            //进行MD5加密
            result = MD5Utils.getMD5(result);
        } catch (Exception e) {
            return null;
        }
        return result;
    }

    public static String getUUID32() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    public static String getnamelike(String name) {
        if (isEmpty(name)) {
            name = "";
        }
        name = "%" + name + "%";
        return name;
    }

    public static String getnamelikeBegin(String name) {
        if (isEmpty(name)) {
            name = "";
        }
        name = name + "%";
        return name;
    }

    /**
     * 获取文件扩展名
     *
     * @param filename 文件名
     * @return
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }
}
