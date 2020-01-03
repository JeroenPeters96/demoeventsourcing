package com.example.demoeventsourcing.Controller;

import com.example.demoeventsourcing.Model.TestObject;
import com.example.demoeventsourcing.Queries.FindAll;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.responsetypes.ResponseTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/qry")
public class TestQueryController {
    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @Autowired
    public TestQueryController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public ResponseEntity<List<TestObject>> getCreatedValues() {

        try {
            List<TestObject> foundObjects = queryGateway.query(
                    new FindAll(), ResponseTypes.multipleInstancesOf(
                            TestObject.class
                    )).get();
            return new ResponseEntity<>(foundObjects, HttpStatus.OK);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
