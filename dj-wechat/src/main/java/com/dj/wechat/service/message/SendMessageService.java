package com.dj.wechat.service.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dj.wechat.bean.message.base.BaseMessage;
import com.dj.wechat.bean.resp.SendMessageResp;
import com.dj.wechat.util.WechatApiUrlUtil;
import com.dj.wechat.util.WechatUtil;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

/**
 * @author guwei
 * @date 2018-07-09
 * @description: 发送消息
 */
public class SendMessageService {

    private static Logger logger = LoggerFactory.getLogger(SendMessageService.class);

    public SendMessageResp sendMessage(String accessToken, BaseMessage message){
    	
        // 获取json字符串：将message对象转换为json字符串
        Gson gson = new Gson();

        String jsonMessage = gson.toJson(message);
        
        logger.info("Send Message:" + jsonMessage);

        String sendMsgUrl = WechatApiUrlUtil.SEND_MESSAGE_URL.replace("{ACCESS_TOKEN}",accessToken);

        JSONObject jsonObject = WechatUtil.httpRequest(sendMsgUrl,"POST",jsonMessage);
        
        SendMessageResp resp = null;
        
        if(jsonObject != null) {
        	resp = (SendMessageResp)JSONObject.toBean(jsonObject, SendMessageResp.class);
        }else {
        	resp = new SendMessageResp();
        	resp.setErrcode(-99);
        	resp.setErrmsg("请求企业微信消息接口时出现异常");
        }
        return resp;
    }

}
