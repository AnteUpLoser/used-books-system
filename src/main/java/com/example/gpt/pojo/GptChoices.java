package com.example.gpt.pojo;


import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

@Data
public class GptChoices {
    @JSONField(name = "index")
    private int index;              //选项索引
//    @JSONField(name = "message") //非流式叫message
    @JSONField(name = "delta")    //流式是delta
    private Message message;        //选项中的响应消息
    //@JSONField(name = "logProb")  对数概率(功能比较复杂)

    @JSONField(name = "finish_reason")
    private String finishReason;

}
