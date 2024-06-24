package App.service;

import For.readerService.Reader;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ReaderProvider {

    private final WebClient webClient;

    private final String uri = "http://reader-service/api/reader/random";

    public ReaderProvider(ReactorLoadBalancerExchangeFilterFunction rlbeff) {
        webClient = WebClient.builder()
                .filter(rlbeff)
                .build();
    }

    public Reader getRandomReader() {
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(Reader.class)
                .block();
    }
}
