package com.dj.wechat.service.message;

import com.dj.wechat.bean.base.BaseMessage;
import com.dj.wechat.util.WechatApiUrlUtil;
import com.dj.wechat.util.WechatUtil;
import com.google.gson.Gson;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author guwei
 * @date 2018-07-09
 * @description: 发送消息
 */
public class SendMessageService {

    private static Logger logger = LoggerFactory.getLogger(SendMessageService.class);

    public Map<Integer,String> sendMessage(String accessToken, BaseMessage message){
        // errcode,errmsg
        Map<Integer,String> map = null;

        // 获取json字符串：将message对象转换为json字符串
        Gson gson = new Gson();

        String jsonMessge = gson.toJson(message);

        logger.info("send message:" + jsonMessge);

        String sendMsgUrl = WechatApiUrlUtil.SEND_MESSAGE_URL.replace("{ACCESS_TOKEN}",accessToken);

        JSONObject jsonObject = WechatUtil.httpRequest(sendMsgUrl,"POST",jsonMessge);

        logger.info("jsonObject : " + jsonObject.toString());

        return map;
    }

}
