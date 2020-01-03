package com.example.demoeventsourcing.Services;

import com.example.demoeventsourcing.Event.ObjectCreated;
import com.example.demoeventsourcing.Model.TestObject;
import com.example.demoeventsourcing.Repo.TestRepo;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestEventHandler {

    private final TestRepo repo;

    @Autowired
    public TestEventHandler(TestRepo repo) {
        this.repo = repo;
    }

    @EventHandler
    public void on(ObjectCreated event) {
        TestObject object = new TestObject(event.getMessage());
        repo.save(object);
    }
}
