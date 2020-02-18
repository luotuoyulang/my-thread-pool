package cn.luotuoyulang.mythreadpool.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestThreadController {

    @Async("testExecutor")
    @GetMapping("a")
    public String test(){
        System.out.println(Thread.currentThread().getName());
        return "234234";
    }
}
