package com.example.gpt.pojo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class GptReq {
    private String model;
    private ArrayList<Message> messages;
    private boolean stream;

    public GptReq(String userPrompt, String sysPrompt, String model){
        Message systemMessage = new Message().setSysMessage(sysPrompt);
        Message userMessage = new Message().setUserMessage(userPrompt);
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(systemMessage);
        messages.add(userMessage);
        this.messages = messages;
        this.model = model;
        //TODO 修改是否流式输出
        this.stream = true;
    }
}
