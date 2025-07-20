package in.project.myproject.service.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService1 {

    @Async
    public CompletableFuture<String> getMessagePart1() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(2000); // Simulated delay
            return "Hello Async1";
        });
    }

    @Async
    public CompletableFuture<String> getMessagePart2() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(5000); // Simulated delay
            return "World";
        });
    }

    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}