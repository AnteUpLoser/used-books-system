package com.example.gpt.pojo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class SSERes {
    @JSONField(name = "id")
    private String chatId;
    @JSONField(name = "object")
    private String object;
    @JSONField(name = "created")
    private long created;
    @JSONField(name = "model")
    private String model;
    @JSONField(name = "choices")
    private List<GptChoices> choices;
    private String fingerprint;
}
