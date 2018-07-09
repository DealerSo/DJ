package com.dj.wechat.bean;

import java.io.Serializable;

/**
 * @author guwei
 * @date 2018-07-09
 */
public class AccessToken implements Serializable {
    private static final long serialVersionUID = 8620350104474933280L;

    private int errcode;

    private String errmgs;

    private String accessToken;

    // 单位：秒
    private int expiresIn;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmgs() {
        return errmgs;
    }

    public void setErrmgs(String errmgs) {
        this.errmgs = errmgs;
    }

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
