package com.example.gpt.pojo;


import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String role;
    private String content;

    @JSONField(name = "role")
    public String getRole() {
        return role;
    }

    @JSONField(name = "content")
    public String getContent() {
        return content;
    }

    //创建系统消息
    public Message setSysMessage(String content){
        return new Message("system", content);
    }

    //创建用户消息
    public Message setUserMessage(String content){
        return new Message("user",content);
    }

}
