package cn.luotuoyulang.mythreadpool.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class TestThreadService {

    @Async("testExecutor")
    public String test() throws InterruptedException {
        while (true){
            Thread.sleep(1000);
            System.out.println("你好啊。。。。。。");
        }
    }
}
