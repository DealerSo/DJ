package com.dj.wechat.util;

import com.dj.wechat.bean.AccessToken;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

/**
 * @author guwei
 * @date 2018-07-09
 * @description: 企业微信的工具类
 */
public class WechatUtil {

    private static Logger logger = LoggerFactory.getLogger(WechatUtil.class);

    /**
     * https 请求 API 接口
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return 返回JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpRequest(String requestUrl,String requestMethod,String outputStr){
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
            logger.error("Qy Wechat server connection timed out.");
        } catch (Exception e) {
            logger.error("https request error:{}", e);
        }
        return jsonObject;
    }


    /**
     * 获取AccessToken
     * access_token的有效期通过返回的expires_in来传达，正常情况下为7200秒（2小时），有效期内重复获取返回相同结果，过期后获取会返回新的access_token
     * access_token至少保留512字节的存储空间
     * @param corpId
     * @param corpsecret
     * @return
     */
    public static AccessToken getAccessToken(String corpId,String corpsecret){
        AccessToken accessToken = null;
        // 替换参数
        String requestUrl = WechatApiUrlUtil.ACCESS_TOKEN_URL.replace("{corpid}",corpId).replace("{corpsecret}",corpsecret);
        /**
         * 返回json格式如下：
         * {
         *    "errcode":0，
         *    "errmsg":""，
         *    "access_token": "accesstoken000001",
         *    "expires_in": 7200
         * }
         */
        JSONObject jsonObject = httpRequest(requestUrl,"GET",null);
        if(jsonObject != null){
            try{
                accessToken = new AccessToken();
                accessToken.setErrcode(jsonObject.getInt("errcode"));
                accessToken.setErrmgs(jsonObject.getString("errmsg"));
                accessToken.setAccessToken(jsonObject.getString("access_token"));
                accessToken.setExpiresIn(jsonObject.getInt("expires_in")); //单位：秒
            }catch(JSONException e){
                logger.error("获取access token失败 errcode:{} errmsg:{}" + jsonObject.getInt("errcode") + ":" + jsonObject.getString("errmsg"));
            }
        }
        return accessToken;
    }


    public static void main(String[] args){
        String corpId = "ww8f4383114f03cce5";
        String corpsecret = "nR7p8-rG5eTZVXsBv5nwRYI-Zu0cipSFoU2eICc16iE";
        AccessToken accessToken = getAccessToken(corpId,corpsecret);
        System.out.println(accessToken.getErrcode());
        System.out.println(accessToken.getAccessToken());
        System.out.println(accessToken.getExpiresIn());
    }

}
