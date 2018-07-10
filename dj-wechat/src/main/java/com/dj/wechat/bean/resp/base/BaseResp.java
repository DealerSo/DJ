package com.dj.wechat.bean.resp.base;

import java.io.Serializable;


/**
 * @author guwei
 * @date 2018-07-10
 */
public class BaseResp implements Serializable {

	private static final long serialVersionUID = 3924030722446010832L;

	private int errcode;

	private String errmsg;

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}
