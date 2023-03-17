package io.learning.transaction;

import io.learning.core.domain.DistributedTransaction;
import io.learning.core.domain.DistributedTransactionStatus;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@SpringBootApplication
public class StartTransactionServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StartTransactionServerApplication.class, args);
    }

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("txn-events");
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        DistributedTransaction transaction = new DistributedTransaction();
        transaction.setId("ID");
        transaction.setStatus(DistributedTransactionStatus.CONFIRMED);
        transaction.setParticipants(new ArrayList<>());
        final HttpEntity<DistributedTransaction> requestEntity = new HttpEntity<>(transaction);
//        restTemplate.exchange("http://localhost:8082/publish/product", HttpMethod.POST, requestEntity, Object.class);

    }
}
