package qflow;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public QueueRepository queueRepository() {
        return new InMemoryQueueRepository();
    }

}
