package com.dj.wechat.util;


import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

/**
 * @author guwei
 * @date 2018-07-09
 * @description: 对参数进行加密解密
 */
public class AESUtil {

    private static Logger logger = LoggerFactory.getLogger(AESUtil.class);

    private static final String KEY = "ukMwa6kGt@3AB&sQdR";

    public static void main(String[] args) throws Exception {
        String source = "username=123&password=aaa&code=abc";
        System.out.println("Excepted:" + source);

        String result = enCrypt(source);
        System.out.println("加密后:" + result);
        String source_2 = deCrypt(result);
        System.out.println("Actual:" + source_2);
    }



    public static String enCrypt(String content) {
        try {
            byte[] sourceBytes = enCrypt(content, KEY);
            return Base64.encodeBase64URLSafeString(sourceBytes);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return content;
        }
    }

    /**
     * 加密函数
     *
     * @param content 加密的内容
     * @param strKey  密钥
     * @return 返回二进制字符数组
     * @throws Exception
     */
    public static byte[] enCrypt(String content, String strKey) throws Exception {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, new SecureRandom(strKey.getBytes()));

        SecretKey desKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, desKey);
        return cipher.doFinal(content.getBytes("UTF-8"));
    }



    public static String deCrypt(String content) throws Exception {
        byte[] targetBytes = Base64.decodeBase64(content);
        return deCrypt(targetBytes, KEY);
    }


    /**
     * 解密函数
     *
     * @param src    加密过的二进制字符数组
     * @param strKey 密钥
     * @return
     * @throws Exception
     */
    public static String deCrypt(byte[] src, String strKey) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, new SecureRandom(strKey.getBytes()));

        SecretKey desKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, desKey);
        byte[] cByte = cipher.doFinal(src);
        return new String(cByte, "UTF-8");
    }

}
