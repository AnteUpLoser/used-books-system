package com.example.gpt.SSE;

import com.alibaba.fastjson2.JSON;
import com.example.common.R;
import com.example.gpt.MyEventSourceListener;
import com.example.gpt.pojo.GptReq;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
public class GptController {

    @Autowired
    private GptService gptService;

    /*@GetMapping(value = "/stream-openai", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamOpenAI(@RequestParam String prompt) {
        return gptService.streamOpenAIResponse(prompt)
                .map(response -> "data:" + response + "\n\n");
    }*/



//    @GetMapping("/http/get")
//    public R<String> sendByHttp(@RequestParam String prompt){
//        return R.success(gptService.sendMsg(prompt));
//    }



    @GetMapping("/sse")
    public SseEmitter handleSse(@RequestParam String prompt) throws InterruptedException {
        return gptService.sendMsg(prompt);
    }




}