package org.aioba.test;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.GUIDGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="Business")
public class Business {

    @Id
    UUID guid;

    String name;
    Integer age;
    Double salary;

    @Override
    public String toString() {
        return "Business{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public Business(){

    }

    public Business(String name, Integer age, Double salary){
        this.guid = UUID.randomUUID();
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {

        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getGuid() {

        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }
}
