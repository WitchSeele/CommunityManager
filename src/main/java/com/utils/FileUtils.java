package com.utils;

import com.common.SessionHelper;
import com.exception.DataValidateFiledException;
import org.bouncycastle.util.io.BufferingOutputStream;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FileUtils {
    public static void uploadFIle(String dirPath, String fileName, MultipartFile file) {
// 文件保存位置
        File saveDir = new File(dirPath);
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }
        File dest = new File(dirPath + fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataValidateFiledException("文件保存失败");
        }
    }

    public static void delete(String filepath) {
        try {
            File dest = new File(filepath);
            dest.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void download(String filePath, String fileName, HttpServletResponse response) throws IOException {
        File dest = new File(filePath);
        String userAgent = SessionHelper.getRequest().getHeader("USER-AGENT");
        String newFilename = URLEncoder.encode(fileName, "UTF-8").replace("+", " ");
        if (userAgent != null) {
            if (userAgent.contains("edge") || userAgent.contains("Edge") || userAgent.contains("Trident") || userAgent.contains("trident")) {
                newFilename = URLEncoder.encode(fileName, "UTF-8").replace("+", " ");
            } else {
                newFilename = new String(fileName.getBytes(StandardCharsets.UTF_8), "ISO8859-1");
            }
        }
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + newFilename + "\"");
        InputStream in = new FileInputStream(dest);
        OutputStream toClient = new BufferingOutputStream(response.getOutputStream());
        //创建存放文件内容的数组
        byte[] buff = new byte[1];
        //所读取的内容使用n来接收
        int n;
        //当没有读取完时,继续读取,循环
        while ((n = in.read(buff)) != -1) {
            //将字节数组的数据全部写入到输出流中
            toClient.write(buff, 0, n);
        }
        toClient.flush();
        toClient.close();
        in.close();
    }
}
