package com.dj.wechat.bean.resp;

import com.dj.wechat.bean.resp.base.BaseResp;

/**
 * @author guwei
 * @date 2018-07-09
 */
public class AccessTokenResp extends BaseResp {

	private static final long serialVersionUID = 8186280177968983697L;

    private String accessToken;
    
    // 单位：秒
    private int expiresIn;

	public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
