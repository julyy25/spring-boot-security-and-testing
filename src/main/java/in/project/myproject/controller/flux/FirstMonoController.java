package in.project.myproject.controller.flux;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/public/mono/")
public class FirstMonoController {
    private final WebClient webClient;

    @GetMapping("/1")
    public Mono<String> endpoint1() {
        return Mono.just("Hello World");
    }

    @GetMapping("/2")
    public Mono<String> endpoint2() {
        return Mono.just("Hello World").delayElement(Duration.ofMillis(2000));
    }
}
