package com.example.gpt.SSE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

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