package com.example.demoeventsourcing.Config;

import com.example.demoeventsourcing.DemoAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    @Bean
    EventSourcingRepository<DemoAggregate> demoAggregateEventSourcingRepository(EventStore eventStore) {
//        EventSourcingRepository<AccountAggregate> repository = EventSourcingRepository.builder(AccountAggregate.class).eventStore(eventStore).build();
        EventSourcingRepository<DemoAggregate> repository = new EventSourcingRepository<>(DemoAggregate.class, eventStore);
        return repository;
    }
}
