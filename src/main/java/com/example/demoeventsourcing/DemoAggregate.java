package com.example.demoeventsourcing;

import com.example.demoeventsourcing.Commands.CreateObject;
import com.example.demoeventsourcing.Event.ObjectCreated;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

@Aggregate
public class DemoAggregate {

    @Autowired
    private EventSourcingRepository<DemoAggregate> repo;

    protected DemoAggregate() {}

    @AggregateIdentifier
    private String id;

    @CommandHandler
    public DemoAggregate(CreateObject command) {
        AggregateLifecycle.apply(new ObjectCreated(
                command.getCommandId(),
                command.getMessage()
        ));
    }

    @EventSourcingHandler
    public void on(ObjectCreated event) {
        this.id = event.getId();
    }
}
