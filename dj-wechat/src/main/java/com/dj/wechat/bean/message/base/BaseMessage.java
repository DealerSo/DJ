package com.dj.wechat.bean.message.base;

import java.io.Serializable;

/**
 * @author guwei
 * @date 2018-07-09
 * @description: 消息发送公共属性
 */
public class BaseMessage implements Serializable {

    /**
     * 是否为必须：否
     * 说明：成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向该企业应用的全部成员发送
     */
    private String touser;

    /**
     * 是否为必须：否
     * 说明：部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
     */
    private String toparty;

    /**
     * 是否为必须：否
     * 说明：标签ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
     */
    private String totag;

    /**
     * 是否为必须：是
     * 说明：
     * (1) 消息类型文本，此时固定为：text  ("msgtype" : "text")
     * (2) 消息类型图片，此时固定为：image
     * (3) 消息类型语音，此时固定为：voice
     * (4) 消息类型视频，此时固定为：video
     * (5) 消息类型文件，此时固定为：file
     * (6) 消息类型文本卡片，此时固定为：textcard
     * (7) 消息类型图文，此时固定为：news
     * (8) 消息类型图文，此时固定为：mpnews (mpnews类型的图文消息，跟普通的图文消息一致，唯一的差异是图文内容存储在企业微信)
     */
    private String msgtype;

    /**
     * 是否为必须：是
     * 说明：企业应用的id，整型。可在应用的设置页面查看
     */
    private int agentid;


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

    public String getTotag() {
        return totag;
    }

    public void setTotag(String totag) {
        this.totag = totag;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public int getAgentid() {
        return agentid;
    }

    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }
}
