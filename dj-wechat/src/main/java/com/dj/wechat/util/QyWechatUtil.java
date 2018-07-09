package com.dj.wechat.util;

public class QyWechatUtil {

    private static final String TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ID&corpsecret=SECRECT";

    /**
     * 获取access_token值
     * @param corpId
     * @param corpSecret
     * @return
     */
    public static String genAccessToken(String corpId,String corpSecret){

        String token_url = TOKEN_URL.replace("ID",corpId).replace("SECRECT",corpSecret);

        return token_url;
    }




}
