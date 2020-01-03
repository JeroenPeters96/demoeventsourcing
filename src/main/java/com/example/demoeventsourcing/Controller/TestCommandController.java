package com.example.demoeventsourcing.Controller;

import com.example.demoeventsourcing.Commands.CreateObject;
import com.example.demoeventsourcing.Repo.TestRepo;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/cmd")
public class TestCommandController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;
    private final TestRepo repo;

    @Autowired
    public TestCommandController(CommandGateway commandGateway, QueryGateway queryGateway, TestRepo repo) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
        this.repo = repo;
    }

    @PostMapping("/generate")
    public void generate() {
        Random r = new Random();
        int count = r.nextInt(40)+20;

        for(int i = 0; count > i; i++) {
            String commandId = UUID.randomUUID().toString();
            commandGateway.send(
                    new CreateObject(commandId,generateRandomString(15))
            );
        }
    }


    @PostMapping("/drop")
    public void drop() {
        repo.deleteAll();
    }

    @PostMapping("/rebuild")
    public void rebuild() {

    }



    private String generateRandomString(int size) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(size)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
