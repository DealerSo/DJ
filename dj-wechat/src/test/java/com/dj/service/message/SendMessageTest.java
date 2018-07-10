package com.dj.service.message;

import com.dj.wechat.bean.message.Text;
import com.dj.wechat.bean.message.TextcardMessage;
import com.dj.wechat.bean.resp.AccessTokenResp;
import com.dj.wechat.common.constant.Constant;
import com.dj.wechat.bean.message.TextMessage;
import com.dj.wechat.bean.message.Textcard;
import com.dj.wechat.service.message.SendMessageService;
import com.dj.wechat.service.message.impl.SendMessageServiceImpl;
import com.dj.wechat.util.WechatParamsUtil;
import com.dj.wechat.util.WechatUtil;
import org.junit.Test;

public class SendMessageTest {

	/**
	 * 发送普通消息
	 */
    @Test
    public void testSendMessage(){
        String content = "test,ok,测试1111";


        TextMessage message = new TextMessage();
        message.setTouser("GuWei");
        message.setMsgtype("text");
        message.setAgentid(WechatParamsUtil.CONTACT_AGENTID);

        Text text=new Text();
        text.setContent(content);
        message.setText(text);
        message.setSafe(0);

        AccessTokenResp accessToken = WechatUtil.getAccessToken(WechatParamsUtil.CORPID,WechatParamsUtil.CONTACT_CORPSECRET);

        String token = null;

        if(Constant.SUCCESS_CODE == accessToken.getErrcode()){
            token = accessToken.getAccessToken();

            SendMessageService sendMessageService = new SendMessageServiceImpl();
            sendMessageService.sendMessage(token,message);

        }else{
            System.out.println(accessToken.getErrcode());
        }
    }
    
    /**
     * 发送文本卡片
     */
    @Test
    public void testSendTextCardMessage() {
    	String title="领奖通知";
    	
    	String description="<div class=\"gray\">2018年07月10日</div> <div class=\"normal\">" +
                "恭喜你抽中iPhone X一台，领奖码：xxxx</div><div class=\"highlight\">" +
                "请于2018年07月31日前联系行政同事领取</div>";
    	String url="https://item.jd.com/19436846259.html";
    	
    	TextcardMessage message = new TextcardMessage();
    	message.setTouser("WangChunNa");
    	message.setMsgtype("textcard");
        message.setAgentid(WechatParamsUtil.CONTACT_AGENTID);
        
        Textcard textcard = new Textcard();
        textcard.setTitle(title);
        textcard.setDescription(description);
        textcard.setUrl(url);
        textcard.setBtntxt("详情");
        
        message.setTextcard(textcard);
        
        AccessTokenResp accessToken = WechatUtil.getAccessToken(WechatParamsUtil.CORPID,WechatParamsUtil.CONTACT_CORPSECRET);

        String token = null;
        
        if(Constant.SUCCESS_CODE == accessToken.getErrcode()){
            token = accessToken.getAccessToken();

            SendMessageService sendMessageService = new SendMessageServiceImpl();
            sendMessageService.sendMessage(token,message);

        }else{
            System.out.println(accessToken.getErrcode());
        }
    }
    
    /**
     * 发送图文消息
     */
    


}
