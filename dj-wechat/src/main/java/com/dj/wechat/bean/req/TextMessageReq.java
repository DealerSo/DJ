package com.dj.wechat.bean.req;

import java.io.Serializable;
/**
 * @author guwei
 * @date 2018-07-10
 */
public class TextMessageReq implements Serializable {

	private static final long serialVersionUID = 1874725661124401300L;

	// 消息接收者，多个接收者用‘|’分隔，最多支持1000个,需要发所有用@all
	private String touser;

	// 多个接收者用‘|’分隔，最多支持100个
	private String toparty;
	
	// 模板编号
	private String templateNo;
	
	// 模板替换参数,多个用 "|&|" 隔开, 比如： zhangsan|&|20
	private String templateParams;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getToparty() {
		return toparty;
	}

	public void setToparty(String toparty) {
		this.toparty = toparty;
	}

	public String getTemplateNo() {
		return templateNo;
	}

	public void setTemplateNo(String templateNo) {
		this.templateNo = templateNo;
	}

	public String getTemplateParams() {
		return templateParams;
	}

	public void setTemplateParams(String templateParams) {
		this.templateParams = templateParams;
	}
	
}
