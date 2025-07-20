package in.project.myproject.controller.async;

import in.project.myproject.service.async.AsyncService1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/async1/")
public class PublicAsync1Controller {
    private final AsyncService1 asyncService1;

    @GetMapping("/greeting1")
    public CompletableFuture<String> asyncGreeting1() {
        CompletableFuture<String> part1 = asyncService1.getMessagePart1();
        return part1;
    }

    @GetMapping("/greeting2")
    public CompletableFuture<String> asyncGreeting2() {
        CompletableFuture<String> part2 = asyncService1.getMessagePart2();
        return part2;
    }

    @GetMapping("/greeting3")
    public CompletableFuture<String> asyncGreeting3() {
        CompletableFuture<String> part1 = asyncService1.getMessagePart1();
        CompletableFuture<String> part2 = asyncService1.getMessagePart2();

        return part1.thenCombine(part2, (greeting, name) -> greeting + ", " + name + "!");
    }

    @GetMapping("/greeting4")
    public CompletableFuture<String> asyncGreeting4() {
        CompletableFuture<String> part1 = asyncService1.getMessagePart1();
        CompletableFuture<String> part2 = asyncService1.getMessagePart2();

        // Use CompletableFuture.allOf to wait for both parts to complete
        return CompletableFuture.allOf(part1, part2)
                .thenApply(v -> {
                    // Retrieve results of each part
                    String greeting = part1.join();  // "Hello"
                    String name = part2.join();      // "World"
                    return greeting + ", " + name + "!";
                })
                .exceptionally(ex -> "Error occurred: " + ex.getMessage());
    }

}


