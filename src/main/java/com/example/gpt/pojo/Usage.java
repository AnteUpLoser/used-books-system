package com.example.gpt.pojo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

@Data
public class Usage {
    @JSONField(name = "prompt_tokens")
    private int promptTokens;       //发送所花费tokens
    @JSONField(name = "completion_tokens")
    private int completionTokens;    //响应所花费tokens
    @JSONField(name = "total_tokens")
    private int totalTokens;    //总花费tokens
}
