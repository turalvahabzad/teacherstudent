package teacher.entity;

import comman.Person;

import java.io.Serializable;

public class Teacher extends Person implements Serializable {
    private String name;
    private String surname;
    private Integer age;
    private Double salary;


    public Teacher() {

    }

    public Teacher(String name, String surname, Integer age, Double salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return name + " " + surname + " " + age;

    }


}
