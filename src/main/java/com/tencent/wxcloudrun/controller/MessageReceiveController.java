package com.tencent.wxcloudrun.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.MessageRequest;
import com.tencent.wxcloudrun.dto.MessageResponse;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信公众号开发文档地址
 * https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_access_token.html
 * 公众号管理地址
 * https://mp.weixin.qq.com/advanced/advanced
 */
@RestController
@RequestMapping("/message")
public class MessageReceiveController {

/*    @PostMapping("receive")
    public Object receive(@RequestBody MessageRequest request){
        if (request.getAction()!=null && request.getAction().equals("CheckContainerPath")){
            System.out.println("收到预检请求");
            return ApiResponse.ok();
        }else{
            System.out.println("接受消息，消息信息为" + request.toString());
            System.out.println("我准备回复消息了");
            MessageResponse messageResponse = new MessageResponse();
            messageResponse.setToUserName(request.getFromUserName());
            messageResponse.setFromUserName(request.getToUserName());
            messageResponse.setMsgType("text");
            messageResponse.setContent("已经收到消息为" + request.getContent() +",返回给你 收到");
            messageResponse.setCreateTime(new Date().getTime() + "");
            System.out.println(messageResponse);
            return messageResponse;
        }
    }*/

    @PostMapping("receive")
    public Object receive(@RequestBody Map<String,Object> request, HttpServletResponse response) throws IOException {

        // {ToUserName=gh_bd70fc67ee13,
        // FromUserName=o0K-V6oEtzKEGWaB1SJsKQm80bew,
        // CreateTime=1712052047,
        // MsgType=text,
        // Content=真没了,
        // MsgId=24510694633440943}
        System.out.println("接受消息，消息信息为 " + request.toString());
        System.out.println("我准备回复消息了");
        Map<String,Object> repmap = new HashMap<>();
        repmap.put("ToUserName",request.get("FromUserName").toString());
        repmap.put("FromUserName",request.get("ToUserName").toString());
        repmap.put("MsgType",request.get("FromUserName").toString());
        repmap.put("Content",request.get("content") +",返回给你 收到");
        repmap.put("CreateTime",new Date().getTime() + "");
        System.out.println("我准备回复消息了 " + repmap);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(repmap);
        response.getWriter().write(s);
        return repmap;

    }
}
