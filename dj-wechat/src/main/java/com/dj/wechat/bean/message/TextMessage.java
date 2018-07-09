package com.dj.wechat.bean.message;

import com.dj.wechat.bean.base.BaseMessage;

public class TextMessage extends BaseMessage {
    private static final long serialVersionUID = 2798008713310564529L;

    // 消息内容，最长不超过2048个字节
    private Text text;

    // 表示是否是保密消息，0表示否，1表示是，默认0
    private int safe;

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public int getSafe() {
        return safe;
    }

    public void setSafe(int safe) {
        this.safe = safe;
    }
}
