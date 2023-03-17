package io.learning.product.event.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.learning.core.domain.DistributedTransaction;
import io.learning.product.service.EventBus;
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
//                @QueueBinding(value = @Queue("txn-events-product"),
//                  exchange = @Exchange(type = ExchangeTypes.TOPIC, name = "txn-events"),
//                  key="txn-events")
//    })
    @PostMapping("/publish/product")
    public void onMessage(@RequestBody DistributedTransaction transaction) {
        log.debug("Transaction message received: {}", transaction);
        eventBus.sendTransaction(transaction);
    }

}
