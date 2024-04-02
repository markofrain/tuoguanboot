package com.tencent.wxcloudrun.dto;

import lombok.Data;

/**
 * https://developers.weixin.qq.com/miniprogram/dev/wxcloudrun/src/guide/weixin/push.html
 */
@Data
public class MessageRequest {

    private String action;
    /**
     * 小程序/公众号的原始ID，资源复用配置多个时可以区别消息是给谁的
     */
    private String ToUserName;
    /**
     * 该小程序/公众号的用户身份openid
     */
    private String FromUserName;
    /**
     * 消息时间
     */
    private String CreateTime;
    /**
     * 消息类型
     */
    private String MsgType;
    /**
     * 消息内容
     */
    private String Content;
    /**
     * 唯一消息ID，可能发送多个重复消息，需要注意用此ID去重
     */
    private String MsgId;

}
