package com.dj.wechat.service.message.convert;

import com.dj.wechat.bean.message.Text;
import com.dj.wechat.bean.message.TextMessage;
import com.dj.wechat.bean.req.TextMessageReq;
import com.dj.wechat.common.enums.MessageTemplateEnum;
import com.dj.wechat.util.WechatParamsUtil;

public class MessageConvert {
	
	
	public static TextMessage convertTextMessage(TextMessageReq messageReq) {
		 TextMessage message = new TextMessage();
	     message.setTouser(messageReq.getTouser());
	     message.setToparty(messageReq.getToparty());
	     message.setMsgtype("text");
	     message.setAgentid(WechatParamsUtil.CONTACT_AGENTID);

	     Text text=new Text();
	     // 根据模板编号获取模板内容
	     String content = MessageTemplateEnum.getTemplate(messageReq.getTemplateNo());
	     String templateParams = messageReq.getTemplateParams(); 
	     String[] tParams = templateParams.split("\\|&\\|");
	     // 替换模板参数
	     for(int i = 0 ; i < tParams.length; i++) {
	    	 content = content.replace("param"+i, tParams[i]);
	     }
	     text.setContent(content);
	     message.setText(text);
	     message.setSafe(0);
		
	     return message;
	}
	
}
