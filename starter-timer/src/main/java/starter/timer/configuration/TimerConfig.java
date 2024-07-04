package starter.timer.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import starter.timer.aspect.RunTimer;

@Configuration
@ConditionalOnProperty(value = "starter.timer.aspect.enabled", havingValue = "true")
public class TimerConfig {

    @Bean
    RunTimer runTimer() {
        return new RunTimer();
    }
}
