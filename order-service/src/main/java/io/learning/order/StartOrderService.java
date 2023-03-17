package io.learning.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class StartOrderService {

    public static void main(String[] args) {
        SpringApplication.run(StartOrderService.class, args);
    }
}
