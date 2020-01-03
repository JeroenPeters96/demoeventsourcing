package com.example.demoeventsourcing.Services;

import com.example.demoeventsourcing.Model.TestObject;
import com.example.demoeventsourcing.Queries.FindAll;
import com.example.demoeventsourcing.Repo.TestRepo;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestQueryHandler {

    private final TestRepo repo;

    @Autowired
    public TestQueryHandler(TestRepo repo) {
        this.repo = repo;
    }

    @QueryHandler
    public List<TestObject> handle(FindAll query) {
        List<TestObject> returnList = new ArrayList<>();
        repo.findAll().iterator().forEachRemaining(returnList::add);
        return returnList;
    }
}
