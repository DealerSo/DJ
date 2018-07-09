package com.dj.wechat.bean.message;

import java.io.Serializable;

public class Text implements Serializable {
    private static final long serialVersionUID = -5912794895351104016L;
    //文本内容
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
