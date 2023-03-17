package io.learning.account.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.learning.account.service.EventBus;
import io.learning.core.domain.DistributedTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DistributedTransactionEventListener {

    @Autowired
    private EventBus eventBus;

//    @RabbitListener(bindings = {
//            @QueueBinding(value = @Queue("txn-events-account"), exchange = @Exchange(type = ExchangeTypes.TOPIC, name = "txn-events"), key="txn-events")
//    })
    @PostMapping("/publish/account")
    public void onMessage(@RequestBody DistributedTransaction transaction) {
        log.info("Transaction message received: {}", transaction);
        eventBus.sendTransaction(transaction);
    }

}
