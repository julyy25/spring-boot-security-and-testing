package in.project.myproject.service.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class AsyncService2 {
    @Autowired
    private Executor customExecutor;

    public CompletableFuture<String> getMessagePart1() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(2000); // Simulated delay
            return "Hello Async2";
        }, customExecutor);
    }

    public CompletableFuture<String> getMessagePart2() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(5000); // Simulated delay
            return "World";
        }, customExecutor);
    }

    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}