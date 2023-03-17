package io.learning.product;

import io.learning.core.domain.Product;
import io.learning.product.service.ProductService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Optional;

//@EnableDiscoveryClient
@SpringBootApplication
@EnableAsync
@EnableRabbit
public class StartProductApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StartProductApplication.class, args);
    }

    @Autowired
    ProductService service;
    @Override
    public void run(String... args) throws Exception {
//        Optional<Product> p = service.findById(1l);
//        System.out.println(p.isPresent());

        service.updateQuantity("1", 1l,10000);
        System.out.println("Done");
    }
}
