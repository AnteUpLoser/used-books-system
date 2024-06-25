package com.example.gpt;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.gpt.SSE.GptController;
import okhttp3.Response;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

public class MyEventSourceListener extends EventSourceListener {

    private final SseEmitter emitter;

    public MyEventSourceListener(SseEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void onOpen(EventSource eventSource, Response response) {
        System.out.println("Connection opened");
    }

    @Override
    public void onEvent(EventSource eventSource, String id, String type, String data) {
        JSONObject jsonObject = JSON.parseObject(data);
        JSONObject choicesObject = jsonObject.getJSONArray("choices").getJSONObject(0);
        JSONObject deltaObject = choicesObject.getJSONObject("delta");
        String content = deltaObject.getString("content");
        try {
            Thread.sleep(100);
            System.out.print(content);
            emitter.send(SseEmitter.event().data(content));
        } catch (InterruptedException | IOException e) {
            System.err.println("异常中断了！");
        }

    }

    @Override
    public void onClosed(EventSource eventSource) {
        System.out.println("Connection closed");
    }

    @Override
    public void onFailure(@NotNull EventSource eventSource, @Nullable Throwable t, @Nullable Response response) {
        System.err.println("异常中断！");
    }
}