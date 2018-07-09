package com.dj.service.message;

import com.dj.wechat.bean.AccessToken;
import com.dj.wechat.bean.message.Text;
import com.dj.wechat.bean.message.TextMessage;
import com.dj.wechat.common.Constant;
import com.dj.wechat.service.message.SendMessageService;
import com.dj.wechat.util.WechatParamsUtil;
import com.dj.wechat.util.WechatUtil;
import org.junit.Test;

import static com.dj.wechat.util.WechatUtil.getAccessToken;

public class SendMessageTest {

    @Test
    public void testSendMessage(){
        String content = "测试一下";


        TextMessage message = new TextMessage();
        message.setTouser("dsafdafdsafdssafdsaf");
        message.setMsgtype("text");
        message.setAgentid(WechatParamsUtil.CONTACT_AGENTID);

        Text text=new Text();
        text.setContent(content);
        message.setText(text);
        message.setSafe(0);

        AccessToken accessToken = WechatUtil.getAccessToken(WechatParamsUtil.CORPID,WechatParamsUtil.CONTACT_CORPSECRET);

        String token = null;

        if(Constant.SUCCESS_CODE == accessToken.getErrcode()){
            token = accessToken.getAccessToken();

            SendMessageService sendMessageService = new SendMessageService();
            sendMessageService.sendMessage(token,message);

        }else{
            System.out.println(accessToken.getErrcode());
        }
    }

}
