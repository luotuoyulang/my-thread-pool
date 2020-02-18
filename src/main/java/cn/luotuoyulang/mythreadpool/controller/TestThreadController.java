package cn.luotuoyulang.mythreadpool.controller;

import cn.luotuoyulang.mythreadpool.service.TestThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestThreadController {

    @Autowired
    private TestThreadService testThreadService;


    @GetMapping("a")
    public String test() throws InterruptedException {

        testThreadService.test();
        return "234234";
    }
}
