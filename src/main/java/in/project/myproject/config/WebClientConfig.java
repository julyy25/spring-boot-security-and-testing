package in.project.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com") // Set base URL for your API
                .defaultHeader("Accept", "application/json")    // Optional headers
                .defaultHeader("Content-Type", "application/json");
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.build(); // Builds the WebClient instance
    }
}
