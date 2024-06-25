package com.example.gpt.SSE;


import com.alibaba.fastjson2.JSON;
import com.example.gpt.MyEventSourceListener;
import com.example.gpt.pojo.GptReq;
import com.example.gpt.pojo.GptRes;
import okhttp3.*;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSources;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class GptService {

    /*private final WebClient webClient;


    public GptService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://{}}").build();
    }

    public Flux<String> streamOpenAIResponse(String prompt) {
        GptReq reqBody = new GptReq(prompt, "你是一个Java大师", "gpt-3.5-turbo");
        String JSONReqBody = JSON.toJSONString(reqBody);
        return webClient.post()
                .uri("/v1/chat/completions")
                .header("Authorization", "Bearer {YOUR-SK}")
                .header("Content-Type", "application/json")
                .bodyValue(JSONReqBody)
                .retrieve()
                .bodyToFlux(String.class)
                .doOnNext(response -> {
                    if(response.equals("[DONE]")){
                        return;
                    }
                    GptRes res = JSON.parseObject(response, GptRes.class);
                    String data = res.getChoices().get(0).getMessage().getContent();
                    System.out.print(data);
                })
                .doOnError(error -> {
                    if (error instanceof WebClientResponseException webClientResponseException) {
                        System.err.println("Error status code: " + webClientResponseException.getStatusCode());
                        System.err.println("Error response body: " + webClientResponseException.getResponseBodyAsString());
                    } else {
                        System.err.println("Error: " + error.getMessage());
                    }
                });
    }*/


    private final ExecutorService executor = Executors.newCachedThreadPool();
    //请求官方api的函数
    public SseEmitter sendMsg(String reqString){
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
                        .url("https://...{}/v1/chat/completions")
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Authorization", "Bearer " + "sk-...{}")
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

//
//    //请求官方api的函数
//    public String sendMsg(String reqString){
//        // 记录请求开始时间
//        long startTime = System.currentTimeMillis();
//
//        // 创建代理服务器的主机和端口
////        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(gptConfig.getProxyHostname(), gptConfig.getProxyPort()));
//        // 创建 OkHttpClient.Builder 实例，并配置代理
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        // 创建 OkHttpClient 实例
//        OkHttpClient client = builder.build();
//
//        //请求体格式
//        MediaType mediaType = MediaType.parse("application/json");
//
//        //创建请求体
//        GptReq gptReq = new GptReq(reqString, "你好", "gpt-3.5-turbo");
//        String gptReqJSON = JSON.toJSONString(gptReq);
//        RequestBody requestBody = RequestBody.create(gptReqJSON,mediaType);
//
//        // 创建 POST 请求
//        Request request = new Request.Builder()
//                .url("https://{YOUR_GPT}/chat/completions")
//                .addHeader("Content-Type", "application/json")
//                .addHeader("Authorization", "Bearer " + "{YOUR_SK}")
//                .post(requestBody)
//                .build();
//
//        try {
//            // 发送请求并获取响应
//            Response response = client.newCall(request).execute();
//            if(!response.isSuccessful()) return null;
//            // 记录响应结束时间
//                    long endTime = System.currentTimeMillis();
//                    long responseTime = endTime - startTime;
//
//                    // 打印响应时间
//                    System.out.println("Response time: " + responseTime + " ms");
//
//            String responseBody = Objects.requireNonNull(response.body()).string();
//            GptRes res =  JSON.parseObject(responseBody, GptRes.class);
//
//            return res.getChoices().get(0).getMessage().getContent();
//
//        } catch (IOException e) {
//            // 处理异常
//            e.printStackTrace();
//            return null;
//        }
//
//    }


}
