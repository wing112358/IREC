package org.irecapi.Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author biehl
 */
public class GetPathWithURLUtil {


    /**
     * 获取文件本地路径
     *
     */
    public static String getPath(String url) throws Exception {
        String path="";
        URL temp = new URL(url);
        URLConnection conn = temp.openConnection();
        InputStream inputStream = conn.getInputStream();
        FileOutputStream outputStream = new FileOutputStream("./fileData/123.pdf"); // 保存到本地的文件路径和名称

        path="./fileData/123.pdf";

        byte[] buf = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buf)) > 0) {
            outputStream.write(buf, 0, bytesRead);
        }

        outputStream.close();
        inputStream.close();



        return path;


    }



    public static void main(String[] args) throws Exception {
        String path=getPath("https://chanzi-1252418820.cos.ap-nanjing.myqcloud.com/irec-sit/e99bef0aaead47bfa8d58685773b23f0.pdf");
        System.out.println();
    }
}