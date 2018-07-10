package com.dj.wechat.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dj.wechat.bean.message.TextMessage;
import com.dj.wechat.bean.req.TextMessageReq;
import com.dj.wechat.bean.resp.AccessTokenResp;
import com.dj.wechat.service.message.SendMessageService;
import com.dj.wechat.service.message.convert.MessageConvert;
import com.dj.wechat.util.WechatParamsUtil;
import com.dj.wechat.util.WechatUtil;

import net.sf.json.JSONObject;

/**
 * @author guwei
 * @date 2018-07-10
 */

@RestController
@RequestMapping("/message")
public class SendMessageController {

	private static Logger logger = LoggerFactory.getLogger(SendMessageController.class);

	@Autowired
	private SendMessageService sendMessageService;

	@PostMapping("/text/{json}")
	public String text(@PathVariable String json, HttpServletRequest request) {
		
		Object obj = request.getAttribute("params");
		if (obj == null) {
			return "";
		}
		String params = request.getAttribute("params").toString();
		JSONObject jsonObject = JSONObject.fromObject(params);
		TextMessageReq messageReq = (TextMessageReq) JSONObject.toBean(jsonObject, TextMessageReq.class);

		TextMessage message = MessageConvert.convertTextMessage(messageReq);

		// 这里需要改造,将token存储在数据库,同样也存储在缓存中
		AccessTokenResp accessToken = WechatUtil.getAccessToken(WechatParamsUtil.CORPID,WechatParamsUtil.CONTACT_CORPSECRET);

		sendMessageService.sendMessage(accessToken.getAccessToken(), message);

		return "ok";
	}

}
