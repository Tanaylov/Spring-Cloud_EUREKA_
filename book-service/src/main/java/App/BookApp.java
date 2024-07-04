package App;

import App.api.TestAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import starter.timer.aspect.RunTimer;


@SpringBootApplication
public class BookApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BookApp.class, args);

        RunTimer bean = context.getBean(RunTimer.class);
        TestAnnotation testAnnotation = new TestAnnotation();
        testAnnotation.method();
    }

}
