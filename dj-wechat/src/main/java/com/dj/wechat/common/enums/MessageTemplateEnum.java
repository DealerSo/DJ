package com.dj.wechat.common.enums;

public enum MessageTemplateEnum {

	MSG_100001("100001", "你的名字：param0,年龄：param1")

	;

	private String code;
	private String content;

	private MessageTemplateEnum() {
	}

	private MessageTemplateEnum(String code, String content) {
		this.code = code;
		this.content = content;
	}
	
	// 根据code 查询 content
	public static String getTemplate(String code) {
		for(MessageTemplateEnum mte : MessageTemplateEnum.values()) {
			if(mte.getCode().equals(code)) {
				return mte.getContent();
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
