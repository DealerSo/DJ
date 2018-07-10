package com.dj.wechat.bean.resp;

import com.dj.wechat.bean.resp.base.BaseResp;

/**
 * @author guwei
 * @date 2018-07-10
 */
public class SendMessageResp extends BaseResp {

	private static final long serialVersionUID = -9202427859088289829L;

	/**
	 * 如果部分接收人无权限或不存在，发送仍然执行，但会返回无效的部分（即invaliduser或invalidparty或invalidtag），
	 * 常见的原因是接收人不在应用的可见范围内。
	 */
	private String invaliduser; // 不区分大小写，返回的列表都统一转为小写

	private String invalidparty;

	private String invalidtag;

	public String getInvaliduser() {
		return invaliduser;
	}

	public void setInvaliduser(String invaliduser) {
		this.invaliduser = invaliduser;
	}

	public String getInvalidparty() {
		return invalidparty;
	}

	public void setInvalidparty(String invalidparty) {
		this.invalidparty = invalidparty;
	}

	public String getInvalidtag() {
		return invalidtag;
	}

	public void setInvalidtag(String invalidtag) {
		this.invalidtag = invalidtag;
	}

}
