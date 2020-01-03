package com.example.demoeventsourcing.Model;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class TestObject {

    @Id
    @GeneratedValue
    private int id;
    private String message;

    public TestObject(String message) {
        this.message = message;
    }

    public TestObject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestObject)) return false;
        TestObject that = (TestObject) o;
        return id == that.id &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message);
    }
}
