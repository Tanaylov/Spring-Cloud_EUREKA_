package app;

import com.netflix.discovery.EurekaNamespace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class ReaderApp {
    public static void main(String[] args) {
        SpringApplication.run(ReaderApp.class, args);
    }
}
