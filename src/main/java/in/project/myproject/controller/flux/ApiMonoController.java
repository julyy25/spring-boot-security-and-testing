package in.project.myproject.controller.flux;

import in.project.myproject.modal.PostModal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/public/mono/api")
public class ApiMonoController {
    private final WebClient webClient;

    @GetMapping("/posts")
    public Mono<String> endpointApi() {
        return webClient.get()
                .uri("/posts/1")
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/posts/domain")
    public Mono<PostModal> endpointApi2() {
        return webClient.get()
                .uri("/posts/1")
                .retrieve()
                .bodyToMono(PostModal.class);
    }

    @GetMapping("/posts/{postId}")
    public Mono<String> endpointApi2(@PathVariable int postId) {
        return webClient.get()
                .uri("/posts/{id}", postId)
                .retrieve()
                .bodyToMono(String.class);
    }


    @GetMapping("/posts/{postId}/domain")
    public Mono<PostModal> endpointApi4(@PathVariable int postId) {
        return webClient.get()
                .uri("/posts/{id}", postId)
                .retrieve()
                .bodyToMono(PostModal.class);
    }
}
