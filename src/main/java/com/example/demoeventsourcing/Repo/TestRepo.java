package com.example.demoeventsourcing.Repo;

import com.example.demoeventsourcing.Model.TestObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends CrudRepository<TestObject, Integer> {
}
