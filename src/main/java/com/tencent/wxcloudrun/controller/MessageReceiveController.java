package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.MessageRequest;
import com.tencent.wxcloudrun.dto.MessageResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

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
    public Object receive(@RequestBody Map<String,Object> request){

        System.out.println("接受消息，消息信息为 " + request.toString());
        System.out.println("我准备回复消息了");
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setToUserName(request.get("FromUserName").toString());
        messageResponse.setFromUserName(request.get("ToUserName").toString());
        messageResponse.setMsgType("text");
        messageResponse.setContent("已经收到消息为" + request.get("content") +",返回给你 收到");
        messageResponse.setCreateTime(new Date().getTime() + "");
        System.out.println(messageResponse);
        return messageResponse;

    }
}
