package com.dj.wechat.bean.message;

import com.dj.wechat.bean.message.base.BaseMessage;

/**
 * 
 * @author guwei
 * @date 2018-07-10
 * @description: 文本卡片消息
 */
public class TextcardMessage extends BaseMessage {

	private static final long serialVersionUID = 2263932428330284460L;

	//文本卡片对象
	private Textcard textcard;

	public Textcard getTextcard() {
		return textcard;
	}

	public void setTextcard(Textcard textcard) {
		this.textcard = textcard;
	}
	
	

}
