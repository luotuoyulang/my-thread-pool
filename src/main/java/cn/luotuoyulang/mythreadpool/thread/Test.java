package cn.luotuoyulang.mythreadpool.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {
//        Executors.newFixedThreadPool(10);
//        Executors.newScheduledThreadPool(10);
//        Executors.newSingleThreadExecutor();
//        Executors.newSingleThreadScheduledExecutor();
//        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"    "+ finalI);
                }
            });
        }
        executorService.shutdown();
    }
}
