package com.tencent.wxcloudrun.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * https://developers.weixin.qq.com/miniprogram/dev/wxcloudrun/src/development/weixin/callback.html#%E4%B8%80%E3%80%81%E8%A2%AB%E5%8A%A8%E5%9B%9E%E5%A4%8D
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageResponse {

    private String ToUserName; //用户OPENID
    private String FromUserName; //公众号/小程序原始ID
    private String CreateTime; // 发送时间 整型，例如：1648014186
    private String MsgType; //text
    private String Content; //文本消息

}
