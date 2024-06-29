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

    @GetMapping("/sse")
    public SseEmitter handleSse(@RequestParam String prompt) {
        return gptService.sendMsg(prompt);
    }




}