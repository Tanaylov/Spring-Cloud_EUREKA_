package App.service;

import For.bookService.Book;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BookProvider {

    private final WebClient webClient;
    private final String uri = "http://book-service/api/book/random";
//    private final EurekaClient eurekaClient;
    public BookProvider(ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
//        webClient = WebClient.create();
        webClient = WebClient.builder()
                .filter(loadBalancerExchangeFilterFunction)
                .build();
//        this.eurekaClient = eurekaClient;
    }

    public Book getRandomBook() {
//        BookResponse randomBook =
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(Book.class)
                .block();

//        return randomBook.getId();
    }

//    private String getBookServiceIP() {
//        Application application = eurekaClient.getApplication("book-service");
//        List<InstanceInfo> instances = application.getInstances();
//        int randomIndex = ThreadLocalRandom.current().nextInt(instances.size());
//        InstanceInfo randomInstance = instances.get(randomIndex);
//
//        return randomInstance.getHomePageUrl();
//    }

}
