package cn.luotuoyulang.mythreadpool.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "thread.push.task.pool")
@Data
public class TaskThreadPoolConfig {
    private int corePoolSize = 10;

    private int maxPoolSize = 100;

    private int keepAliveSeconds = 60;

    private int queueCapacity = 200;

    private String threadNamePrefix = "xiaoli";
}

