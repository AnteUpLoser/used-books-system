package com.example.gpt.SSE;


import com.alibaba.fastjson2.JSON;
import com.example.gpt.pojo.GptReq;
import okhttp3.*;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSources;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class GptService {


    private final ExecutorService executor = Executors.newCachedThreadPool();

    //请求官方api的函数
    public SseEmitter sendMsg(String reqString) {
        SseEmitter emitter = new SseEmitter();
        executor.submit(() -> {
            try {
                // 创建 OkHttpClient 实例
                OkHttpClient client = new OkHttpClient.Builder().build();

                // 请求体格式
                MediaType mediaType = MediaType.parse("application/json");

                //创建请求体
                GptReq gptReq = new GptReq(reqString, "你好", "gpt-3.5-turbo");
                String gptReqJSON = JSON.toJSONString(gptReq);
                RequestBody requestBody = RequestBody.create(gptReqJSON, mediaType);

                // 创建 POST 请求
                Request request = new Request.Builder()
                        .url("https://api.chatanywhere.tech/v1/chat/completions")
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Authorization", "Bearer " + "sk-{YOUR_SK}")
                        .post(requestBody)
                        .build();

                MyEventSourceListener listener = new MyEventSourceListener(emitter);

                EventSource.Factory factory = EventSources.createFactory(client);
                EventSource eventSource = factory.newEventSource(request, listener);

                emitter.onCompletion(eventSource::cancel);

            } catch (Exception e) {
                emitter.completeWithError(e);
            }
        });
        return emitter;


    }
}