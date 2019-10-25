package com.huishang.reptile;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 发送 HTTP 请求到网页
 * @author zhang_fei
 * @create 2019-10-23 15:46
 */
public class ConnectionUtil {

    public static String Connect(String address) {
        URL url = null;
        HttpURLConnection conn = null;
        InputStream in = null;
        BufferedReader reader = null;
        StringBuffer stringBuffer = null;
        try {
            url = new URL(address);
            // 得到 connection 对象
            conn = (HttpURLConnection) url.openConnection();
            // 建立连接
            conn.connect();
            // 获取输入流
            in = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            stringBuffer = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
            try {
                in.close();
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return stringBuffer.toString();
    }

}
