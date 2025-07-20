package in.project.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "taskExecutor")  // Spring will use this as the default executor for @Async
    @Primary
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);      // Define the core pool size
        executor.setMaxPoolSize(8);       // Define the maximum pool size
        executor.setQueueCapacity(100);   // Define the queue capacity
        executor.setThreadNamePrefix("CustomAsync-");
        executor.initialize();
        return executor;
    }

    @Bean(name = "customExecutor")
    public Executor customExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);      // Define the core pool size
        executor.setMaxPoolSize(8);       // Define the maximum pool size
        executor.setQueueCapacity(100);   // Define the queue capacity
        executor.setThreadNamePrefix("AsyncExecutor-");
        executor.initialize();
        return executor;
    }
}