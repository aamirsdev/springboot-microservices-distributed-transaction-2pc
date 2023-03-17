package io.learning.transaction;

import io.learning.core.domain.DistributedTransaction;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
        DistributedTransaction transaction = new DistributedTransaction();
        transaction.setId("1");
        for (int i=0;i<50;i++) {
            //rabbitTemplate.convertAndSend("txn-events", "txn-events", transaction);
        }

    }
}
