package ru.isu.nefrod;

import com.mongodb.client.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.isu.nefrod.drools.AntiFraudService;

@SpringBootApplication
public class NefrodApplication {

    public static void main(String[] args) {
        SpringApplication.run(NefrodApplication.class, args);
    }

    @Bean
    public AntiFraudService AntiFraudService() {
        return new AntiFraudService();
    }
}
