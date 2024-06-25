package com.example.gpt.pojo;


import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.util.ArrayList;

@Data
public class GptRes {
    @JSONField(name = "id")
    private String id;      //此次聊天完成的唯一标识
    @JSONField(name = "object")
    private String object;      //模型对象类型  chat.completion
    @JSONField(name = "created")
    private long created;       //创建时间戳 unix 秒
    @JSONField(name = "model")
    private String model;       //模型
    @JSONField(name = "system_fingerprint")
    private String systemFingerprint;       //系统指纹（官方的）
    @JSONField(name = "choices")
    private ArrayList<GptChoices> choices;      //聊天完成选项
    @JSONField(name = "usage")
    private Usage usage;                    //使用token统计


}
