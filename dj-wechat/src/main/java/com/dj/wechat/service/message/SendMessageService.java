package com.dj.wechat.service.message;

import com.dj.wechat.bean.message.base.BaseMessage;
import com.dj.wechat.bean.resp.SendMessageResp;

/**
 * @author guwei
 * @date 2018-07-10
 */
public interface SendMessageService {
	// 发送消息(文本、文本卡片、图文等)
	SendMessageResp sendMessage(String accessToken, BaseMessage message);
}
