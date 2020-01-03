package com.example.demoeventsourcing.Config;


import com.mongodb.MongoClient;
import org.axonframework.config.EventProcessingConfiguration;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.mongo.DefaultMongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AggregateConfig {
    @Bean
    public EventStorageEngine eventStore(MongoClient client) {
        return new MongoEventStorageEngine(new DefaultMongoTemplate(client));
    }
}
